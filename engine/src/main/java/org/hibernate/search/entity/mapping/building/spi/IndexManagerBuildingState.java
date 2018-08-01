/*
 * Hibernate Search, full-text search for your domain model
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.search.entity.mapping.building.spi;

import org.hibernate.search.backend.document.DocumentElement;
import org.hibernate.search.backend.index.spi.IndexManager;

/**
 * @author Yoann Rodiere
 */
public interface IndexManagerBuildingState<D extends DocumentElement> {

	String getIndexName();

	IndexModelBindingContext getRootBindingContext();

	IndexManager<D> build();

}
