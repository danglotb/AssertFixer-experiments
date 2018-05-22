/*
 * Copyright 2013 Proofpoint Inc.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.kairosdb.client.builder;

import org.junit.Test;

public class QueryMetricTest
{
	@Test(expected = NullPointerException.class)
	public void test_constructor_NullName_Invalid()
	{
		new QueryMetric(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_constructor_EmptyName_Invalid()
	{
		new QueryMetric("");
	}

	@Test(expected = NullPointerException.class)
	public void test_addTag_nullName_Invalid()
	{
		QueryMetric queryMetric = new QueryMetric("metric");

		queryMetric.addTag(null, "value");
	}

	@Test(expected = NullPointerException.class)
	public void testAddTags_nullMap_invalid()
	{
		QueryMetric queryMetric = new QueryMetric("metric");

		queryMetric.addTags(null);
	}

	@Test(expected = NullPointerException.class)
	public void testAddMultiValuedTags_nullMap_invalid()
	{
		QueryMetric queryMetric = new QueryMetric("metric");

		queryMetric.addMultiValuedTags(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_addTag_emptyName_Invalid()
	{
		QueryMetric queryMetric = new QueryMetric("metric");

		queryMetric.addTag("", "value");
	}

	@Test(expected = NullPointerException.class)
	public void test_addTag_nullValue_Invalid()
	{
		QueryMetric queryMetric = new QueryMetric("metric");

		queryMetric.addTag("tag", (String)null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_addTag_emptyValue_Invalid()
	{
		QueryMetric queryMetric = new QueryMetric("metric");

		queryMetric.addTag("tag", "");
	}

	@Test(expected = NullPointerException.class)
	public void test_nullAggregator_invalid()
	{
		QueryMetric queryMetric = new QueryMetric("metric");

		queryMetric.addAggregator(null);
	}

	@Test(expected = NullPointerException.class)
	public void test_nullGrouper_invalid()
	{
		QueryMetric queryMetric = new QueryMetric("metric");

		queryMetric.addGrouper(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_setLimit_lessThanZero_invalid()
	{
		QueryMetric queryMetric = new QueryMetric("metric");

		queryMetric.setLimit(0);
	}
}