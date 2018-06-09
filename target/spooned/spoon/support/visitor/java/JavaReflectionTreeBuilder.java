package spoon.support.visitor.java;


public class JavaReflectionTreeBuilder extends spoon.support.visitor.java.JavaReflectionVisitorImpl {
    private java.util.Deque<spoon.support.visitor.java.internal.RuntimeBuilderContext> contexts = new java.util.ArrayDeque<>();

    private spoon.reflect.factory.Factory factory;

    public JavaReflectionTreeBuilder(spoon.reflect.factory.Factory factory) {
        this.factory = factory;
    }

    private void enter(spoon.support.visitor.java.internal.RuntimeBuilderContext context) {
        contexts.push(context);
    }

    private spoon.support.visitor.java.internal.RuntimeBuilderContext exit() {
        return contexts.pop();
    }

    public <T, R extends spoon.reflect.declaration.CtType<T>> R scan(java.lang.Class<T> clazz) {
        spoon.reflect.declaration.CtPackage ctPackage;
        spoon.reflect.declaration.CtType<?> ctEnclosingClass;
        if ((clazz.getEnclosingClass()) != null) {
            ctEnclosingClass = scan(clazz.getEnclosingClass());
            return ctEnclosingClass.getNestedType(clazz.getSimpleName());
        }else {
            if ((clazz.getPackage()) == null) {
                ctPackage = factory.Package().getRootPackage();
            }else {
                ctPackage = factory.Package().getOrCreate(clazz.getPackage().getName());
            }
            if (contexts.isEmpty()) {
                enter(new spoon.support.visitor.java.internal.PackageRuntimeBuilderContext(ctPackage));
            }
            if (clazz.isAnnotation()) {
                visitAnnotationClass(((java.lang.Class<java.lang.annotation.Annotation>) (clazz)));
            }else
                if (clazz.isInterface()) {
                    visitInterface(clazz);
                }else
                    if (clazz.isEnum()) {
                        visitEnum(clazz);
                    }else {
                        visitClass(clazz);
                    }


            exit();
            final R type = ctPackage.getType(clazz.getSimpleName());
            if ((clazz.isPrimitive()) && ((type.getParent()) instanceof spoon.reflect.declaration.CtPackage)) {
                type.setParent(null);
            }
            return type;
        }
    }

    @java.lang.Override
    public void visitPackage(java.lang.Package aPackage) {
        final spoon.reflect.declaration.CtPackage ctPackage = factory.Package().getOrCreate(aPackage.getName());
        enter(new spoon.support.visitor.java.internal.PackageRuntimeBuilderContext(ctPackage));
        super.visitPackage(aPackage);
        exit();
        contexts.peek().addPackage(ctPackage);
    }

    @java.lang.Override
    public <T> void visitClass(java.lang.Class<T> clazz) {
        final spoon.reflect.declaration.CtClass ctClass = factory.Core().createClass();
        ctClass.setSimpleName(clazz.getSimpleName());
        setModifier(ctClass, clazz.getModifiers(), clazz.getDeclaringClass());
        enter(new spoon.support.visitor.java.internal.TypeRuntimeBuilderContext(clazz, ctClass) {
            @java.lang.Override
            public void addConstructor(spoon.reflect.declaration.CtConstructor<?> ctConstructor) {
                ctClass.addConstructor(ctConstructor);
            }

            @java.lang.Override
            public void addTypeReference(spoon.reflect.path.CtRole role, spoon.reflect.reference.CtTypeReference<?> typeReference) {
                switch (role) {
                    case SUPER_TYPE :
                        ctClass.setSuperclass(typeReference);
                        return;
                }
                super.addTypeReference(role, typeReference);
            }
        });
        super.visitClass(clazz);
        exit();
        contexts.peek().addType(ctClass);
    }

    @java.lang.Override
    public <T> void visitInterface(java.lang.Class<T> clazz) {
        final spoon.reflect.declaration.CtInterface<java.lang.Object> ctInterface = factory.Core().createInterface();
        ctInterface.setSimpleName(clazz.getSimpleName());
        setModifier(ctInterface, clazz.getModifiers(), clazz.getDeclaringClass());
        enter(new spoon.support.visitor.java.internal.TypeRuntimeBuilderContext(clazz, ctInterface));
        super.visitInterface(clazz);
        exit();
        contexts.peek().addType(ctInterface);
    }

