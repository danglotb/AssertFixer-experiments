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
package spoon.support.visitor.java.reflect;


/**
 * To be compatible with Java 6, RtParameter has been created from
 * the Parameter class in Java 8.
 */
public class RtParameter {
    private final java.lang.String name;

    private final java.lang.Class<?> type;

    private final java.lang.reflect.Type genericType;

    private final spoon.support.visitor.java.reflect.RtMethod method;

    private final java.lang.reflect.Constructor constructor;

    private final int index;

    public RtParameter(java.lang.String name, java.lang.Class<?> type, java.lang.reflect.Type genericType, spoon.support.visitor.java.reflect.RtMethod method, java.lang.reflect.Constructor constructor, int index) {
        this.name = name;
        this.type = type;
        this.genericType = genericType;
        this.method = method;
        this.constructor = constructor;
        this.index = index;
    }

    /**
     * Returns the name of the parameter.
     *
     * @return The name of the parameter, either provided by the class
     * file or synthesized if the class file does not provide
     * a name.
     */
    public java.lang.String getName() {
        // Note: empty strings as parameter names are now outlawed.
        // The .equals("") is for compatibility with current JVM
        // behavior.  It may be removed at some point.
        if (((name) == null) || (name.equals(""))) {
            return "arg" + (index);
        }else {
            return name;
        }
    }

    /**
     * Returns the {@code Class} which is the type of the parameter.
     *
     * @return The type of the parameter.
     */
    public java.lang.Class<?> getType() {
        return type;
    }

    public java.lang.reflect.Type getGenericType() {
        return genericType;
    }

    /**
     * Return annotations which declared on the parameter.
     *
     * @return Annotations declared on the parameter.
     */
    public java.lang.annotation.Annotation[] getDeclaredAnnotations() {
        if ((method) == null) {
            return constructor.getParameterAnnotations()[index];
        }
        return method.getParameterAnnotations()[index];
    }

    /**
     * Returns {@code true} if this parameter represents a variable
     * argument list; returns {@code false} otherwise.
     *
     * @return {@code true} if an only if this parameter represents a
     * variable argument list.
     */
    public boolean isVarArgs() {
        if ((method) == null) {
            return (constructor.isVarArgs()) && ((index) == ((constructor.getParameterTypes().length) - 1));
        }
        return (method.isVarArgs()) && ((index) == ((method.getParameterTypes().length) - 1));
    }

    /**
     * Compares based on the executable and the index.
     *
     * @param obj
     * 		The object to compare.
     * @return Whether or not this is equal to the argument.
     */
    public boolean equals(java.lang.Object obj) {
        if (obj instanceof spoon.support.visitor.java.reflect.RtParameter) {
            spoon.support.visitor.java.reflect.RtParameter other = ((spoon.support.visitor.java.reflect.RtParameter) (obj));
            if ((method) == null) {
                return (other.constructor.equals(constructor)) && ((other.index) == (index));
            }
            return (other.method.equals(method)) && ((other.index) == (index));
        }
        return false;
    }

    /**
     * Returns a hash code based on the executable's hash code and the
     * index.
     *
     * @return A hash code based on the executable's hash code.
     */
    public int hashCode() {
        if ((method) == null) {
            return (constructor.hashCode()) ^ (index);
        }
        return (method.hashCode()) ^ (index);
    }

    /**
     * Get parameters in a method to spoon parameters.
     *
     * @param method
     * 		Parent executable of parameters.
     * @return Parameters of the executable.
     */
    public static spoon.support.visitor.java.reflect.RtParameter[] parametersOf(spoon.support.visitor.java.reflect.RtMethod method) {
        spoon.support.visitor.java.reflect.RtParameter[] parameters = new spoon.support.visitor.java.reflect.RtParameter[method.getParameterTypes().length];
        for (int index = 0; index < (method.getParameterTypes().length); index++) {
            parameters[index] = new spoon.support.visitor.java.reflect.RtParameter(null, method.getParameterTypes()[index], method.getGenericParameterTypes()[index], method, null, index);
        }
        return parameters;
    }

    /**
     * Get parameters in a constructor to spoon parameters.
     *
     * @param constructor
     * 		Parent executable of parameters.
     * @return Parameters of the executable.
     */
    public static spoon.support.visitor.java.reflect.RtParameter[] parametersOf(java.lang.reflect.Constructor constructor) {
        spoon.support.visitor.java.reflect.RtParameter[] parameters;
        // Apparently getGenericParameterTypes and getParameterTypes could have different length
        // if the first parameter is implicit: a private non-static inner class will have an implicit parameter for its superclass
        // but it won't be present in the result of getGenericParameterTypes (e.g. ArrayList$SubList)
        // moreover if it's an enum, there will be 2 implicit parameters (String and int) we won't consider them in the model.
        int lengthGenericParameterTypes = constructor.getGenericParameterTypes().length;
        int lengthParameterTypes = constructor.getParameterTypes().length;
        int offset;
        if (lengthGenericParameterTypes == lengthParameterTypes) {
            parameters = new spoon.support.visitor.java.reflect.RtParameter[lengthParameterTypes];
            offset = 0;
        }else
            if (lengthGenericParameterTypes == (lengthParameterTypes - 1)) {
                parameters = new spoon.support.visitor.java.reflect.RtParameter[lengthGenericParameterTypes];
                offset = 1;
            }else
                if ((constructor.getDeclaringClass().isEnum()) && (lengthGenericParameterTypes == (lengthParameterTypes - 2))) {
                    parameters = new spoon.support.visitor.java.reflect.RtParameter[lengthGenericParameterTypes];
                    offset = 2;
                }else {
                    throw new spoon.SpoonException(((((("Error while analyzing parameters of constructor: " + constructor) + ". # of parameters: ") + lengthParameterTypes) + " - # of generic parameter types: ") + lengthGenericParameterTypes));
                }


        for (int index = 0; index < (constructor.getGenericParameterTypes().length); index++) {
            parameters[index] = new spoon.support.visitor.java.reflect.RtParameter(null, constructor.getParameterTypes()[(index + offset)], constructor.getGenericParameterTypes()[index], null, constructor, index);
        }
        return parameters;
    }
}

