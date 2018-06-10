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
package spoon.reflect.visitor.filter;


/**
 * Gets all overridden method from the method given.
 */
public class OverriddenMethodQuery implements spoon.reflect.visitor.chain.CtConsumableFunction<spoon.reflect.declaration.CtMethod<?>> {
    @java.lang.Override
    public void apply(spoon.reflect.declaration.CtMethod<?> input, spoon.reflect.visitor.chain.CtConsumer<java.lang.Object> outputConsumer) {
        spoon.reflect.declaration.CtPackage searchScope = input.getFactory().Package().getRootPackage();
        searchScope.filterChildren(new spoon.reflect.visitor.filter.OverriddenMethodFilter(input)).forEach(outputConsumer);
    }
}