    @java.lang.Override
    public <T> void visitEnum(java.lang.Class<T> clazz) {
        final spoon.reflect.declaration.CtEnum ctEnum = factory.Core().createEnum();
        ctEnum.setSimpleName(clazz.getSimpleName());
        setModifier(ctEnum, clazz.getModifiers(), clazz.getDeclaringClass());
        enter(new spoon.support.visitor.java.internal.TypeRuntimeBuilderContext(clazz, ctEnum) {
            @java.lang.Override
            public void addConstructor(spoon.reflect.declaration.CtConstructor<?> ctConstructor) {
                ctEnum.addConstructor(ctConstructor);
            }

            @java.lang.Override
            public void addEnumValue(spoon.reflect.declaration.CtEnumValue<?> ctEnumValue) {
                ctEnum.addEnumValue(ctEnumValue);
            }
        });
        super.visitEnum(clazz);
        exit();
        contexts.peek().addType(ctEnum);
    }

    @java.lang.Override
    public <T extends java.lang.annotation.Annotation> void visitAnnotationClass(java.lang.Class<T> clazz) {
        final spoon.reflect.declaration.CtAnnotationType<?> ctAnnotationType = factory.Core().createAnnotationType();
        ctAnnotationType.setSimpleName(clazz.getSimpleName());
        setModifier(ctAnnotationType, clazz.getModifiers(), clazz.getDeclaringClass());
        enter(new spoon.support.visitor.java.internal.TypeRuntimeBuilderContext(clazz, ctAnnotationType) {
            @java.lang.Override
            public void addMethod(spoon.reflect.declaration.CtMethod ctMethod) {
                final spoon.reflect.declaration.CtAnnotationMethod<java.lang.Object> field = factory.Core().createAnnotationMethod();
                field.setSimpleName(ctMethod.getSimpleName());
                field.setModifiers(ctMethod.getModifiers());
                field.setType(ctMethod.getType());
                ctAnnotationType.addMethod(field);
            }
        });
        super.visitAnnotationClass(clazz);
        exit();
        contexts.peek().addType(ctAnnotationType);
    }

    @java.lang.Override
    public void visitAnnotation(final java.lang.annotation.Annotation annotation) {
        final spoon.reflect.declaration.CtAnnotation<java.lang.annotation.Annotation> ctAnnotation = factory.Core().createAnnotation();
        enter(new spoon.support.visitor.java.internal.AnnotationRuntimeBuilderContext(ctAnnotation) {
            @java.lang.Override
            public void addMethod(spoon.reflect.declaration.CtMethod ctMethod) {
                try {
                    java.lang.Object value = annotation.annotationType().getMethod(ctMethod.getSimpleName()).invoke(annotation);
                    if (value instanceof java.lang.Object[]) {
                        java.lang.Object[] values = ((java.lang.Object[]) (value));
                        if ((values.length) == 1) {
                            value = values[0];
                        }
                    }
                    ctAnnotation.addValue(ctMethod.getSimpleName(), value);
                } catch (java.lang.Exception ignore) {
                    ctAnnotation.addValue(ctMethod.getSimpleName(), "");
                }
            }
        });
        super.visitAnnotation(annotation);
        exit();
        contexts.peek().addAnnotation(ctAnnotation);
    }

    @java.lang.Override
    public <T> void visitConstructor(java.lang.reflect.Constructor<T> constructor) {
        final spoon.reflect.declaration.CtConstructor<java.lang.Object> ctConstructor = factory.Core().createConstructor();
        ctConstructor.setBody(factory.Core().createBlock());
        setModifier(ctConstructor, constructor.getModifiers(), constructor.getDeclaringClass());
        enter(new spoon.support.visitor.java.internal.ExecutableRuntimeBuilderContext(constructor, ctConstructor));
        super.visitConstructor(constructor);
        exit();
        contexts.peek().addConstructor(ctConstructor);
    }

