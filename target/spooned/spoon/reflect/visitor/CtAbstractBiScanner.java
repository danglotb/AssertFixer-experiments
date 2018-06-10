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
package spoon.reflect.visitor;


/**
 * Defines the core bi-scan responsibility.
 */
public abstract class CtAbstractBiScanner extends spoon.reflect.visitor.CtAbstractVisitor {
    /**
     * This method is called to compare `element` and `other` when traversing two trees in parallel.
     */
    public abstract void biScan(spoon.reflect.declaration.CtElement element, spoon.reflect.declaration.CtElement other);

    /**
     * This method is called to compare `element` and `other` according to the role when traversing two trees in parallel.
     */
    public abstract void biScan(spoon.reflect.path.CtRole role, spoon.reflect.declaration.CtElement element, spoon.reflect.declaration.CtElement other);
}

