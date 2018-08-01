/*
 * Hibernate Search, full-text search for your domain model
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.search.search.predicate.spi;

/**
 * A search predicate builder, i.e. an object responsible for collecting parameters
 * and then building a search predicate.
 *
 * @param <B> The implementation type of the builder, which should expose a {@code build()} method.
 * This type is backend-specific, as the parameters to the build method may vary from one backend to another.
 */
public interface SearchPredicateBuilder<B> {

	void boost(float boost);

	/**
	 * @return An implementation-specific view of this builder,
	 * allowing the backend to call a {@code build()} method in particular.
	 */
	B toImplementation();
}
