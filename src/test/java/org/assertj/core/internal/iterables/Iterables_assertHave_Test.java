/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright 2012-2018 the original author or authors.
 */
package org.assertj.core.internal.iterables;

import static org.assertj.core.api.Assertions.assertThatNullPointerException;
import static org.assertj.core.error.ElementsShouldHave.elementsShouldHave;
import static org.assertj.core.test.TestData.someInfo;
import static org.assertj.core.test.TestFailures.failBecauseExpectedAssertionErrorWasNotThrown;
import static org.assertj.core.util.Lists.newArrayList;
import static org.mockito.Mockito.verify;

import org.assertj.core.api.AssertionInfo;
import org.assertj.core.internal.Iterables;
import org.assertj.core.internal.IterablesWithConditionsBaseTest;
import org.junit.jupiter.api.Test;


/**
 * Tests for <code>{@link Iterables#assertHave(AssertionInfo, Iterable, org.assertj.core.api.Condition)}</code> .
 * 
 * @author Nicolas François
 * @author Mikhail Mazursky
 * @author Joel Costigliola
 */
public class Iterables_assertHave_Test extends IterablesWithConditionsBaseTest {

  @Test
  public void should_pass_if_each_element_satisfies_condition() {
    actual = newArrayList("Yoda", "Luke");
    iterables.assertHave(someInfo(), actual, jediPower);
    verify(conditions).assertIsNotNull(jediPower);
  }

  @Test
  public void should_throw_error_if_condition_is_null() {
    assertThatNullPointerException().isThrownBy(() -> {
      actual = newArrayList("Yoda", "Luke");
      iterables.assertHave(someInfo(), actual, null);
    }).withMessage("The condition to evaluate should not be null");
  }

  @Test
  public void should_fail_if_condition_is_not_met() {
    testCondition.shouldMatch(false);
    AssertionInfo info = someInfo();
    try {
      actual = newArrayList("Yoda", "Luke", "Leia");
      iterables.assertHave(someInfo(), actual, jediPower);
    } catch (AssertionError e) {
      verify(conditions).assertIsNotNull(jediPower);
      verify(failures).failure(info, elementsShouldHave(actual, newArrayList("Leia"), jediPower));
      return;
    }
    failBecauseExpectedAssertionErrorWasNotThrown();
  }

}
