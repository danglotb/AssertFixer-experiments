/*
 * Hibernate Search, full-text search for your domain model
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.search.test.analyzer.common;

import org.hibernate.search.analyzer.Discriminator;

/**
 * @author Hardy Ferentschik
 */
public class LanguageDiscriminator implements Discriminator {

	@Override
	public String getAnalyzerDefinitionName(Object value, Object entity, String field) {
		if ( value == null || !( entity instanceof Article ) ) {
			return null;
		}
		return (String) value;
	}
}
