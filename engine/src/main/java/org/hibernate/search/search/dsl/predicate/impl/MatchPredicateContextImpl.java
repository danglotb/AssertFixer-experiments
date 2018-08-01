/*
 * Hibernate Search, full-text search for your domain model
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.search.search.dsl.predicate.impl;

import java.util.Arrays;
import java.util.function.Supplier;

import org.hibernate.search.search.dsl.predicate.MatchPredicateContext;
import org.hibernate.search.search.dsl.predicate.MatchPredicateFieldSetContext;
import org.hibernate.search.search.dsl.predicate.spi.SearchPredicateContributor;
import org.hibernate.search.search.predicate.spi.SearchPredicateFactory;


class MatchPredicateContextImpl<N, B> implements MatchPredicateContext<N>, SearchPredicateContributor<B> {

	private final MatchPredicateFieldSetContextImpl.CommonState<N, B> commonState;

	MatchPredicateContextImpl(SearchPredicateFactory<?, B> factory, Supplier<N> nextContextProvider) {
		this.commonState = new MatchPredicateFieldSetContextImpl.CommonState<>( factory, nextContextProvider );
	}

	@Override
	public MatchPredicateFieldSetContext<N> onFields(String ... absoluteFieldPaths) {
		return new MatchPredicateFieldSetContextImpl<>( commonState, Arrays.asList( absoluteFieldPaths ) );
	}

	@Override
	public B contribute() {
		return commonState.contribute();
	}
}
