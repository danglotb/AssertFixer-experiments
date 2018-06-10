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
package spoon.reflect.code;


/**
 * This code element defines a <code>while</code> loop.
 *
 * Example:
 * <pre>
 *     int x = 0;
 *     while (x!=10) {
 *         x=x+1;
 *     };
 * </pre>
 */
public interface CtWhile extends spoon.reflect.code.CtLoop {
    /**
     * Gets the looping boolean test expression.
     */
    @spoon.reflect.annotations.PropertyGetter(role = spoon.reflect.path.CtRole.EXPRESSION)
    spoon.reflect.code.CtExpression<java.lang.Boolean> getLoopingExpression();

    /**
     * Sets the looping boolean test expression.
     */
    @spoon.reflect.annotations.PropertySetter(role = spoon.reflect.path.CtRole.EXPRESSION)
    <T extends spoon.reflect.code.CtWhile> T setLoopingExpression(spoon.reflect.code.CtExpression<java.lang.Boolean> expression);

    @java.lang.Override
    spoon.reflect.code.CtWhile clone();
}

