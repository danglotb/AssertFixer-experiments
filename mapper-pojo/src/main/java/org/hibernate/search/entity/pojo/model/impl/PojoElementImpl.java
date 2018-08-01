/*
 * Hibernate Search, full-text search for your domain model
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.search.entity.pojo.model.impl;

import org.hibernate.search.entity.pojo.model.PojoElement;


/**
 * @author Yoann Rodiere
 */
public class PojoElementImpl implements PojoElement {

	private final Object root;

	public PojoElementImpl(Object root) {
		super();
		this.root = root;
	}

	Object get() {
		return root;
	}

}