    @java.lang.Override
    public void visitMethod(spoon.support.visitor.java.reflect.RtMethod method, java.lang.annotation.Annotation parent) {
        final spoon.reflect.declaration.CtMethod<java.lang.Object> ctMethod = factory.Core().createMethod();
        ctMethod.setSimpleName(method.getName());
        if ((java.lang.reflect.Modifier.isAbstract(method.getModifiers())) == false) {
            ctMethod.setBody(factory.Core().createBlock());
        }
        setModifier(ctMethod, method.getModifiers(), method.getDeclaringClass());
        ctMethod.setDefaultMethod(method.isDefault());
        enter(new spoon.support.visitor.java.internal.ExecutableRuntimeBuilderContext(method.getMethod(), ctMethod));
        super.visitMethod(method, parent);
        exit();
        contexts.peek().addMethod(ctMethod);
    }

    @java.lang.Override
    public void visitField(java.lang.reflect.Field field) {
        final spoon.reflect.declaration.CtField<java.lang.Object> ctField = factory.Core().createField();
        ctField.setSimpleName(field.getName());
        setModifier(ctField, field.getModifiers(), field.getDeclaringClass());
        enter(new spoon.support.visitor.java.internal.VariableRuntimeBuilderContext(ctField));
        super.visitField(field);
        exit();
        contexts.peek().addField(ctField);
    }

    @java.lang.Override
    public void visitEnumValue(java.lang.reflect.Field field) {
        final spoon.reflect.declaration.CtEnumValue<java.lang.Object> ctEnumValue = factory.Core().createEnumValue();
        ctEnumValue.setSimpleName(field.getName());
        setModifier(ctEnumValue, field.getDeclaringClass().getModifiers(), field.getDeclaringClass().getDeclaringClass());
        enter(new spoon.support.visitor.java.internal.VariableRuntimeBuilderContext(ctEnumValue));
        super.visitEnumValue(field);
        exit();
        contexts.peek().addEnumValue(ctEnumValue);
    }

    @java.lang.Override
    public void visitParameter(spoon.support.visitor.java.reflect.RtParameter parameter) {
        final spoon.reflect.declaration.CtParameter ctParameter = factory.Core().createParameter();
        ctParameter.setSimpleName(parameter.getName());
        ctParameter.setVarArgs(parameter.isVarArgs());
        enter(new spoon.support.visitor.java.internal.VariableRuntimeBuilderContext(ctParameter));
        super.visitParameter(parameter);
        exit();
        contexts.peek().addParameter(ctParameter);
    }

    @java.lang.Override
    public <T extends java.lang.reflect.GenericDeclaration> void visitTypeParameter(java.lang.reflect.TypeVariable<T> parameter) {
        java.lang.reflect.GenericDeclaration genericDeclaration = parameter.getGenericDeclaration();
        java.util.Iterator<spoon.support.visitor.java.internal.RuntimeBuilderContext> contextIterator = contexts.iterator();
        while (contextIterator.hasNext()) {
            spoon.reflect.declaration.CtTypeParameter typeParameter = contextIterator.next().getTypeParameter(genericDeclaration, parameter.getName());
            if (typeParameter != null) {
                contexts.peek().addFormalType(typeParameter.clone());
                return;
            }
        } 
        final spoon.reflect.declaration.CtTypeParameter typeParameter = factory.Core().createTypeParameter();
        typeParameter.setSimpleName(parameter.getName());
        enter(new spoon.support.visitor.java.internal.TypeRuntimeBuilderContext(parameter, typeParameter) {
            @java.lang.SuppressWarnings("incomplete-switch")
            @java.lang.Override
            public void addTypeReference(spoon.reflect.path.CtRole role, spoon.reflect.reference.CtTypeReference<?> typeReference) {
                switch (role) {
                    case SUPER_TYPE :
                        if ((typeParameter.getSuperclass()) != null) {
                            typeParameter.setSuperclass(typeParameter.getFactory().createIntersectionTypeReferenceWithBounds(java.util.Arrays.asList(typeParameter.getSuperclass(), typeReference)));
                        }else {
                            typeParameter.setSuperclass(typeReference);
                        }
                        return;
                }
                super.addTypeReference(role, typeReference);
            }
        });
        super.visitTypeParameter(parameter);
        exit();
        contexts.peek().addFormalType(typeParameter);
    }

