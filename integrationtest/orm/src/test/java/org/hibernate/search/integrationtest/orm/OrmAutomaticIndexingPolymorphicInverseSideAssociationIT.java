/*
 * Hibernate Search, full-text search for your domain model
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.search.integrationtest.orm;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Transient;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.SessionFactoryBuilder;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.search.entity.orm.cfg.SearchOrmSettings;
import org.hibernate.search.entity.pojo.mapping.definition.annotation.Field;
import org.hibernate.search.entity.pojo.mapping.definition.annotation.Indexed;
import org.hibernate.search.entity.pojo.mapping.definition.annotation.IndexedEmbedded;
import org.hibernate.search.util.impl.integrationtest.common.rule.BackendMock;
import org.hibernate.search.util.impl.integrationtest.common.stub.backend.index.impl.StubBackendFactory;
import org.hibernate.search.util.impl.integrationtest.orm.OrmUtils;
import org.hibernate.service.ServiceRegistry;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

/**
 * Test automatic indexing based on Hibernate ORM entity events
 * when associations that are polymorphic on the inverse (contained) side are involved.
 */
public class OrmAutomaticIndexingPolymorphicInverseSideAssociationIT {

	private static final String PREFIX = SearchOrmSettings.PREFIX;

	@Rule
	public BackendMock backendMock = new BackendMock( "stubBackend" );

	private SessionFactory sessionFactory;

	@Before
	public void setup() {
		StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder()
				.applySetting( PREFIX + "backend.stubBackend.type", StubBackendFactory.class.getName() )
				.applySetting( PREFIX + "index.default.backend", "stubBackend" );

		ServiceRegistry serviceRegistry = registryBuilder.build();

		MetadataSources ms = new MetadataSources( serviceRegistry )
				.addAnnotatedClass( IndexedEntity.class )
				.addAnnotatedClass( ContainingEntity.class )
				.addAnnotatedClass( UnrelatedContainingEntity.class )
				.addAnnotatedClass( AbstractMiddleContainingEntity.class )
				.addAnnotatedClass( FirstMiddleContainingEntity.class )
				.addAnnotatedClass( SecondMiddleContainingEntity.class )
				.addAnnotatedClass( ContainedEntity.class );

		Metadata metadata = ms.buildMetadata();

		final SessionFactoryBuilder sfb = metadata.getSessionFactoryBuilder();

		backendMock.expectSchema( IndexedEntity.INDEX, b -> b
				.objectField( "child", b3 -> b3
						.objectField( "containedSingle", b2 -> b2
								.field( "includedInSingle", String.class )
						)
				)
		);

		sessionFactory = sfb.build();
		backendMock.verifyExpectationsMet();
	}

	@After
	public void cleanup() {
		if ( sessionFactory != null ) {
			sessionFactory.close();
		}
	}

