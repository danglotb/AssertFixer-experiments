/*
 * Hibernate Search, full-text search for your domain model
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.search.backend.lucene.search.sort.impl;

import java.util.List;

import org.hibernate.search.search.SearchSort;

class LuceneSearchSort implements SearchSort {

	private final List<LuceneSearchSortBuilder> builders;

	LuceneSearchSort(List<LuceneSearchSortBuilder> builders) {
		this.builders = builders;
	}

	List<LuceneSearchSortBuilder> getBuilders() {
		return builders;
	}

}
