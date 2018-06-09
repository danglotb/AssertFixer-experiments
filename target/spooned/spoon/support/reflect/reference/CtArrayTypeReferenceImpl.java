package spoon.support.reflect.reference;


public class CtArrayTypeReferenceImpl<T> extends spoon.support.reflect.reference.CtTypeReferenceImpl<T> implements spoon.reflect.reference.CtArrayTypeReference<T> {
    private static final long serialVersionUID = 1L;

    @spoon.reflect.annotations.MetamodelPropertyField(role = spoon.reflect.path.CtRole.TYPE)
    spoon.reflect.reference.CtTypeReference<?> componentType;

    public CtArrayTypeReferenceImpl() {
        super();
    }

    @java.lang.Override
    public void accept(spoon.reflect.visitor.CtVisitor visitor) {
        visitor.visitCtArrayTypeReference(this);
    }

    @java.lang.Override
    public spoon.reflect.reference.CtTypeReference<?> getComponentType() {
        if ((componentType) == null) {
            componentType = getFactory().Type().OBJECT;
        }
        return componentType;
    }

    @java.lang.Override
    public spoon.reflect.reference.CtTypeReference<?> getArrayType() {
        return getLastComponentTypeReference(componentType);
    }

    private spoon.reflect.reference.CtTypeReference<?> getLastComponentTypeReference(spoon.reflect.reference.CtTypeReference<?> component) {
        return component instanceof spoon.reflect.reference.CtArrayTypeReference ? getLastComponentTypeReference(((spoon.reflect.reference.CtArrayTypeReference) (component)).getComponentType()) : component;
    }

    @java.lang.Override
    public <C extends spoon.reflect.reference.CtArrayTypeReference<T>> C setComponentType(spoon.reflect.reference.CtTypeReference<?> componentType) {
        if (componentType != null) {
            componentType.setParent(this);
        }
        getFactory().getEnvironment().getModelChangeListener().onObjectUpdate(this, spoon.reflect.path.CtRole.TYPE, componentType, this.componentType);
        this.componentType = componentType;
        return ((C) (this));
    }

    @java.lang.Override
    public java.lang.String getSimpleName() {
        return (getComponentType().getSimpleName()) + "[]";
    }

    @java.lang.Override
    public java.lang.String getQualifiedName() {
        return (getComponentType().getQualifiedName()) + "[]";
    }

    @java.lang.SuppressWarnings("unchecked")
    @java.lang.Override
    public java.lang.Class<T> getActualClass() {
        java.lang.Class<?> c = getComponentType().getActualClass();
        if (c == null) {
            throw new spoon.support.SpoonClassNotFoundException((("you should never call getActualClass! (" + (getComponentType().getQualifiedName())) + " not found in the classpath)"), null);
        }
        return ((java.lang.Class<T>) (java.lang.reflect.Array.newInstance(c, 0).getClass()));
    }

    @java.lang.Override
    public int getDimensionCount() {
        if ((getComponentType()) instanceof spoon.reflect.reference.CtArrayTypeReference) {
            return (((spoon.reflect.reference.CtArrayTypeReference<?>) (getComponentType())).getDimensionCount()) + 1;
        }
        return 1;
    }

    @java.lang.Override
    public spoon.reflect.reference.CtArrayTypeReference<T> clone() {
        return ((spoon.reflect.reference.CtArrayTypeReference<T>) (super.clone()));
    }
}

