package io.konig.transform.sql.query;

/*
 * #%L
 * Konig Transform
 * %%
 * Copyright (C) 2015 - 2017 Gregory McFall
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */


import io.konig.core.io.PrettyPrintWriter;
import io.konig.sql.query.ValueExpression;
import io.konig.transform.IriTemplateInfo;
import io.konig.transform.ShapePath;

public class JoinIriTemplate extends JoinElement {
	
	private IriTemplateInfo templateInfo;

	public JoinIriTemplate(ShapePath shapePath, TableName tableName, IriTemplateInfo templateInfo) {
		super(shapePath, tableName);
		this.templateInfo = templateInfo;
	}

	@Override
	public ValueExpression valueExpression() {
		TableName tableName = getTableName();
		return QueryBuilder.idValue(tableName, templateInfo);
	}

	@Override
	protected void printFields(PrettyPrintWriter out) {
		
		out.field("templatInfo.template", templateInfo.getTemplate().toString());
		
	}

}
