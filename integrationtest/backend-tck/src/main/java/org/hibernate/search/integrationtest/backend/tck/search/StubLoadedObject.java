/*
 * Hibernate Search, full-text search for your domain model
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.search.integrationtest.backend.tck.search;

import org.hibernate.search.search.DocumentReference;

class StubLoadedObject {
	private final DocumentReference documentReference;

	StubLoadedObject(DocumentReference documentReference) {
		this.documentReference = documentReference;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "["
				+ "documentReference=" + documentReference
				+ "]";
	}
}
