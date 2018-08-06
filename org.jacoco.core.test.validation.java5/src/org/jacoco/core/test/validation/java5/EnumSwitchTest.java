/*******************************************************************************
 * Copyright (c) 2009, 2018 Mountainminds GmbH & Co. KG and Contributors
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Evgeny Mandrikov - initial API and implementation
 *
 *******************************************************************************/
package org.jacoco.core.test.validation.java5;

import org.jacoco.core.analysis.ICounter;
import org.jacoco.core.test.validation.ValidationTestBase;
import org.jacoco.core.test.validation.java5.targets.EnumSwitchTarget;
import org.junit.Test;

/**
 * Test of filtering of a synthetic class that is generated by javac for a enum
 * in switch statement.
 */
public class EnumSwitchTest extends ValidationTestBase {

	public EnumSwitchTest() {
		super(EnumSwitchTarget.class);
	}

	@Test
	public void testCoverageResult() {
		if (isJDKCompiler && JAVA_VERSION.isBefore("1.6")) {
			// class that holds "switch map" is not marked as synthetic when
			// compiling with javac 1.5
			assertLine("switch", ICounter.PARTLY_COVERED, 0, 2);
		} else {
			assertLine("switch", ICounter.FULLY_COVERED, 0, 2);
		}
	}

}
