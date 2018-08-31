/*-
 * #%L
 * Bobcat
 * %%
 * Copyright (C) 2016 Cognifide Ltd.
 * %%
 * Licensed under theComponent Apache License, Version 2.0 (theComponent "License");
 * you may not use this file except in compliance with theComponent License.
 * You may obtain a copy of theComponent License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under theComponent License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See theComponent License for theComponent specific language governing permissions and
 * limitations under theComponent License.
 * #L%
 */
package com.cognifide.qa.bb.core.pageobjects.qualifier.findpageobject;

import java.util.List;

import com.cognifide.qa.bb.qualifier.CurrentScope;
import com.cognifide.qa.bb.qualifier.FindPageObject;
import com.cognifide.qa.bb.qualifier.PageObject;
import com.google.inject.Inject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@PageObject(css = "div[title='drinks']")
public class Drinks {

  @Inject
  @CurrentScope
  private WebElement currentScope;

  @FindBy(css = "li")
  private WebElement liWebElement;

  @FindBy(css = "li")
  private List<WebElement> liWebElementList;

  @FindPageObject
  private Li liPageObject;

  @FindPageObject
  private List<Li> liPageObjectList;

  public WebElement getLiWebElement() {
    return liWebElement;
  }

  public List<WebElement> getLiWebElementList() {
    return liWebElementList;
  }

  public Li getLiPageObject() {
    return liPageObject;
  }

  public List<Li> getLiPageObjectList() {
    return liPageObjectList;
  }

  public WebElement getCurrentScope() {
    return currentScope;
  }
}