    @java.lang.Override
    public <T extends java.lang.reflect.GenericDeclaration> void visitTypeParameterReference(spoon.reflect.path.CtRole role, java.lang.reflect.TypeVariable<T> parameter) {
        final spoon.reflect.reference.CtTypeParameterReference typeParameterReference = factory.Core().createTypeParameterReference();
        typeParameterReference.setSimpleName(parameter.getName());
        spoon.support.visitor.java.internal.RuntimeBuilderContext runtimeBuilderContext = new spoon.support.visitor.java.internal.TypeReferenceRuntimeBuilderContext(parameter, typeParameterReference);
        if (contexts.contains(runtimeBuilderContext)) {
            exit();
            enter(new spoon.support.visitor.java.internal.TypeReferenceRuntimeBuilderContext(java.lang.Object.class, factory.Type().OBJECT));
            return;
        }
        java.lang.reflect.GenericDeclaration genericDeclaration = parameter.getGenericDeclaration();
        java.util.Iterator<spoon.support.visitor.java.internal.RuntimeBuilderContext> contextIterator = contexts.iterator();
        while (contextIterator.hasNext()) {
            spoon.reflect.declaration.CtTypeParameter typeParameter = contextIterator.next().getTypeParameter(genericDeclaration, parameter.getName());
            if (typeParameter != null) {
                contexts.peek().addTypeReference(role, typeParameter.getReference());
                return;
            }
        } 
        enter(runtimeBuilderContext);
        super.visitTypeParameterReference(role, parameter);
        exit();
        contexts.peek().addTypeReference(role, typeParameterReference);
    }

    @java.lang.Override
    public void visitTypeReference(spoon.reflect.path.CtRole role, java.lang.reflect.ParameterizedType type) {
        final spoon.reflect.reference.CtTypeReference<?> ctTypeReference = factory.Core().createTypeReference();
        ctTypeReference.setSimpleName(((java.lang.Class) (type.getRawType())).getSimpleName());
        spoon.support.visitor.java.internal.RuntimeBuilderContext context = new spoon.support.visitor.java.internal.TypeReferenceRuntimeBuilderContext(type, ctTypeReference) {
            @java.lang.Override
            public void addType(spoon.reflect.declaration.CtType<?> aType) {
                this.getClass();
            }
        };
        enter(context);
        super.visitTypeReference(role, type);
        boolean contextStillExisting = false;
        for (spoon.support.visitor.java.internal.RuntimeBuilderContext context1 : contexts) {
            contextStillExisting = contextStillExisting || (context1 == context);
        }
        exit();
        if (contextStillExisting) {
            contexts.peek().addTypeReference(role, ctTypeReference);
        }
    }

    @java.lang.Override
    public void visitTypeReference(spoon.reflect.path.CtRole role, java.lang.reflect.WildcardType type) {
        final spoon.reflect.reference.CtWildcardReference wildcard = factory.Core().createWildcardReference();
        wildcard.setUpper(((((type.getLowerBounds()) != null) && ((type.getLowerBounds().length) > 0)) == false));
        enter(new spoon.support.visitor.java.internal.TypeReferenceRuntimeBuilderContext(type, wildcard));
        super.visitTypeReference(role, type);
        exit();
        contexts.peek().addTypeReference(role, wildcard);
    }

    private java.lang.String getTypeName(java.lang.reflect.Type type) {
        if (type instanceof java.lang.Class) {
            java.lang.Class clazz = ((java.lang.Class) (type));
            if (clazz.isArray()) {
                try {
                    java.lang.Class<?> cl = clazz;
                    int dimensions = 0;
                    while (cl.isArray()) {
                        dimensions++;
                        cl = cl.getComponentType();
                    } 
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append(cl.getName());
                    for (int i = 0; i < dimensions; i++) {
                        sb.append("[]");
                    }
                    return sb.toString();
                } catch (java.lang.Throwable e) {
                }
            }else {
                visitPackage(clazz.getPackage());
            }
            return clazz.getSimpleName();
        }
        return type.toString();
    }

