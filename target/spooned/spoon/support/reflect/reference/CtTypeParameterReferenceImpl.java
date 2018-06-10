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
package spoon.support.reflect.reference;


public class CtTypeParameterReferenceImpl extends spoon.support.reflect.reference.CtTypeReferenceImpl<java.lang.Object> implements spoon.reflect.reference.CtTypeParameterReference {
    private static final long serialVersionUID = 1L;

    @spoon.reflect.annotations.MetamodelPropertyField(role = spoon.reflect.path.CtRole.BOUNDING_TYPE)
    spoon.reflect.reference.CtTypeReference<?> superType;

    @spoon.reflect.annotations.MetamodelPropertyField(role = spoon.reflect.path.CtRole.IS_UPPER)
    boolean upper = true;

    public CtTypeParameterReferenceImpl() {
        super();
        // calling null will set the default value of boundingType
        this.setBoundingType(null);
    }

    @java.lang.Override
    public boolean isDefaultBoundingType() {
        return getBoundingType().equals(getFactory().Type().getDefaultBoundingType());
    }

    @java.lang.Override
    public void accept(spoon.reflect.visitor.CtVisitor visitor) {
        visitor.visitCtTypeParameterReference(this);
    }

    @java.lang.Override
    public boolean isUpper() {
        return upper;
    }

    @java.lang.Override
    public <T extends spoon.reflect.reference.CtTypeParameterReference> T setBounds(java.util.List<spoon.reflect.reference.CtTypeReference<?>> bounds) {
        if ((bounds == null) || (bounds.isEmpty())) {
            setBoundingType(null);
            return ((T) (this));
        }
        if ((getBoundingType()) instanceof spoon.reflect.reference.CtIntersectionTypeReference<?>) {
            getBoundingType().asCtIntersectionTypeReference().setBounds(bounds);
        }else
            if ((bounds.size()) > 1) {
                final java.util.List<spoon.reflect.reference.CtTypeReference<?>> refs = new java.util.ArrayList<>();
                refs.addAll(bounds);
                setBoundingType(getFactory().Type().createIntersectionTypeReferenceWithBounds(refs));
            }else {
                setBoundingType(bounds.get(0));
            }

        return ((T) (this));
    }

    @java.lang.Override
    public <T extends spoon.reflect.reference.CtTypeParameterReference> T setUpper(boolean upper) {
        getFactory().getEnvironment().getModelChangeListener().onObjectUpdate(this, spoon.reflect.path.CtRole.IS_UPPER, upper, this.upper);
        this.upper = upper;
        return ((T) (this));
    }

