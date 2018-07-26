/*
 * Hibernate Search, full-text search for your domain model
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.search.metadata;

import java.util.Set;

import org.hibernate.search.engine.BoostStrategy;
import org.hibernate.search.spi.IndexedTypeIdentifier;

/**
 * Top level descriptor of the metadata API. Giving access to the indexing information for a single type.
 *
 * @author Hardy Ferentschik
 */
public interface IndexedTypeDescriptor extends FieldContributor {

	/**
	 * @deprecated Use {@link #getIndexedType()} instead. This method will be removed.
	 * @return the type for which this descriptor provides meta information
	 */
	@Deprecated
	Class<?> getType();

	/**
	 * @return the type for which this descriptor provides meta information
	 */
	IndexedTypeIdentifier getIndexedType();

	/**
	 * @return {@code true} if the type for this descriptor is indexed, {@code false} otherwise
	 */
	boolean isIndexed();

	/**
	 * @return {@code true} is this index is sharded, {@code false} otherwise
	 */
	boolean isSharded();

	/**
	 * Returns a set of {@code IndexDescriptor} instances describing Lucene index information, in particular the index name.
	 * The index name can also be used to retrieve the actual {@code IndexManager} for this index via
	 * <pre>{@code
	 *   ExtendedSearchIntegrator integrator = ...
	 *   IndexManager indexManager = integrator.getIndexManagerHolder().getIndexManager(String)
	 * }</pre>
	 *
	 * For non sharded indexes there will be only a single {@code IndexDescriptor}. The empty set is returned for an unindexed type
	 * @return a set of {@code IndexDescriptor} instances describing Lucene index information
	 * @see org.hibernate.search.engine.integration.impl.ExtendedSearchIntegrator
	 */
	Set<IndexDescriptor> getIndexDescriptors();

	/**
	 * @return the class boost value, 1 being the default.
	 *
	 * @deprecated Index-time boosting will not be possible anymore starting from Lucene 7.
	 * You should use query-time boosting instead, for instance by calling
	 * {@link org.hibernate.search.query.dsl.FieldCustomization#boostedTo(float) boostedTo(float)}
	 * when building queries with the Hibernate Search query DSL.
	 */
	@Deprecated
	float getStaticBoost();

	/**
	 * @return Dynamic boost strategy. There will always be a boost strategy, but the default strategy will apply a
	 *         boost of 1.0.
	 *
	 * @deprecated Index-time boosting will not be possible anymore starting from Lucene 7.
	 * You should use query-time boosting instead, for instance by calling
	 * {@link org.hibernate.search.query.dsl.FieldCustomization#boostedTo(float) boostedTo(float)}
	 * when building queries with the Hibernate Search query DSL.
	 */
	@Deprecated
	BoostStrategy getDynamicBoost();

	/**
	 * @return the set of indexed properties in form of {@code PropertyDescriptor}s
	 */
	Set<PropertyDescriptor> getIndexedProperties();

	/**
	 * Retrieves the property descriptor for a given property name.
	 *
	 * @param propertyName the property name for which to return descriptor, cannot be {@code null}
	 *
	 * @return the property descriptor for the specified property name. {@code null} is returned in case a property with
	 *         the specified name does not exist
	 *
	 * @throws IllegalArgumentException in case {@code propertyName} is {@code null}
	 */
	PropertyDescriptor getProperty(String propertyName);

	/**
	 * Retrieves the field descriptor for a given field name.
	 *
	 * @param fieldName the field name for which to return descriptor, cannot be {@code null}
	 *
	 * @return the field descriptor for the specified field name. {@code null} is returned in case a field with the specified name does not exist
	 *
	 * @throws IllegalArgumentException in case {@code fieldName} is {@code null}
	 */
	FieldDescriptor getIndexedField(String fieldName);

	/**
	 * Returns the set of index descriptors for the indexed field generated by the property with the given name.
	 *
	 * @param propertyName the property name, cannot be {@code null}
	 *
	 * @return the set of index descriptors for the indexed field generated by the property with the given name. The empty set
	 *         is returned in case the property does not exist or does not produce any indexed fields.
	 *
	 * @throws IllegalArgumentException in case {@code propertyName} is {@code null}
	 */
	Set<FieldDescriptor> getFieldsForProperty(String propertyName);
}
