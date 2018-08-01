/*
 * Hibernate Search, full-text search for your domain model
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.search.search.query.spi;

import java.util.function.Function;

import org.hibernate.search.search.SearchQuery;

/**
 * A builder for search queries.
 *
 * @param <T> The type of query results
 * @param <C> The type of query element collector
 */
public interface SearchQueryBuilder<T, C> {

	C getQueryElementCollector();

	void addRoutingKey(String routingKey);

	// TODO add more arguments, such as faceting options

	<Q> Q build(Function<SearchQuery<T>, Q> searchQueryWrapperFactory);

}