    @java.lang.Override
    public <T> void visitArrayReference(spoon.reflect.path.CtRole role, final java.lang.reflect.Type typeArray) {
        final spoon.reflect.reference.CtArrayTypeReference<?> arrayTypeReference = factory.Core().createArrayTypeReference();
        enter(new spoon.support.visitor.java.internal.TypeReferenceRuntimeBuilderContext(typeArray, arrayTypeReference) {
            @java.lang.Override
            public void addTypeReference(spoon.reflect.path.CtRole role, spoon.reflect.reference.CtTypeReference<?> typeReference) {
                switch (role) {
                    case DECLARING_TYPE :
                        arrayTypeReference.setDeclaringType(typeReference);
                        return;
                }
                arrayTypeReference.setComponentType(typeReference);
            }
        });
        super.visitArrayReference(role, typeArray);
        exit();
        contexts.peek().addTypeReference(role, arrayTypeReference);
    }

    @java.lang.Override
    public <T> void visitTypeReference(spoon.reflect.path.CtRole role, java.lang.Class<T> clazz) {
        final spoon.reflect.reference.CtTypeReference<java.lang.Object> typeReference = factory.Core().createTypeReference();
        typeReference.setSimpleName(clazz.getSimpleName());
        enter(new spoon.support.visitor.java.internal.TypeReferenceRuntimeBuilderContext(clazz, typeReference));
        super.visitTypeReference(role, clazz);
        exit();
        contexts.peek().addTypeReference(role, typeReference);
    }

    private void setModifier(spoon.reflect.declaration.CtModifiable ctModifiable, int modifiers, java.lang.Class<?> declaringClass) {
        if ((java.lang.reflect.Modifier.isAbstract(modifiers)) && (!(ctModifiable instanceof spoon.reflect.declaration.CtInterface))) {
            if (ctModifiable instanceof spoon.reflect.declaration.CtEnum) {
            }else
                if (isInterface(declaringClass)) {
                }else {
                    ctModifiable.addModifier(spoon.reflect.declaration.ModifierKind.ABSTRACT);
                }

        }
        if (java.lang.reflect.Modifier.isFinal(modifiers)) {
            ctModifiable.addModifier(spoon.reflect.declaration.ModifierKind.FINAL);
        }
        if (java.lang.reflect.Modifier.isNative(modifiers)) {
            ctModifiable.addModifier(spoon.reflect.declaration.ModifierKind.NATIVE);
        }
        if (java.lang.reflect.Modifier.isPrivate(modifiers)) {
            ctModifiable.addModifier(spoon.reflect.declaration.ModifierKind.PRIVATE);
        }
        if (java.lang.reflect.Modifier.isProtected(modifiers)) {
            ctModifiable.addModifier(spoon.reflect.declaration.ModifierKind.PROTECTED);
        }
        if (java.lang.reflect.Modifier.isPublic(modifiers)) {
            if (isInterface(declaringClass)) {
            }else {
                ctModifiable.addModifier(spoon.reflect.declaration.ModifierKind.PUBLIC);
            }
        }
        if (java.lang.reflect.Modifier.isStatic(modifiers)) {
            if (ctModifiable instanceof spoon.reflect.declaration.CtEnum) {
            }else {
                ctModifiable.addModifier(spoon.reflect.declaration.ModifierKind.STATIC);
            }
        }
        if (java.lang.reflect.Modifier.isStrict(modifiers)) {
            ctModifiable.addModifier(spoon.reflect.declaration.ModifierKind.STRICTFP);
        }
        if (java.lang.reflect.Modifier.isSynchronized(modifiers)) {
            ctModifiable.addModifier(spoon.reflect.declaration.ModifierKind.SYNCHRONIZED);
        }
        if (java.lang.reflect.Modifier.isTransient(modifiers)) {
            if (ctModifiable instanceof spoon.reflect.declaration.CtField) {
                ctModifiable.addModifier(spoon.reflect.declaration.ModifierKind.TRANSIENT);
            }else
                if (ctModifiable instanceof spoon.reflect.declaration.CtExecutable) {
                }else {
                    throw new java.lang.UnsupportedOperationException();
                }

        }
        if (java.lang.reflect.Modifier.isVolatile(modifiers)) {
            ctModifiable.addModifier(spoon.reflect.declaration.ModifierKind.VOLATILE);
        }
    }

    private boolean isInterface(java.lang.Class<?> clazz) {
        return (clazz != null) && (clazz.isInterface());
    }
}

