/*
 * Hibernate Search, full-text search for your domain model
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.search.entity.pojo.model.impl;

import java.util.stream.Stream;

import org.hibernate.search.entity.pojo.dirtiness.building.impl.PojoIndexingDependencyCollectorPropertyNode;
import org.hibernate.search.entity.pojo.dirtiness.building.impl.PojoIndexingDependencyCollectorTypeNode;
import org.hibernate.search.entity.pojo.dirtiness.building.impl.PojoIndexingDependencyCollectorValueNode;
import org.hibernate.search.entity.pojo.model.PojoModelElementAccessor;
import org.hibernate.search.entity.pojo.model.PojoModelProperty;
import org.hibernate.search.entity.pojo.model.additionalmetadata.building.impl.PojoTypeAdditionalMetadataProvider;
import org.hibernate.search.entity.pojo.model.additionalmetadata.impl.PojoPropertyAdditionalMetadata;
import org.hibernate.search.entity.pojo.model.path.impl.BoundPojoModelPathPropertyNode;
import org.hibernate.search.entity.pojo.model.path.impl.BoundPojoModelPathTypeNode;
import org.hibernate.search.entity.pojo.model.path.impl.BoundPojoModelPathValueNode;
import org.hibernate.search.entity.pojo.model.spi.PropertyHandle;

/**
 * @param <T> The type holding the property.
 * @param <P> The type of the property.
 */
class PojoModelNestedCompositeElement<T, P> extends AbstractPojoModelCompositeElement<P> implements PojoModelProperty {

	private final AbstractPojoModelCompositeElement<T> parent;
	private final BoundPojoModelPathValueNode<T, P, P> modelPath;
	private final PojoPropertyAdditionalMetadata propertyAdditionalMetadata;

	PojoModelNestedCompositeElement(AbstractPojoModelCompositeElement<T> parent, BoundPojoModelPathPropertyNode<T, P> modelPath,
			PojoPropertyAdditionalMetadata propertyAdditionalMetadata,
			PojoTypeAdditionalMetadataProvider typeAdditionalMetadataProvider) {
		super( typeAdditionalMetadataProvider );
		this.parent = parent;
		this.modelPath = modelPath.valueWithoutExtractors();
		this.propertyAdditionalMetadata = propertyAdditionalMetadata;
	}

	@Override
	public <M> Stream<M> markers(Class<M> markerType) {
		return propertyAdditionalMetadata.getMarkers( markerType );
	}

	@Override
	public String getName() {
		return modelPath.getParent().getPropertyModel().getName();
	}

	public void contributeDependencies(PojoIndexingDependencyCollectorTypeNode<T> dependencyCollector) {
		if ( hasAccessor() ) {
			@SuppressWarnings( "unchecked" ) // We used the same handle as in modelPath, on the same type. The result must have the same type.
			PojoIndexingDependencyCollectorPropertyNode<T, P> collectorPropertyNode =
					(PojoIndexingDependencyCollectorPropertyNode<T, P>) dependencyCollector.property( getHandle() );
			PojoIndexingDependencyCollectorValueNode<P, P> collectorValueNode =
					collectorPropertyNode.value( modelPath.getBoundExtractorPath() );
			collectorValueNode.collectDependency();
			contributePropertyDependencies( collectorValueNode.type() );
		}
	}

	@Override
	PojoModelElementAccessor<P> doCreateAccessor() {
		return new PojoModelPropertyElementAccessor<>( parent.createAccessor(), getHandle() );
	}

	@Override
	BoundPojoModelPathTypeNode<P> getModelPathTypeNode() {
		return modelPath.type();
	}

	PropertyHandle getHandle() {
		return modelPath.getParent().getPropertyHandle();
	}
}
