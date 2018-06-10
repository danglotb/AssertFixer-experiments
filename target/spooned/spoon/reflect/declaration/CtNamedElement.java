/**
 * Copyright (C) 2006-2017 INRIA and contributors
 * Spoon - http://spoon.gforge.inria.fr/
 *
 * This software is governed by the CeCILL-C License under French law and
 * abiding by the rules of distribution of free software. You can use, modify
 * and/or redistribute the software under the terms of the CeCILL-C license as
 * circulated by CEA, CNRS and INRIA at http://www.cecill.info.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the CeCILL-C License for more details.
 *
 * The fact that you are presently reading this means that you have had
 * knowledge of the CeCILL-C license and that you accept its terms.
 */
package spoon.reflect.declaration;


/**
 * Declares an element that has a name (a class, a method, a variable, etc).
 * Hence, all subclasses of CtNamedElement are in package "declaration".
 * Note that references don't define elements, hence are not under CtNamedElement
 * even if they also have methods set/getSimpleName.
 */
public interface CtNamedElement extends spoon.reflect.declaration.CtElement {
    /**
     * Returns the simple (unqualified) name of this element.
     */
    @spoon.reflect.annotations.PropertyGetter(role = spoon.reflect.path.CtRole.NAME)
    java.lang.String getSimpleName();

    /**
     * Sets the simple (unqualified) name of this element.
     */
    @spoon.reflect.annotations.PropertySetter(role = spoon.reflect.path.CtRole.NAME)
    <T extends spoon.reflect.declaration.CtNamedElement> T setSimpleName(java.lang.String simpleName);

    /**
     * Returns the corresponding reference.
     */
    @spoon.support.DerivedProperty
    spoon.reflect.reference.CtReference getReference();

    @java.lang.Override
    spoon.reflect.declaration.CtNamedElement clone();
}