	/**
	 * Check that, when resolving entities to reindex,
	 * we correctly ignore entities along the inverse path that we know cannot lead to an indexed entity,
	 * because of their concrete type.
	 */
	@Test
	public void inversePathIgnoresUnrelatedTypes() {
		OrmUtils.withinTransaction( sessionFactory, session -> {
			IndexedEntity indexedEntity = new IndexedEntity();
			indexedEntity.setId( 1 );

			FirstMiddleContainingEntity middleContainingEntity = new FirstMiddleContainingEntity();
			middleContainingEntity.setId( 2 );
			indexedEntity.setChild( middleContainingEntity );
			middleContainingEntity.setParentFromFirst( indexedEntity );

			/*
			 * The automatic indexing process should ignore this entity when processing
			 * containedEntity1.containingAsSingle.
			 * If it doesn't, there will be an error when trying to access unrelatedContainingEntity.parent.
			 */
			UnrelatedContainingEntity unrelatedContainingEntity = new UnrelatedContainingEntity();
			unrelatedContainingEntity.setId( 4 );

			ContainedEntity containedEntity1 = new ContainedEntity();
			containedEntity1.setId( 5 );
			containedEntity1.setIncludedInSingle( "initialValue" );
			middleContainingEntity.setContainedSingle( containedEntity1 );
			unrelatedContainingEntity.setContainedSingle( containedEntity1 );
			containedEntity1.getContainingAsSingle().add( middleContainingEntity );
			containedEntity1.getContainingAsSingle().add( unrelatedContainingEntity );

			session.persist( containedEntity1 );
			session.persist( middleContainingEntity );
			session.persist( unrelatedContainingEntity );
			session.persist( indexedEntity );

			backendMock.expectWorks( IndexedEntity.INDEX )
					.add( "1", b -> b
							.objectField( "child", b2 -> b2
									.objectField( "containedSingle", b3 -> b3
											.field( "includedInSingle", "initialValue" )
									)
							)
					)
					.preparedThenExecuted();
		} );
		backendMock.verifyExpectationsMet();

		// Test updating the value
		OrmUtils.withinTransaction( sessionFactory, session -> {
			ContainedEntity containedEntity = session.get( ContainedEntity.class, 5 );
			containedEntity.setIncludedInSingle( "updatedValue" );

			backendMock.expectWorks( IndexedEntity.INDEX )
					.update( "1", b -> b
							.objectField( "child", b2 -> b2
									.objectField( "containedSingle", b3 -> b3
											.field( "includedInSingle", "updatedValue" )
									)
							)
					)
					.preparedThenExecuted();
		} );
		backendMock.verifyExpectationsMet();
	}

	/**
	 * Check that, when resolving entities to reindex,
	 * we are able to choose the correct path for the inverse side of an association
	 * depending on the concrete type of entities.
	 * This is necessary because, when an indexed entity owns an association to an abstract, polymorphic type,
	 * the inverse side of this association may be defined differently depending on the concrete subtype.
	 */
	@Test
	public void inversePathDependsOnConcreteType() {
		OrmUtils.withinTransaction( sessionFactory, session -> {
			IndexedEntity indexedEntity1 = new IndexedEntity();
			indexedEntity1.setId( 1 );

			FirstMiddleContainingEntity middleContainingEntity1 = new FirstMiddleContainingEntity();
			middleContainingEntity1.setId( 2 );
			indexedEntity1.setChild( middleContainingEntity1 );
			middleContainingEntity1.setParentFromFirst( indexedEntity1 );

			IndexedEntity indexedEntity2 = new IndexedEntity();
			indexedEntity2.setId( 3 );

			/*
			 * The automatic indexing process should access the property "parentFromSecond"
			 * when a change happens in the contained entity.
			 * If it doesn't, indexedEntity2 will not be reindexed as required.
			 * If the automatic indexing process does not support defining the inverse side of associations
			 * differently depending on the subtype, either an error will happen at boot time,
			 * or a non-existing property will be accessed at runtime (in this case, probably parentFromFirst).
			 */
			SecondMiddleContainingEntity middleContainingEntity2 = new SecondMiddleContainingEntity();
			middleContainingEntity2.setId( 4 );
			indexedEntity2.setChild( middleContainingEntity2 );
			middleContainingEntity2.setParentFromSecond( indexedEntity2 );

			ContainedEntity containedEntity1 = new ContainedEntity();
			containedEntity1.setId( 5 );
			containedEntity1.setIncludedInSingle( "initialValue" );
			middleContainingEntity1.setContainedSingle( containedEntity1 );
			middleContainingEntity2.setContainedSingle( containedEntity1 );
			containedEntity1.getContainingAsSingle().add( middleContainingEntity1 );
			containedEntity1.getContainingAsSingle().add( middleContainingEntity2 );

			session.persist( containedEntity1 );
			session.persist( middleContainingEntity1 );
			session.persist( middleContainingEntity2 );
			session.persist( indexedEntity1 );
			session.persist( indexedEntity2 );

			backendMock.expectWorks( IndexedEntity.INDEX )
					.add( "1", b -> b
							.objectField( "child", b2 -> b2
									.objectField( "containedSingle", b3 -> b3
											.field( "includedInSingle", "initialValue" )
									)
							)
					)
					.add( "3", b -> b
							.objectField( "child", b2 -> b2
									.objectField( "containedSingle", b3 -> b3
											.field( "includedInSingle", "initialValue" )
									)
							)
					)
					.preparedThenExecuted();
		} );
		backendMock.verifyExpectationsMet();

		// Test updating the value
		OrmUtils.withinTransaction( sessionFactory, session -> {
			ContainedEntity containedEntity = session.get( ContainedEntity.class, 5 );
			containedEntity.setIncludedInSingle( "updatedValue" );

			backendMock.expectWorks( IndexedEntity.INDEX )
					.update( "1", b -> b
							.objectField( "child", b2 -> b2
									.objectField( "containedSingle", b3 -> b3
											.field( "includedInSingle", "updatedValue" )
									)
							)
					)
					.update( "3", b -> b
							.objectField( "child", b2 -> b2
									.objectField( "containedSingle", b3 -> b3
											.field( "includedInSingle", "updatedValue" )
									)
							)
					)
					.preparedThenExecuted();
		} );
		backendMock.verifyExpectationsMet();
	}

