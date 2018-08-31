/*-
 * #%L
 * Bobcat
 * %%
 * Copyright (C) 2018 Cognifide Ltd.
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
package com.cognifide.qa.bb.api.actors;

import java.util.Map;

import com.cognifide.qa.bb.api.actions.Action;
import com.cognifide.qa.bb.api.states.Assertion;

public interface Actor {

  void attemptsTo(Action... actions);

  void withAbilityTo(Class<? extends Ability> ability);

  <T extends Ability> T thatCan(Class<? extends T> ability);

  void should(Assertion... assertions);

  Map<Class<? extends Ability>, Ability> listAbilities();
}