    @java.lang.Override
    public boolean isPrimitive() {
        return false;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public java.lang.Class<java.lang.Object> getActualClass() {
        if (isUpper()) {
            if (isDefaultBoundingType()) {
                return ((java.lang.Class<java.lang.Object>) (getTypeErasure().getActualClass()));
            }
            return ((java.lang.Class<java.lang.Object>) (getBoundingType().getActualClass()));
        }
        throw new spoon.support.SpoonClassNotFoundException((("you should never call getActualClass  (" + (this.getQualifiedName())) + " not found in the classpath)"), null);
    }

    @java.lang.Override
    @spoon.support.DerivedProperty
    public java.util.List<spoon.reflect.reference.CtTypeReference<?>> getActualTypeArguments() {
        return spoon.support.reflect.declaration.CtElementImpl.emptyList();
    }

    @java.lang.Override
    @spoon.support.UnsettableProperty
    public <C extends spoon.reflect.reference.CtActualTypeContainer> C setActualTypeArguments(java.util.List<? extends spoon.reflect.reference.CtTypeReference<?>> actualTypeArguments) {
        return ((C) (this));
    }

    @java.lang.Override
    @spoon.support.UnsettableProperty
    public <C extends spoon.reflect.reference.CtActualTypeContainer> C addActualTypeArgument(spoon.reflect.reference.CtTypeReference<?> actualTypeArgument) {
        return ((C) (this));
    }

    @java.lang.Override
    @spoon.support.UnsettableProperty
    public boolean removeActualTypeArgument(spoon.reflect.reference.CtTypeReference<?> actualTypeArgument) {
        return false;
    }

    @java.lang.Override
    public <T extends spoon.reflect.reference.CtTypeParameterReference> T addBound(spoon.reflect.reference.CtTypeReference<?> bound) {
        if (bound == null) {
            return ((T) (this));
        }
        if (isDefaultBoundingType()) {
            setBoundingType(bound);
        }else
            if ((getBoundingType()) instanceof spoon.reflect.reference.CtIntersectionTypeReference<?>) {
                getBoundingType().asCtIntersectionTypeReference().addBound(bound);
            }else {
                final java.util.List<spoon.reflect.reference.CtTypeReference<?>> refs = new java.util.ArrayList<>();
                refs.add(getBoundingType());
                refs.add(bound);
                setBoundingType(getFactory().Type().createIntersectionTypeReferenceWithBounds(refs));
            }

        return ((T) (this));
    }

    @java.lang.Override
    public boolean removeBound(spoon.reflect.reference.CtTypeReference<?> bound) {
        if ((bound == null) || (isDefaultBoundingType())) {
            return false;
        }
        if ((getBoundingType()) instanceof spoon.reflect.reference.CtIntersectionTypeReference<?>) {
            return getBoundingType().asCtIntersectionTypeReference().removeBound(bound);
        }else {
            setBoundingType(null);
            return true;
        }
    }

    @java.lang.Override
    public spoon.reflect.reference.CtTypeReference<?> getBoundingType() {
        return superType;
    }

    @java.lang.Override
    public <T extends spoon.reflect.reference.CtTypeParameterReference> T setBoundingType(spoon.reflect.reference.CtTypeReference<?> superType) {
        if (superType != null) {
            superType.setParent(this);
        }
        // ugly but else make testSetterInNodes failed
        if (superType == null) {
            // if null, set bounding type to object
            superType = getFactory().Type().objectType();
            superType.setImplicit(true);
            superType.setParent(this);
        }
        getFactory().getEnvironment().getModelChangeListener().onObjectUpdate(this, spoon.reflect.path.CtRole.BOUNDING_TYPE, superType, this.superType);
        this.superType = superType;
        return ((T) (this));
    }

    @java.lang.Override
    protected java.lang.reflect.AnnotatedElement getActualAnnotatedElement() {
        // this is never annotated
        return null;
    }

    @java.lang.Override
    public spoon.reflect.declaration.CtTypeParameter getDeclaration() {
        if (!(isParentInitialized())) {
            return null;
        }
        spoon.reflect.declaration.CtElement e = this;
        spoon.reflect.declaration.CtElement parent = getParent();
        if (parent instanceof spoon.reflect.reference.CtTypeReference) {
            if (!(parent.isParentInitialized())) {
                // we might enter in that case because of a call
                // of getSuperInterfaces() for example
                spoon.reflect.reference.CtTypeReference typeReference = ((spoon.reflect.reference.CtTypeReference) (parent));
                e = typeReference.getTypeDeclaration();
                if (e == null) {
                    return null;
                }
            }else {
                parent = parent.getParent();
            }
        }
        if (parent instanceof spoon.reflect.reference.CtExecutableReference) {
            spoon.reflect.reference.CtExecutableReference parentExec = ((spoon.reflect.reference.CtExecutableReference) (parent));
            if (!(parentExec.getDeclaringType().equals(e))) {
                spoon.reflect.declaration.CtElement parent2 = parentExec.getExecutableDeclaration();
                if (parent2 instanceof spoon.reflect.declaration.CtMethod) {
                    e = parent2;
                }else {
                    e = e.getParent(spoon.reflect.declaration.CtFormalTypeDeclarer.class);
                }
            }else {
                e = e.getParent(spoon.reflect.declaration.CtFormalTypeDeclarer.class);
            }
        }else {
            if (!(e instanceof spoon.reflect.declaration.CtFormalTypeDeclarer)) {
                e = e.getParent(spoon.reflect.declaration.CtFormalTypeDeclarer.class);
            }
        }
        // case #1: we're a type of a method parameter, a local variable, ...
        // the strategy is to look in the parents
        // collecting all formal type declarers of the hierarchy
        while (e != null) {
            spoon.reflect.declaration.CtTypeParameter result = findTypeParamDeclaration(((spoon.reflect.declaration.CtFormalTypeDeclarer) (e)), this.getSimpleName());
            if (result != null) {
                return result;
            }
            e = e.getParent(spoon.reflect.declaration.CtFormalTypeDeclarer.class);
        } 
        return null;
    }

    private spoon.reflect.declaration.CtTypeParameter findTypeParamDeclaration(spoon.reflect.declaration.CtFormalTypeDeclarer type, java.lang.String refName) {
        for (spoon.reflect.declaration.CtTypeParameter typeParam : type.getFormalCtTypeParameters()) {
            if (typeParam.getSimpleName().equals(refName)) {
                return typeParam;
            }
        }
        return null;
    }

    @java.lang.Override
    public spoon.reflect.declaration.CtType<java.lang.Object> getTypeDeclaration() {
        return getDeclaration();
    }

    @java.lang.Override
    public spoon.reflect.reference.CtTypeReference<?> getTypeErasure() {
        spoon.reflect.declaration.CtTypeParameter typeParam = getDeclaration();
        if (typeParam == null) {
            throw new spoon.SpoonException("Cannot resolve type erasure of the type parameter reference, which is not able to found it's declaration.");
        }
        return typeParam.getTypeErasure();
    }

    @java.lang.Override
    public boolean isSubtypeOf(spoon.reflect.reference.CtTypeReference<?> type) {
        return getTypeDeclaration().isSubtypeOf(type);
    }

    @java.lang.Override
    public spoon.reflect.reference.CtTypeParameterReference clone() {
        return ((spoon.reflect.reference.CtTypeParameterReference) (super.clone()));
    }

    @java.lang.Override
    public boolean isGenerics() {
        if ((getDeclaration()) instanceof spoon.reflect.declaration.CtTypeParameter) {
            return true;
        }
        if (((getBoundingType()) != null) && (getBoundingType().isGenerics())) {
            return true;
        }
        return false;
    }
}

