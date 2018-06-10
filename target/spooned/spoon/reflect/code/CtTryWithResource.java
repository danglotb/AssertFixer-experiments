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
 * This code element defines a <code>try</code> with resource statement.
 *
 * Example:
 * <pre>
 *    // br is the resource
 *    try (java.io.BufferedReader br = new java.io.BufferedReader(new java.io.FileReader("/foo"))) {
 *    	br.readLine();
 *   }
 * </pre>
 */
public interface CtTryWithResource extends spoon.reflect.code.CtTry {
    /**
     * Gets the auto-closeable resources of this <code>try</code>. Available
     * from Java 7 with the <i>try-with-resource</i> statement.
     */
    @spoon.reflect.annotations.PropertyGetter(role = spoon.reflect.path.CtRole.TRY_RESOURCE)
    java.util.List<spoon.reflect.code.CtLocalVariable<?>> getResources();

    /**
     * Sets the auto-closeable resources of this <code>try</code>. Available
     * from Java 7 with the <i>try-with-resource</i> statement.
     */
    @spoon.reflect.annotations.PropertySetter(role = spoon.reflect.path.CtRole.TRY_RESOURCE)
    <T extends spoon.reflect.code.CtTryWithResource> T setResources(java.util.List<spoon.reflect.code.CtLocalVariable<?>> resources);

    /**
     * Adds a resource.
     */
    @spoon.reflect.annotations.PropertySetter(role = spoon.reflect.path.CtRole.TRY_RESOURCE)
    <T extends spoon.reflect.code.CtTryWithResource> T addResource(spoon.reflect.code.CtLocalVariable<?> resource);

    /**
     * Removes a resource.
     */
    @spoon.reflect.annotations.PropertySetter(role = spoon.reflect.path.CtRole.TRY_RESOURCE)
    boolean removeResource(spoon.reflect.code.CtLocalVariable<?> resource);

    @java.lang.Override
    spoon.reflect.code.CtTryWithResource clone();
}