	@Entity(name = "indexed")
	@Indexed(index = IndexedEntity.INDEX)
	public static class IndexedEntity {
		static final String INDEX = "IndexedEntity";

		@Id
		private Integer id;

		@OneToOne
		@IndexedEmbedded
		private AbstractMiddleContainingEntity child;

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public AbstractMiddleContainingEntity getChild() {
			return child;
		}

		public void setChild(AbstractMiddleContainingEntity child) {
			this.child = child;
		}
	}

	@Entity(name = "containing")
	public static class ContainingEntity {
		@Id
		private Integer id;

		@ManyToOne
		@IndexedEmbedded
		private ContainedEntity containedSingle;

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public ContainedEntity getContainedSingle() {
			return containedSingle;
		}

		public void setContainedSingle(ContainedEntity containedSingle) {
			this.containedSingle = containedSingle;
		}
	}

	@Entity(name = "abstractmiddle")
	public abstract static class AbstractMiddleContainingEntity extends ContainingEntity {
	}

	@Entity(name = "firstmiddle")
	public static class FirstMiddleContainingEntity extends AbstractMiddleContainingEntity {
		@OneToOne(mappedBy = "child")
		private IndexedEntity parentFromFirst;

		public IndexedEntity getParentFromFirst() {
			return parentFromFirst;
		}

		public void setParentFromFirst(IndexedEntity parent) {
			this.parentFromFirst = parent;
		}
	}

	@Entity(name = "secondmiddle")
	public static class SecondMiddleContainingEntity extends AbstractMiddleContainingEntity {
		/*
		 * The name of this property must be different from the name in FirstMiddleContainingEntity.
		 * Also, this side must not own the association (must use "mappedBy").
		 */
		@OneToOne(mappedBy = "child")
		private IndexedEntity parentFromSecond;

		public IndexedEntity getParentFromSecond() {
			return parentFromSecond;
		}

		public void setParentFromSecond(IndexedEntity parent) {
			this.parentFromSecond = parent;
		}
	}

	@Entity(name = "unrelated")
	public static class UnrelatedContainingEntity extends ContainingEntity {
		@Transient
		public IndexedEntity getParent() {
			Assert.fail( "This method should never have been called" );
			return null; // Dead code
		}
	}

	@Entity(name = "contained")
	public static class ContainedEntity {

		@Id
		private Integer id;

		@OneToMany(mappedBy = "containedSingle")
		@OrderBy("id asc") // Make sure the iteration order is predictable
		private List<ContainingEntity> containingAsSingle = new ArrayList<>();

		@Basic
		@Field
		private String includedInSingle;

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public List<ContainingEntity> getContainingAsSingle() {
			return containingAsSingle;
		}

		public String getIncludedInSingle() {
			return includedInSingle;
		}

		public void setIncludedInSingle(String includedInSingle) {
			this.includedInSingle = includedInSingle;
		}
	}

}
