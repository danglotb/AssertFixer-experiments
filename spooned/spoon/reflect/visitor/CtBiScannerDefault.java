package spoon.reflect.visitor;


public class CtBiScannerDefault extends spoon.reflect.visitor.CtAbstractBiScanner {
    protected java.util.Deque<spoon.reflect.declaration.CtElement> stack = new java.util.ArrayDeque<>();

    protected void enter(spoon.reflect.declaration.CtElement e) {
    }

    protected void exit(spoon.reflect.declaration.CtElement e) {
    }

    public void biScan(spoon.reflect.declaration.CtElement element, spoon.reflect.declaration.CtElement other) {
        if (other == null) {
            return;
        }
        stack.push(other);
        try {
            element.accept(this);
        } finally {
            stack.pop();
        }
    }

    public void biScan(spoon.reflect.path.CtRole role, spoon.reflect.declaration.CtElement element, spoon.reflect.declaration.CtElement other) {
        biScan(element, other);
    }

    protected void biScan(spoon.reflect.path.CtRole role, java.util.Collection<? extends spoon.reflect.declaration.CtElement> elements, java.util.Collection<? extends spoon.reflect.declaration.CtElement> others) {
        for (java.util.Iterator<? extends spoon.reflect.declaration.CtElement> firstIt = elements.iterator(), secondIt = others.iterator(); (firstIt.hasNext()) && (secondIt.hasNext());) {
            biScan(role, firstIt.next(), secondIt.next());
        }
    }

    public <A extends java.lang.annotation.Annotation> void visitCtAnnotation(final spoon.reflect.declaration.CtAnnotation<A> annotation) {
        spoon.reflect.declaration.CtAnnotation other = ((spoon.reflect.declaration.CtAnnotation) (this.stack.peek()));
        enter(annotation);
        biScan(spoon.reflect.path.CtRole.TYPE, annotation.getType(), other.getType());
        biScan(spoon.reflect.path.CtRole.COMMENT, annotation.getComments(), other.getComments());
        biScan(spoon.reflect.path.CtRole.ANNOTATION_TYPE, annotation.getAnnotationType(), other.getAnnotationType());
        biScan(spoon.reflect.path.CtRole.ANNOTATION, annotation.getAnnotations(), other.getAnnotations());
        biScan(spoon.reflect.path.CtRole.VALUE, annotation.getValues().values(), other.getValues().values());
        exit(annotation);
    }

    public <A extends java.lang.annotation.Annotation> void visitCtAnnotationType(final spoon.reflect.declaration.CtAnnotationType<A> annotationType) {
        spoon.reflect.declaration.CtAnnotationType other = ((spoon.reflect.declaration.CtAnnotationType) (this.stack.peek()));
        enter(annotationType);
        biScan(spoon.reflect.path.CtRole.ANNOTATION, annotationType.getAnnotations(), other.getAnnotations());
        biScan(spoon.reflect.path.CtRole.TYPE_MEMBER, annotationType.getTypeMembers(), other.getTypeMembers());
        biScan(spoon.reflect.path.CtRole.COMMENT, annotationType.getComments(), other.getComments());
        exit(annotationType);
    }

    public void visitCtAnonymousExecutable(final spoon.reflect.declaration.CtAnonymousExecutable anonymousExec) {
        spoon.reflect.declaration.CtAnonymousExecutable other = ((spoon.reflect.declaration.CtAnonymousExecutable) (this.stack.peek()));
        enter(anonymousExec);
        biScan(spoon.reflect.path.CtRole.ANNOTATION, anonymousExec.getAnnotations(), other.getAnnotations());
        biScan(spoon.reflect.path.CtRole.BODY, anonymousExec.getBody(), other.getBody());
        biScan(spoon.reflect.path.CtRole.COMMENT, anonymousExec.getComments(), other.getComments());
        exit(anonymousExec);
    }

    @java.lang.Override
    public <T> void visitCtArrayRead(final spoon.reflect.code.CtArrayRead<T> arrayRead) {
        spoon.reflect.code.CtArrayRead other = ((spoon.reflect.code.CtArrayRead) (this.stack.peek()));
        enter(arrayRead);
        biScan(spoon.reflect.path.CtRole.ANNOTATION, arrayRead.getAnnotations(), other.getAnnotations());
        biScan(spoon.reflect.path.CtRole.TYPE, arrayRead.getType(), other.getType());
        biScan(spoon.reflect.path.CtRole.CAST, arrayRead.getTypeCasts(), other.getTypeCasts());
        biScan(spoon.reflect.path.CtRole.TARGET, arrayRead.getTarget(), other.getTarget());
        biScan(spoon.reflect.path.CtRole.EXPRESSION, arrayRead.getIndexExpression(), other.getIndexExpression());
        biScan(spoon.reflect.path.CtRole.COMMENT, arrayRead.getComments(), other.getComments());
        exit(arrayRead);
    }

    @java.lang.Override
    public <T> void visitCtArrayWrite(final spoon.reflect.code.CtArrayWrite<T> arrayWrite) {
        spoon.reflect.code.CtArrayWrite other = ((spoon.reflect.code.CtArrayWrite) (this.stack.peek()));
        enter(arrayWrite);
        biScan(spoon.reflect.path.CtRole.ANNOTATION, arrayWrite.getAnnotations(), other.getAnnotations());
        biScan(spoon.reflect.path.CtRole.TYPE, arrayWrite.getType(), other.getType());
        biScan(spoon.reflect.path.CtRole.CAST, arrayWrite.getTypeCasts(), other.getTypeCasts());
        biScan(spoon.reflect.path.CtRole.TARGET, arrayWrite.getTarget(), other.getTarget());
        biScan(spoon.reflect.path.CtRole.EXPRESSION, arrayWrite.getIndexExpression(), other.getIndexExpression());
        biScan(spoon.reflect.path.CtRole.COMMENT, arrayWrite.getComments(), other.getComments());
        exit(arrayWrite);
    }

    public <T> void visitCtArrayTypeReference(final spoon.reflect.reference.CtArrayTypeReference<T> reference) {
        spoon.reflect.reference.CtArrayTypeReference other = ((spoon.reflect.reference.CtArrayTypeReference) (this.stack.peek()));
        enter(reference);
        biScan(spoon.reflect.path.CtRole.PACKAGE_REF, reference.getPackage(), other.getPackage());
        biScan(spoon.reflect.path.CtRole.DECLARING_TYPE, reference.getDeclaringType(), other.getDeclaringType());
        biScan(spoon.reflect.path.CtRole.TYPE, reference.getComponentType(), other.getComponentType());
        biScan(spoon.reflect.path.CtRole.TYPE_ARGUMENT, reference.getActualTypeArguments(), other.getActualTypeArguments());
        biScan(spoon.reflect.path.CtRole.ANNOTATION, reference.getAnnotations(), other.getAnnotations());
        exit(reference);
    }

    public <T> void visitCtAssert(final spoon.reflect.code.CtAssert<T> asserted) {
        spoon.reflect.code.CtAssert other = ((spoon.reflect.code.CtAssert) (this.stack.peek()));
        enter(asserted);
        biScan(spoon.reflect.path.CtRole.ANNOTATION, asserted.getAnnotations(), other.getAnnotations());
        biScan(spoon.reflect.path.CtRole.CONDITION, asserted.getAssertExpression(), other.getAssertExpression());
        biScan(spoon.reflect.path.CtRole.EXPRESSION, asserted.getExpression(), other.getExpression());
        biScan(spoon.reflect.path.CtRole.COMMENT, asserted.getComments(), other.getComments());
        exit(asserted);
    }

    public <T, A extends T> void visitCtAssignment(final spoon.reflect.code.CtAssignment<T, A> assignement) {
        spoon.reflect.code.CtAssignment other = ((spoon.reflect.code.CtAssignment) (this.stack.peek()));
        enter(assignement);
        biScan(spoon.reflect.path.CtRole.ANNOTATION, assignement.getAnnotations(), other.getAnnotations());
        biScan(spoon.reflect.path.CtRole.TYPE, assignement.getType(), other.getType());
        biScan(spoon.reflect.path.CtRole.CAST, assignement.getTypeCasts(), other.getTypeCasts());
        biScan(spoon.reflect.path.CtRole.ASSIGNED, assignement.getAssigned(), other.getAssigned());
        biScan(spoon.reflect.path.CtRole.ASSIGNMENT, assignement.getAssignment(), other.getAssignment());
        biScan(spoon.reflect.path.CtRole.COMMENT, assignement.getComments(), other.getComments());
        exit(assignement);
    }

    public <T> void visitCtBinaryOperator(final spoon.reflect.code.CtBinaryOperator<T> operator) {
        spoon.reflect.code.CtBinaryOperator other = ((spoon.reflect.code.CtBinaryOperator) (this.stack.peek()));
        enter(operator);
        biScan(spoon.reflect.path.CtRole.ANNOTATION, operator.getAnnotations(), other.getAnnotations());
        biScan(spoon.reflect.path.CtRole.TYPE, operator.getType(), other.getType());
        biScan(spoon.reflect.path.CtRole.CAST, operator.getTypeCasts(), other.getTypeCasts());
        biScan(spoon.reflect.path.CtRole.LEFT_OPERAND, operator.getLeftHandOperand(), other.getLeftHandOperand());
        biScan(spoon.reflect.path.CtRole.RIGHT_OPERAND, operator.getRightHandOperand(), other.getRightHandOperand());
        biScan(spoon.reflect.path.CtRole.COMMENT, operator.getComments(), other.getComments());
        exit(operator);
    }

    public <R> void visitCtBlock(final spoon.reflect.code.CtBlock<R> block) {
        spoon.reflect.code.CtBlock other = ((spoon.reflect.code.CtBlock) (this.stack.peek()));
        enter(block);
        biScan(spoon.reflect.path.CtRole.ANNOTATION, block.getAnnotations(), other.getAnnotations());
        biScan(spoon.reflect.path.CtRole.STATEMENT, block.getStatements(), other.getStatements());
        biScan(spoon.reflect.path.CtRole.COMMENT, block.getComments(), other.getComments());
        exit(block);
    }

    public void visitCtBreak(final spoon.reflect.code.CtBreak breakStatement) {
        spoon.reflect.code.CtBreak other = ((spoon.reflect.code.CtBreak) (this.stack.peek()));
        enter(breakStatement);
        biScan(spoon.reflect.path.CtRole.ANNOTATION, breakStatement.getAnnotations(), other.getAnnotations());
        biScan(spoon.reflect.path.CtRole.COMMENT, breakStatement.getComments(), other.getComments());
        exit(breakStatement);
    }

    public <S> void visitCtCase(final spoon.reflect.code.CtCase<S> caseStatement) {
        spoon.reflect.code.CtCase other = ((spoon.reflect.code.CtCase) (this.stack.peek()));
        enter(caseStatement);
        biScan(spoon.reflect.path.CtRole.ANNOTATION, caseStatement.getAnnotations(), other.getAnnotations());
        biScan(spoon.reflect.path.CtRole.EXPRESSION, caseStatement.getCaseExpression(), other.getCaseExpression());
        biScan(spoon.reflect.path.CtRole.STATEMENT, caseStatement.getStatements(), other.getStatements());
        biScan(spoon.reflect.path.CtRole.COMMENT, caseStatement.getComments(), other.getComments());
        exit(caseStatement);
    }

    public void visitCtCatch(final spoon.reflect.code.CtCatch catchBlock) {
        spoon.reflect.code.CtCatch other = ((spoon.reflect.code.CtCatch) (this.stack.peek()));
        enter(catchBlock);
        biScan(spoon.reflect.path.CtRole.ANNOTATION, catchBlock.getAnnotations(), other.getAnnotations());
        biScan(spoon.reflect.path.CtRole.PARAMETER, catchBlock.getParameter(), other.getParameter());
        biScan(spoon.reflect.path.CtRole.BODY, catchBlock.getBody(), other.getBody());
        biScan(spoon.reflect.path.CtRole.COMMENT, catchBlock.getComments(), other.getComments());
        exit(catchBlock);
    }

    public <T> void visitCtClass(final spoon.reflect.declaration.CtClass<T> ctClass) {
        spoon.reflect.declaration.CtClass other = ((spoon.reflect.declaration.CtClass) (this.stack.peek()));
        enter(ctClass);
        biScan(spoon.reflect.path.CtRole.ANNOTATION, ctClass.getAnnotations(), other.getAnnotations());
        biScan(spoon.reflect.path.CtRole.SUPER_TYPE, ctClass.getSuperclass(), other.getSuperclass());
        biScan(spoon.reflect.path.CtRole.INTERFACE, ctClass.getSuperInterfaces(), other.getSuperInterfaces());
        biScan(spoon.reflect.path.CtRole.TYPE_PARAMETER, ctClass.getFormalCtTypeParameters(), other.getFormalCtTypeParameters());
        biScan(spoon.reflect.path.CtRole.TYPE_MEMBER, ctClass.getTypeMembers(), other.getTypeMembers());
        biScan(spoon.reflect.path.CtRole.COMMENT, ctClass.getComments(), other.getComments());
        exit(ctClass);
    }

    @java.lang.Override
    public void visitCtTypeParameter(spoon.reflect.declaration.CtTypeParameter typeParameter) {
        spoon.reflect.declaration.CtTypeParameter other = ((spoon.reflect.declaration.CtTypeParameter) (this.stack.peek()));
        enter(typeParameter);
        biScan(spoon.reflect.path.CtRole.ANNOTATION, typeParameter.getAnnotations(), other.getAnnotations());
        biScan(spoon.reflect.path.CtRole.SUPER_TYPE, typeParameter.getSuperclass(), other.getSuperclass());
        biScan(spoon.reflect.path.CtRole.COMMENT, typeParameter.getComments(), other.getComments());
        exit(typeParameter);
    }

    public <T> void visitCtConditional(final spoon.reflect.code.CtConditional<T> conditional) {
        spoon.reflect.code.CtConditional other = ((spoon.reflect.code.CtConditional) (this.stack.peek()));
        enter(conditional);
        biScan(spoon.reflect.path.CtRole.TYPE, conditional.getType(), other.getType());
        biScan(spoon.reflect.path.CtRole.ANNOTATION, conditional.getAnnotations(), other.getAnnotations());
        biScan(spoon.reflect.path.CtRole.CONDITION, conditional.getCondition(), other.getCondition());
        biScan(spoon.reflect.path.CtRole.THEN, conditional.getThenExpression(), other.getThenExpression());
        biScan(spoon.reflect.path.CtRole.ELSE, conditional.getElseExpression(), other.getElseExpression());
        biScan(spoon.reflect.path.CtRole.COMMENT, conditional.getComments(), other.getComments());
        biScan(spoon.reflect.path.CtRole.CAST, conditional.getTypeCasts(), other.getTypeCasts());
        exit(conditional);
    }

    public <T> void visitCtConstructor(final spoon.reflect.declaration.CtConstructor<T> c) {
        spoon.reflect.declaration.CtConstructor other = ((spoon.reflect.declaration.CtConstructor) (this.stack.peek()));
        enter(c);
        biScan(spoon.reflect.path.CtRole.ANNOTATION, c.getAnnotations(), other.getAnnotations());
        biScan(spoon.reflect.path.CtRole.PARAMETER, c.getParameters(), other.getParameters());
        biScan(spoon.reflect.path.CtRole.THROWN, c.getThrownTypes(), other.getThrownTypes());
        biScan(spoon.reflect.path.CtRole.TYPE_PARAMETER, c.getFormalCtTypeParameters(), other.getFormalCtTypeParameters());
        biScan(spoon.reflect.path.CtRole.BODY, c.getBody(), other.getBody());
        biScan(spoon.reflect.path.CtRole.COMMENT, c.getComments(), other.getComments());
        exit(c);
    }

    public void visitCtContinue(final spoon.reflect.code.CtContinue continueStatement) {
        spoon.reflect.code.CtContinue other = ((spoon.reflect.code.CtContinue) (this.stack.peek()));
        enter(continueStatement);
        biScan(spoon.reflect.path.CtRole.ANNOTATION, continueStatement.getAnnotations(), other.getAnnotations());
        biScan(spoon.reflect.path.CtRole.COMMENT, continueStatement.getComments(), other.getComments());
        exit(continueStatement);
    }

    public void visitCtDo(final spoon.reflect.code.CtDo doLoop) {
        spoon.reflect.code.CtDo other = ((spoon.reflect.code.CtDo) (this.stack.peek()));
        enter(doLoop);
        biScan(spoon.reflect.path.CtRole.ANNOTATION, doLoop.getAnnotations(), other.getAnnotations());
        biScan(spoon.reflect.path.CtRole.EXPRESSION, doLoop.getLoopingExpression(), other.getLoopingExpression());
        biScan(spoon.reflect.path.CtRole.BODY, doLoop.getBody(), other.getBody());
        biScan(spoon.reflect.path.CtRole.COMMENT, doLoop.getComments(), other.getComments());
        exit(doLoop);
    }

    public <T extends java.lang.Enum<?>> void visitCtEnum(final spoon.reflect.declaration.CtEnum<T> ctEnum) {
        spoon.reflect.declaration.CtEnum other = ((spoon.reflect.declaration.CtEnum) (this.stack.peek()));
        enter(ctEnum);
        biScan(spoon.reflect.path.CtRole.ANNOTATION, ctEnum.getAnnotations(), other.getAnnotations());
        biScan(spoon.reflect.path.CtRole.INTERFACE, ctEnum.getSuperInterfaces(), other.getSuperInterfaces());
        biScan(spoon.reflect.path.CtRole.TYPE_MEMBER, ctEnum.getTypeMembers(), other.getTypeMembers());
        biScan(spoon.reflect.path.CtRole.VALUE, ctEnum.getEnumValues(), other.getEnumValues());
        biScan(spoon.reflect.path.CtRole.COMMENT, ctEnum.getComments(), other.getComments());
        exit(ctEnum);
    }

    public <T> void visitCtExecutableReference(final spoon.reflect.reference.CtExecutableReference<T> reference) {
        spoon.reflect.reference.CtExecutableReference other = ((spoon.reflect.reference.CtExecutableReference) (this.stack.peek()));
        enter(reference);
        biScan(spoon.reflect.path.CtRole.DECLARING_TYPE, reference.getDeclaringType(), other.getDeclaringType());
        biScan(spoon.reflect.path.CtRole.TYPE, reference.getType(), other.getType());
        biScan(spoon.reflect.path.CtRole.ARGUMENT_TYPE, reference.getParameters(), other.getParameters());
        biScan(spoon.reflect.path.CtRole.TYPE_ARGUMENT, reference.getActualTypeArguments(), other.getActualTypeArguments());
        biScan(spoon.reflect.path.CtRole.ANNOTATION, reference.getAnnotations(), other.getAnnotations());
        biScan(spoon.reflect.path.CtRole.COMMENT, reference.getComments(), other.getComments());
        exit(reference);
    }

    public <T> void visitCtField(final spoon.reflect.declaration.CtField<T> f) {
        spoon.reflect.declaration.CtField other = ((spoon.reflect.declaration.CtField) (this.stack.peek()));
        enter(f);
        biScan(spoon.reflect.path.CtRole.ANNOTATION, f.getAnnotations(), other.getAnnotations());
        biScan(spoon.reflect.path.CtRole.TYPE, f.getType(), other.getType());
        biScan(spoon.reflect.path.CtRole.DEFAULT_EXPRESSION, f.getDefaultExpression(), other.getDefaultExpression());
        biScan(spoon.reflect.path.CtRole.COMMENT, f.getComments(), other.getComments());
        exit(f);
    }

    @java.lang.Override
    public <T> void visitCtEnumValue(final spoon.reflect.declaration.CtEnumValue<T> enumValue) {
        spoon.reflect.declaration.CtEnumValue other = ((spoon.reflect.declaration.CtEnumValue) (this.stack.peek()));
        enter(enumValue);
        biScan(spoon.reflect.path.CtRole.ANNOTATION, enumValue.getAnnotations(), other.getAnnotations());
        biScan(spoon.reflect.path.CtRole.TYPE, enumValue.getType(), other.getType());
        biScan(spoon.reflect.path.CtRole.DEFAULT_EXPRESSION, enumValue.getDefaultExpression(), other.getDefaultExpression());
        biScan(spoon.reflect.path.CtRole.COMMENT, enumValue.getComments(), other.getComments());
        exit(enumValue);
    }

    @java.lang.Override
    public <T> void visitCtThisAccess(final spoon.reflect.code.CtThisAccess<T> thisAccess) {
        spoon.reflect.code.CtThisAccess other = ((spoon.reflect.code.CtThisAccess) (this.stack.peek()));
        enter(thisAccess);
        biScan(spoon.reflect.path.CtRole.COMMENT, thisAccess.getComments(), other.getComments());
        biScan(spoon.reflect.path.CtRole.ANNOTATION, thisAccess.getAnnotations(), other.getAnnotations());
        biScan(spoon.reflect.path.CtRole.TYPE, thisAccess.getType(), other.getType());
        biScan(spoon.reflect.path.CtRole.CAST, thisAccess.getTypeCasts(), other.getTypeCasts());
        biScan(spoon.reflect.path.CtRole.TARGET, thisAccess.getTarget(), other.getTarget());
        exit(thisAccess);
    }

    public <T> void visitCtAnnotationFieldAccess(final spoon.reflect.code.CtAnnotationFieldAccess<T> annotationFieldAccess) {
        spoon.reflect.code.CtAnnotationFieldAccess other = ((spoon.reflect.code.CtAnnotationFieldAccess) (this.stack.peek()));
        enter(annotationFieldAccess);
        biScan(spoon.reflect.path.CtRole.COMMENT, annotationFieldAccess.getComments(), other.getComments());
        biScan(spoon.reflect.path.CtRole.ANNOTATION, annotationFieldAccess.getAnnotations(), other.getAnnotations());
        biScan(spoon.reflect.path.CtRole.CAST, annotationFieldAccess.getTypeCasts(), other.getTypeCasts());
        biScan(spoon.reflect.path.CtRole.TARGET, annotationFieldAccess.getTarget(), other.getTarget());
        biScan(spoon.reflect.path.CtRole.VARIABLE, annotationFieldAccess.getVariable(), other.getVariable());
        exit(annotationFieldAccess);
    }

    public <T> void visitCtFieldReference(final spoon.reflect.reference.CtFieldReference<T> reference) {
        spoon.reflect.reference.CtFieldReference other = ((spoon.reflect.reference.CtFieldReference) (this.stack.peek()));
        enter(reference);
        biScan(spoon.reflect.path.CtRole.DECLARING_TYPE, reference.getDeclaringType(), other.getDeclaringType());
        biScan(spoon.reflect.path.CtRole.TYPE, reference.getType(), other.getType());
        biScan(spoon.reflect.path.CtRole.ANNOTATION, reference.getAnnotations(), other.getAnnotations());
        exit(reference);
    }

    public void visitCtFor(final spoon.reflect.code.CtFor forLoop) {
        spoon.reflect.code.CtFor other = ((spoon.reflect.code.CtFor) (this.stack.peek()));
        enter(forLoop);
        biScan(spoon.reflect.path.CtRole.ANNOTATION, forLoop.getAnnotations(), other.getAnnotations());
        biScan(spoon.reflect.path.CtRole.FOR_INIT, forLoop.getForInit(), other.getForInit());
        biScan(spoon.reflect.path.CtRole.EXPRESSION, forLoop.getExpression(), other.getExpression());
        biScan(spoon.reflect.path.CtRole.FOR_UPDATE, forLoop.getForUpdate(), other.getForUpdate());
        biScan(spoon.reflect.path.CtRole.BODY, forLoop.getBody(), other.getBody());
        biScan(spoon.reflect.path.CtRole.COMMENT, forLoop.getComments(), other.getComments());
        exit(forLoop);
    }

    public void visitCtForEach(final spoon.reflect.code.CtForEach foreach) {
        spoon.reflect.code.CtForEach other = ((spoon.reflect.code.CtForEach) (this.stack.peek()));
        enter(foreach);
        biScan(spoon.reflect.path.CtRole.ANNOTATION, foreach.getAnnotations(), other.getAnnotations());
        biScan(spoon.reflect.path.CtRole.FOREACH_VARIABLE, foreach.getVariable(), other.getVariable());
        biScan(spoon.reflect.path.CtRole.EXPRESSION, foreach.getExpression(), other.getExpression());
        biScan(spoon.reflect.path.CtRole.BODY, foreach.getBody(), other.getBody());
        biScan(spoon.reflect.path.CtRole.COMMENT, foreach.getComments(), other.getComments());
        exit(foreach);
    }

    public void visitCtIf(final spoon.reflect.code.CtIf ifElement) {
        spoon.reflect.code.CtIf other = ((spoon.reflect.code.CtIf) (this.stack.peek()));
        enter(ifElement);
        biScan(spoon.reflect.path.CtRole.ANNOTATION, ifElement.getAnnotations(), other.getAnnotations());
        biScan(spoon.reflect.path.CtRole.CONDITION, ifElement.getCondition(), other.getCondition());
        biScan(spoon.reflect.path.CtRole.THEN, ((spoon.reflect.code.CtStatement) (ifElement.getThenStatement())), other.getThenStatement());
        biScan(spoon.reflect.path.CtRole.ELSE, ((spoon.reflect.code.CtStatement) (ifElement.getElseStatement())), other.getElseStatement());
        biScan(spoon.reflect.path.CtRole.COMMENT, ifElement.getComments(), other.getComments());
        exit(ifElement);
    }

    public <T> void visitCtInterface(final spoon.reflect.declaration.CtInterface<T> intrface) {
        spoon.reflect.declaration.CtInterface other = ((spoon.reflect.declaration.CtInterface) (this.stack.peek()));
        enter(intrface);
        biScan(spoon.reflect.path.CtRole.ANNOTATION, intrface.getAnnotations(), other.getAnnotations());
        biScan(spoon.reflect.path.CtRole.INTERFACE, intrface.getSuperInterfaces(), other.getSuperInterfaces());
        biScan(spoon.reflect.path.CtRole.TYPE_PARAMETER, intrface.getFormalCtTypeParameters(), other.getFormalCtTypeParameters());
        biScan(spoon.reflect.path.CtRole.TYPE_MEMBER, intrface.getTypeMembers(), other.getTypeMembers());
        biScan(spoon.reflect.path.CtRole.COMMENT, intrface.getComments(), other.getComments());
        exit(intrface);
    }

    public <T> void visitCtInvocation(final spoon.reflect.code.CtInvocation<T> invocation) {
        spoon.reflect.code.CtInvocation other = ((spoon.reflect.code.CtInvocation) (this.stack.peek()));
        enter(invocation);
        biScan(spoon.reflect.path.CtRole.ANNOTATION, invocation.getAnnotations(), other.getAnnotations());
        biScan(spoon.reflect.path.CtRole.CAST, invocation.getTypeCasts(), other.getTypeCasts());
        biScan(spoon.reflect.path.CtRole.TARGET, invocation.getTarget(), other.getTarget());
        biScan(spoon.reflect.path.CtRole.EXECUTABLE_REF, invocation.getExecutable(), other.getExecutable());
        biScan(spoon.reflect.path.CtRole.ARGUMENT, invocation.getArguments(), other.getArguments());
        biScan(spoon.reflect.path.CtRole.COMMENT, invocation.getComments(), other.getComments());
        exit(invocation);
    }

    public <T> void visitCtLiteral(final spoon.reflect.code.CtLiteral<T> literal) {
        spoon.reflect.code.CtLiteral other = ((spoon.reflect.code.CtLiteral) (this.stack.peek()));
        enter(literal);
        biScan(spoon.reflect.path.CtRole.ANNOTATION, literal.getAnnotations(), other.getAnnotations());
        biScan(spoon.reflect.path.CtRole.TYPE, literal.getType(), other.getType());
        biScan(spoon.reflect.path.CtRole.CAST, literal.getTypeCasts(), other.getTypeCasts());
        biScan(spoon.reflect.path.CtRole.COMMENT, literal.getComments(), other.getComments());
        exit(literal);
    }

    public <T> void visitCtLocalVariable(final spoon.reflect.code.CtLocalVariable<T> localVariable) {
        spoon.reflect.code.CtLocalVariable other = ((spoon.reflect.code.CtLocalVariable) (this.stack.peek()));
        enter(localVariable);
        biScan(spoon.reflect.path.CtRole.ANNOTATION, localVariable.getAnnotations(), other.getAnnotations());
        biScan(spoon.reflect.path.CtRole.TYPE, localVariable.getType(), other.getType());
        biScan(spoon.reflect.path.CtRole.DEFAULT_EXPRESSION, localVariable.getDefaultExpression(), other.getDefaultExpression());
        biScan(spoon.reflect.path.CtRole.COMMENT, localVariable.getComments(), other.getComments());
        exit(localVariable);
    }

    public <T> void visitCtLocalVariableReference(final spoon.reflect.reference.CtLocalVariableReference<T> reference) {
        spoon.reflect.reference.CtLocalVariableReference other = ((spoon.reflect.reference.CtLocalVariableReference) (this.stack.peek()));
        enter(reference);
        biScan(spoon.reflect.path.CtRole.TYPE, reference.getType(), other.getType());
        biScan(spoon.reflect.path.CtRole.ANNOTATION, reference.getAnnotations(), other.getAnnotations());
        exit(reference);
    }

    public <T> void visitCtCatchVariable(final spoon.reflect.code.CtCatchVariable<T> catchVariable) {
        spoon.reflect.code.CtCatchVariable other = ((spoon.reflect.code.CtCatchVariable) (this.stack.peek()));
        enter(catchVariable);
        biScan(spoon.reflect.path.CtRole.COMMENT, catchVariable.getComments(), other.getComments());
        biScan(spoon.reflect.path.CtRole.ANNOTATION, catchVariable.getAnnotations(), other.getAnnotations());
        biScan(spoon.reflect.path.CtRole.MULTI_TYPE, catchVariable.getMultiTypes(), other.getMultiTypes());
        exit(catchVariable);
    }

    public <T> void visitCtCatchVariableReference(final spoon.reflect.reference.CtCatchVariableReference<T> reference) {
        spoon.reflect.reference.CtCatchVariableReference other = ((spoon.reflect.reference.CtCatchVariableReference) (this.stack.peek()));
        enter(reference);
        biScan(spoon.reflect.path.CtRole.TYPE, reference.getType(), other.getType());
        biScan(spoon.reflect.path.CtRole.ANNOTATION, reference.getAnnotations(), other.getAnnotations());
        exit(reference);
    }

    public <T> void visitCtMethod(final spoon.reflect.declaration.CtMethod<T> m) {
        spoon.reflect.declaration.CtMethod other = ((spoon.reflect.declaration.CtMethod) (this.stack.peek()));
        enter(m);
        biScan(spoon.reflect.path.CtRole.ANNOTATION, m.getAnnotations(), other.getAnnotations());
        biScan(spoon.reflect.path.CtRole.TYPE_PARAMETER, m.getFormalCtTypeParameters(), other.getFormalCtTypeParameters());
        biScan(spoon.reflect.path.CtRole.TYPE, m.getType(), other.getType());
        biScan(spoon.reflect.path.CtRole.PARAMETER, m.getParameters(), other.getParameters());
        biScan(spoon.reflect.path.CtRole.THROWN, m.getThrownTypes(), other.getThrownTypes());
        biScan(spoon.reflect.path.CtRole.BODY, m.getBody(), other.getBody());
        biScan(spoon.reflect.path.CtRole.COMMENT, m.getComments(), other.getComments());
        exit(m);
    }

    @java.lang.Override
    public <T> void visitCtAnnotationMethod(spoon.reflect.declaration.CtAnnotationMethod<T> annotationMethod) {
        spoon.reflect.declaration.CtAnnotationMethod other = ((spoon.reflect.declaration.CtAnnotationMethod) (this.stack.peek()));
        enter(annotationMethod);
        biScan(spoon.reflect.path.CtRole.ANNOTATION, annotationMethod.getAnnotations(), other.getAnnotations());
        biScan(spoon.reflect.path.CtRole.TYPE, annotationMethod.getType(), other.getType());
        biScan(spoon.reflect.path.CtRole.DEFAULT_EXPRESSION, annotationMethod.getDefaultExpression(), other.getDefaultExpression());
        biScan(spoon.reflect.path.CtRole.COMMENT, annotationMethod.getComments(), other.getComments());
        exit(annotationMethod);
    }

    public <T> void visitCtNewArray(final spoon.reflect.code.CtNewArray<T> newArray) {
        spoon.reflect.code.CtNewArray other = ((spoon.reflect.code.CtNewArray) (this.stack.peek()));
        enter(newArray);
        biScan(spoon.reflect.path.CtRole.ANNOTATION, newArray.getAnnotations(), other.getAnnotations());
        biScan(spoon.reflect.path.CtRole.TYPE, newArray.getType(), other.getType());
        biScan(spoon.reflect.path.CtRole.CAST, newArray.getTypeCasts(), other.getTypeCasts());
        biScan(spoon.reflect.path.CtRole.EXPRESSION, newArray.getElements(), other.getElements());
        biScan(spoon.reflect.path.CtRole.DIMENSION, newArray.getDimensionExpressions(), other.getDimensionExpressions());
        biScan(spoon.reflect.path.CtRole.COMMENT, newArray.getComments(), other.getComments());
        exit(newArray);
    }

    @java.lang.Override
    public <T> void visitCtConstructorCall(final spoon.reflect.code.CtConstructorCall<T> ctConstructorCall) {
        spoon.reflect.code.CtConstructorCall other = ((spoon.reflect.code.CtConstructorCall) (this.stack.peek()));
        enter(ctConstructorCall);
        biScan(spoon.reflect.path.CtRole.ANNOTATION, ctConstructorCall.getAnnotations(), other.getAnnotations());
        biScan(spoon.reflect.path.CtRole.CAST, ctConstructorCall.getTypeCasts(), other.getTypeCasts());
        biScan(spoon.reflect.path.CtRole.EXECUTABLE_REF, ctConstructorCall.getExecutable(), other.getExecutable());
        biScan(spoon.reflect.path.CtRole.TARGET, ctConstructorCall.getTarget(), other.getTarget());
        biScan(spoon.reflect.path.CtRole.ARGUMENT, ctConstructorCall.getArguments(), other.getArguments());
        biScan(spoon.reflect.path.CtRole.COMMENT, ctConstructorCall.getComments(), other.getComments());
        exit(ctConstructorCall);
    }

    public <T> void visitCtNewClass(final spoon.reflect.code.CtNewClass<T> newClass) {
        spoon.reflect.code.CtNewClass other = ((spoon.reflect.code.CtNewClass) (this.stack.peek()));
        enter(newClass);
        biScan(spoon.reflect.path.CtRole.ANNOTATION, newClass.getAnnotations(), other.getAnnotations());
        biScan(spoon.reflect.path.CtRole.CAST, newClass.getTypeCasts(), other.getTypeCasts());
        biScan(spoon.reflect.path.CtRole.EXECUTABLE_REF, newClass.getExecutable(), other.getExecutable());
        biScan(spoon.reflect.path.CtRole.TARGET, newClass.getTarget(), other.getTarget());
        biScan(spoon.reflect.path.CtRole.ARGUMENT, newClass.getArguments(), other.getArguments());
        biScan(spoon.reflect.path.CtRole.NESTED_TYPE, newClass.getAnonymousClass(), other.getAnonymousClass());
        biScan(spoon.reflect.path.CtRole.COMMENT, newClass.getComments(), other.getComments());
        exit(newClass);
    }

    @java.lang.Override
    public <T> void visitCtLambda(final spoon.reflect.code.CtLambda<T> lambda) {
        spoon.reflect.code.CtLambda other = ((spoon.reflect.code.CtLambda) (this.stack.peek()));
        enter(lambda);
        biScan(spoon.reflect.path.CtRole.ANNOTATION, lambda.getAnnotations(), other.getAnnotations());
        biScan(spoon.reflect.path.CtRole.TYPE, lambda.getType(), other.getType());
        biScan(spoon.reflect.path.CtRole.CAST, lambda.getTypeCasts(), other.getTypeCasts());
        biScan(spoon.reflect.path.CtRole.PARAMETER, lambda.getParameters(), other.getParameters());
        biScan(spoon.reflect.path.CtRole.BODY, lambda.getBody(), other.getBody());
        biScan(spoon.reflect.path.CtRole.EXPRESSION, lambda.getExpression(), other.getExpression());
        biScan(spoon.reflect.path.CtRole.COMMENT, lambda.getComments(), other.getComments());
        exit(lambda);
    }

    @java.lang.Override
    public <T, E extends spoon.reflect.code.CtExpression<?>> void visitCtExecutableReferenceExpression(final spoon.reflect.code.CtExecutableReferenceExpression<T, E> expression) {
        spoon.reflect.code.CtExecutableReferenceExpression other = ((spoon.reflect.code.CtExecutableReferenceExpression) (this.stack.peek()));
        enter(expression);
        biScan(spoon.reflect.path.CtRole.COMMENT, expression.getComments(), other.getComments());
        biScan(spoon.reflect.path.CtRole.ANNOTATION, expression.getAnnotations(), other.getAnnotations());
        biScan(spoon.reflect.path.CtRole.TYPE, expression.getType(), other.getType());
        biScan(spoon.reflect.path.CtRole.CAST, expression.getTypeCasts(), other.getTypeCasts());
        biScan(spoon.reflect.path.CtRole.EXECUTABLE_REF, expression.getExecutable(), other.getExecutable());
        biScan(spoon.reflect.path.CtRole.TARGET, expression.getTarget(), other.getTarget());
        exit(expression);
    }

    public <T, A extends T> void visitCtOperatorAssignment(final spoon.reflect.code.CtOperatorAssignment<T, A> assignment) {
        spoon.reflect.code.CtOperatorAssignment other = ((spoon.reflect.code.CtOperatorAssignment) (this.stack.peek()));
        enter(assignment);
        biScan(spoon.reflect.path.CtRole.ANNOTATION, assignment.getAnnotations(), other.getAnnotations());
        biScan(spoon.reflect.path.CtRole.TYPE, assignment.getType(), other.getType());
        biScan(spoon.reflect.path.CtRole.CAST, assignment.getTypeCasts(), other.getTypeCasts());
        biScan(spoon.reflect.path.CtRole.ASSIGNED, assignment.getAssigned(), other.getAssigned());
        biScan(spoon.reflect.path.CtRole.ASSIGNMENT, assignment.getAssignment(), other.getAssignment());
        biScan(spoon.reflect.path.CtRole.COMMENT, assignment.getComments(), other.getComments());
        exit(assignment);
    }

    public void visitCtPackage(final spoon.reflect.declaration.CtPackage ctPackage) {
        spoon.reflect.declaration.CtPackage other = ((spoon.reflect.declaration.CtPackage) (this.stack.peek()));
        enter(ctPackage);
        biScan(spoon.reflect.path.CtRole.ANNOTATION, ctPackage.getAnnotations(), other.getAnnotations());
        biScan(spoon.reflect.path.CtRole.SUB_PACKAGE, ctPackage.getPackages(), other.getPackages());
        biScan(spoon.reflect.path.CtRole.CONTAINED_TYPE, ctPackage.getTypes(), other.getTypes());
        biScan(spoon.reflect.path.CtRole.COMMENT, ctPackage.getComments(), other.getComments());
        exit(ctPackage);
    }

    public void visitCtPackageReference(final spoon.reflect.reference.CtPackageReference reference) {
        spoon.reflect.reference.CtPackageReference other = ((spoon.reflect.reference.CtPackageReference) (this.stack.peek()));
        enter(reference);
        biScan(spoon.reflect.path.CtRole.ANNOTATION, reference.getAnnotations(), other.getAnnotations());
        exit(reference);
    }

    public <T> void visitCtParameter(final spoon.reflect.declaration.CtParameter<T> parameter) {
        spoon.reflect.declaration.CtParameter other = ((spoon.reflect.declaration.CtParameter) (this.stack.peek()));
        enter(parameter);
        biScan(spoon.reflect.path.CtRole.ANNOTATION, parameter.getAnnotations(), other.getAnnotations());
        biScan(spoon.reflect.path.CtRole.TYPE, parameter.getType(), other.getType());
        biScan(spoon.reflect.path.CtRole.COMMENT, parameter.getComments(), other.getComments());
        exit(parameter);
    }

    public <T> void visitCtParameterReference(final spoon.reflect.reference.CtParameterReference<T> reference) {
        spoon.reflect.reference.CtParameterReference other = ((spoon.reflect.reference.CtParameterReference) (this.stack.peek()));
        enter(reference);
        biScan(spoon.reflect.path.CtRole.TYPE, reference.getType(), other.getType());
        biScan(spoon.reflect.path.CtRole.ANNOTATION, reference.getAnnotations(), other.getAnnotations());
        exit(reference);
    }

    public <R> void visitCtReturn(final spoon.reflect.code.CtReturn<R> returnStatement) {
        spoon.reflect.code.CtReturn other = ((spoon.reflect.code.CtReturn) (this.stack.peek()));
        enter(returnStatement);
        biScan(spoon.reflect.path.CtRole.ANNOTATION, returnStatement.getAnnotations(), other.getAnnotations());
        biScan(spoon.reflect.path.CtRole.EXPRESSION, returnStatement.getReturnedExpression(), other.getReturnedExpression());
        biScan(spoon.reflect.path.CtRole.COMMENT, returnStatement.getComments(), other.getComments());
        exit(returnStatement);
    }

    public <R> void visitCtStatementList(final spoon.reflect.code.CtStatementList statements) {
        spoon.reflect.code.CtStatementList other = ((spoon.reflect.code.CtStatementList) (this.stack.peek()));
        enter(statements);
        biScan(spoon.reflect.path.CtRole.ANNOTATION, statements.getAnnotations(), other.getAnnotations());
        biScan(spoon.reflect.path.CtRole.STATEMENT, statements.getStatements(), other.getStatements());
        biScan(spoon.reflect.path.CtRole.COMMENT, statements.getComments(), other.getComments());
        exit(statements);
    }

    public <S> void visitCtSwitch(final spoon.reflect.code.CtSwitch<S> switchStatement) {
        spoon.reflect.code.CtSwitch other = ((spoon.reflect.code.CtSwitch) (this.stack.peek()));
        enter(switchStatement);
        biScan(spoon.reflect.path.CtRole.ANNOTATION, switchStatement.getAnnotations(), other.getAnnotations());
        biScan(spoon.reflect.path.CtRole.EXPRESSION, switchStatement.getSelector(), other.getSelector());
        biScan(spoon.reflect.path.CtRole.CASE, switchStatement.getCases(), other.getCases());
        biScan(spoon.reflect.path.CtRole.COMMENT, switchStatement.getComments(), other.getComments());
        exit(switchStatement);
    }

    public void visitCtSynchronized(final spoon.reflect.code.CtSynchronized synchro) {
        spoon.reflect.code.CtSynchronized other = ((spoon.reflect.code.CtSynchronized) (this.stack.peek()));
        enter(synchro);
        biScan(spoon.reflect.path.CtRole.ANNOTATION, synchro.getAnnotations(), other.getAnnotations());
        biScan(spoon.reflect.path.CtRole.EXPRESSION, synchro.getExpression(), other.getExpression());
        biScan(spoon.reflect.path.CtRole.BODY, synchro.getBlock(), other.getBlock());
        biScan(spoon.reflect.path.CtRole.COMMENT, synchro.getComments(), other.getComments());
        exit(synchro);
    }

    public void visitCtThrow(final spoon.reflect.code.CtThrow throwStatement) {
        spoon.reflect.code.CtThrow other = ((spoon.reflect.code.CtThrow) (this.stack.peek()));
        enter(throwStatement);
        biScan(spoon.reflect.path.CtRole.ANNOTATION, throwStatement.getAnnotations(), other.getAnnotations());
        biScan(spoon.reflect.path.CtRole.EXPRESSION, throwStatement.getThrownExpression(), other.getThrownExpression());
        biScan(spoon.reflect.path.CtRole.COMMENT, throwStatement.getComments(), other.getComments());
        exit(throwStatement);
    }

    public void visitCtTry(final spoon.reflect.code.CtTry tryBlock) {
        spoon.reflect.code.CtTry other = ((spoon.reflect.code.CtTry) (this.stack.peek()));
        enter(tryBlock);
        biScan(spoon.reflect.path.CtRole.ANNOTATION, tryBlock.getAnnotations(), other.getAnnotations());
        biScan(spoon.reflect.path.CtRole.BODY, tryBlock.getBody(), other.getBody());
        biScan(spoon.reflect.path.CtRole.CATCH, tryBlock.getCatchers(), other.getCatchers());
        biScan(spoon.reflect.path.CtRole.FINALIZER, tryBlock.getFinalizer(), other.getFinalizer());
        biScan(spoon.reflect.path.CtRole.COMMENT, tryBlock.getComments(), other.getComments());
        exit(tryBlock);
    }

    @java.lang.Override
    public void visitCtTryWithResource(final spoon.reflect.code.CtTryWithResource tryWithResource) {
        spoon.reflect.code.CtTryWithResource other = ((spoon.reflect.code.CtTryWithResource) (this.stack.peek()));
        enter(tryWithResource);
        biScan(spoon.reflect.path.CtRole.ANNOTATION, tryWithResource.getAnnotations(), other.getAnnotations());
        biScan(spoon.reflect.path.CtRole.TRY_RESOURCE, tryWithResource.getResources(), other.getResources());
        biScan(spoon.reflect.path.CtRole.BODY, tryWithResource.getBody(), other.getBody());
        biScan(spoon.reflect.path.CtRole.CATCH, tryWithResource.getCatchers(), other.getCatchers());
        biScan(spoon.reflect.path.CtRole.FINALIZER, tryWithResource.getFinalizer(), other.getFinalizer());
        biScan(spoon.reflect.path.CtRole.COMMENT, tryWithResource.getComments(), other.getComments());
        exit(tryWithResource);
    }

    public void visitCtTypeParameterReference(final spoon.reflect.reference.CtTypeParameterReference ref) {
        spoon.reflect.reference.CtTypeParameterReference other = ((spoon.reflect.reference.CtTypeParameterReference) (this.stack.peek()));
        enter(ref);
        biScan(spoon.reflect.path.CtRole.PACKAGE_REF, ref.getPackage(), other.getPackage());
        biScan(spoon.reflect.path.CtRole.DECLARING_TYPE, ref.getDeclaringType(), other.getDeclaringType());
        biScan(spoon.reflect.path.CtRole.ANNOTATION, ref.getAnnotations(), other.getAnnotations());
        biScan(spoon.reflect.path.CtRole.BOUNDING_TYPE, ref.getBoundingType(), other.getBoundingType());
        exit(ref);
    }

    @java.lang.Override
    public void visitCtWildcardReference(spoon.reflect.reference.CtWildcardReference wildcardReference) {
        spoon.reflect.reference.CtWildcardReference other = ((spoon.reflect.reference.CtWildcardReference) (this.stack.peek()));
        enter(wildcardReference);
        biScan(spoon.reflect.path.CtRole.PACKAGE_REF, wildcardReference.getPackage(), other.getPackage());
        biScan(spoon.reflect.path.CtRole.DECLARING_TYPE, wildcardReference.getDeclaringType(), other.getDeclaringType());
        biScan(spoon.reflect.path.CtRole.ANNOTATION, wildcardReference.getAnnotations(), other.getAnnotations());
        biScan(spoon.reflect.path.CtRole.BOUNDING_TYPE, wildcardReference.getBoundingType(), other.getBoundingType());
        exit(wildcardReference);
    }

    @java.lang.Override
    public <T> void visitCtIntersectionTypeReference(final spoon.reflect.reference.CtIntersectionTypeReference<T> reference) {
        spoon.reflect.reference.CtIntersectionTypeReference other = ((spoon.reflect.reference.CtIntersectionTypeReference) (this.stack.peek()));
        enter(reference);
        biScan(spoon.reflect.path.CtRole.PACKAGE_REF, reference.getPackage(), other.getPackage());
        biScan(spoon.reflect.path.CtRole.DECLARING_TYPE, reference.getDeclaringType(), other.getDeclaringType());
        biScan(spoon.reflect.path.CtRole.TYPE_ARGUMENT, reference.getActualTypeArguments(), other.getActualTypeArguments());
        biScan(spoon.reflect.path.CtRole.ANNOTATION, reference.getAnnotations(), other.getAnnotations());
        biScan(spoon.reflect.path.CtRole.BOUND, reference.getBounds(), other.getBounds());
        exit(reference);
    }

    public <T> void visitCtTypeReference(final spoon.reflect.reference.CtTypeReference<T> reference) {
        spoon.reflect.reference.CtTypeReference other = ((spoon.reflect.reference.CtTypeReference) (this.stack.peek()));
        enter(reference);
        biScan(spoon.reflect.path.CtRole.PACKAGE_REF, reference.getPackage(), other.getPackage());
        biScan(spoon.reflect.path.CtRole.DECLARING_TYPE, reference.getDeclaringType(), other.getDeclaringType());
        biScan(spoon.reflect.path.CtRole.TYPE_ARGUMENT, reference.getActualTypeArguments(), other.getActualTypeArguments());
        biScan(spoon.reflect.path.CtRole.ANNOTATION, reference.getAnnotations(), other.getAnnotations());
        biScan(spoon.reflect.path.CtRole.COMMENT, reference.getComments(), other.getComments());
        exit(reference);
    }

    @java.lang.Override
    public <T> void visitCtTypeAccess(final spoon.reflect.code.CtTypeAccess<T> typeAccess) {
        spoon.reflect.code.CtTypeAccess other = ((spoon.reflect.code.CtTypeAccess) (this.stack.peek()));
        enter(typeAccess);
        biScan(spoon.reflect.path.CtRole.ANNOTATION, typeAccess.getAnnotations(), other.getAnnotations());
        biScan(spoon.reflect.path.CtRole.CAST, typeAccess.getTypeCasts(), other.getTypeCasts());
        biScan(spoon.reflect.path.CtRole.ACCESSED_TYPE, typeAccess.getAccessedType(), other.getAccessedType());
        biScan(spoon.reflect.path.CtRole.COMMENT, typeAccess.getComments(), other.getComments());
        exit(typeAccess);
    }

    public <T> void visitCtUnaryOperator(final spoon.reflect.code.CtUnaryOperator<T> operator) {
        spoon.reflect.code.CtUnaryOperator other = ((spoon.reflect.code.CtUnaryOperator) (this.stack.peek()));
        enter(operator);
        biScan(spoon.reflect.path.CtRole.ANNOTATION, operator.getAnnotations(), other.getAnnotations());
        biScan(spoon.reflect.path.CtRole.TYPE, operator.getType(), other.getType());
        biScan(spoon.reflect.path.CtRole.CAST, operator.getTypeCasts(), other.getTypeCasts());
        biScan(spoon.reflect.path.CtRole.EXPRESSION, operator.getOperand(), other.getOperand());
        biScan(spoon.reflect.path.CtRole.COMMENT, operator.getComments(), other.getComments());
        exit(operator);
    }

    @java.lang.Override
    public <T> void visitCtVariableRead(final spoon.reflect.code.CtVariableRead<T> variableRead) {
        spoon.reflect.code.CtVariableRead other = ((spoon.reflect.code.CtVariableRead) (this.stack.peek()));
        enter(variableRead);
        biScan(spoon.reflect.path.CtRole.ANNOTATION, variableRead.getAnnotations(), other.getAnnotations());
        biScan(spoon.reflect.path.CtRole.CAST, variableRead.getTypeCasts(), other.getTypeCasts());
        biScan(spoon.reflect.path.CtRole.VARIABLE, variableRead.getVariable(), other.getVariable());
        biScan(spoon.reflect.path.CtRole.COMMENT, variableRead.getComments(), other.getComments());
        exit(variableRead);
    }

    @java.lang.Override
    public <T> void visitCtVariableWrite(final spoon.reflect.code.CtVariableWrite<T> variableWrite) {
        spoon.reflect.code.CtVariableWrite other = ((spoon.reflect.code.CtVariableWrite) (this.stack.peek()));
        enter(variableWrite);
        biScan(spoon.reflect.path.CtRole.ANNOTATION, variableWrite.getAnnotations(), other.getAnnotations());
        biScan(spoon.reflect.path.CtRole.CAST, variableWrite.getTypeCasts(), other.getTypeCasts());
        biScan(spoon.reflect.path.CtRole.VARIABLE, variableWrite.getVariable(), other.getVariable());
        biScan(spoon.reflect.path.CtRole.COMMENT, variableWrite.getComments(), other.getComments());
        exit(variableWrite);
    }

    public void visitCtWhile(final spoon.reflect.code.CtWhile whileLoop) {
        spoon.reflect.code.CtWhile other = ((spoon.reflect.code.CtWhile) (this.stack.peek()));
        enter(whileLoop);
        biScan(spoon.reflect.path.CtRole.ANNOTATION, whileLoop.getAnnotations(), other.getAnnotations());
        biScan(spoon.reflect.path.CtRole.EXPRESSION, whileLoop.getLoopingExpression(), other.getLoopingExpression());
        biScan(spoon.reflect.path.CtRole.BODY, whileLoop.getBody(), other.getBody());
        biScan(spoon.reflect.path.CtRole.COMMENT, whileLoop.getComments(), other.getComments());
        exit(whileLoop);
    }

    public <T> void visitCtCodeSnippetExpression(final spoon.reflect.code.CtCodeSnippetExpression<T> expression) {
        spoon.reflect.code.CtCodeSnippetExpression other = ((spoon.reflect.code.CtCodeSnippetExpression) (this.stack.peek()));
        enter(expression);
        biScan(spoon.reflect.path.CtRole.TYPE, expression.getType(), other.getType());
        biScan(spoon.reflect.path.CtRole.COMMENT, expression.getComments(), other.getComments());
        biScan(spoon.reflect.path.CtRole.ANNOTATION, expression.getAnnotations(), other.getAnnotations());
        biScan(spoon.reflect.path.CtRole.CAST, expression.getTypeCasts(), other.getTypeCasts());
        exit(expression);
    }

    public void visitCtCodeSnippetStatement(final spoon.reflect.code.CtCodeSnippetStatement statement) {
        spoon.reflect.code.CtCodeSnippetStatement other = ((spoon.reflect.code.CtCodeSnippetStatement) (this.stack.peek()));
        enter(statement);
        biScan(spoon.reflect.path.CtRole.COMMENT, statement.getComments(), other.getComments());
        biScan(spoon.reflect.path.CtRole.ANNOTATION, statement.getAnnotations(), other.getAnnotations());
        exit(statement);
    }

    public <T> void visitCtUnboundVariableReference(final spoon.reflect.reference.CtUnboundVariableReference<T> reference) {
        spoon.reflect.reference.CtUnboundVariableReference other = ((spoon.reflect.reference.CtUnboundVariableReference) (this.stack.peek()));
        enter(reference);
        biScan(spoon.reflect.path.CtRole.TYPE, reference.getType(), other.getType());
        exit(reference);
    }

    @java.lang.Override
    public <T> void visitCtFieldRead(final spoon.reflect.code.CtFieldRead<T> fieldRead) {
        spoon.reflect.code.CtFieldRead other = ((spoon.reflect.code.CtFieldRead) (this.stack.peek()));
        enter(fieldRead);
        biScan(spoon.reflect.path.CtRole.ANNOTATION, fieldRead.getAnnotations(), other.getAnnotations());
        biScan(spoon.reflect.path.CtRole.CAST, fieldRead.getTypeCasts(), other.getTypeCasts());
        biScan(spoon.reflect.path.CtRole.TARGET, fieldRead.getTarget(), other.getTarget());
        biScan(spoon.reflect.path.CtRole.VARIABLE, fieldRead.getVariable(), other.getVariable());
        biScan(spoon.reflect.path.CtRole.COMMENT, fieldRead.getComments(), other.getComments());
        exit(fieldRead);
    }

    @java.lang.Override
    public <T> void visitCtFieldWrite(final spoon.reflect.code.CtFieldWrite<T> fieldWrite) {
        spoon.reflect.code.CtFieldWrite other = ((spoon.reflect.code.CtFieldWrite) (this.stack.peek()));
        enter(fieldWrite);
        biScan(spoon.reflect.path.CtRole.ANNOTATION, fieldWrite.getAnnotations(), other.getAnnotations());
        biScan(spoon.reflect.path.CtRole.CAST, fieldWrite.getTypeCasts(), other.getTypeCasts());
        biScan(spoon.reflect.path.CtRole.TARGET, fieldWrite.getTarget(), other.getTarget());
        biScan(spoon.reflect.path.CtRole.VARIABLE, fieldWrite.getVariable(), other.getVariable());
        biScan(spoon.reflect.path.CtRole.COMMENT, fieldWrite.getComments(), other.getComments());
        exit(fieldWrite);
    }

    @java.lang.Override
    public <T> void visitCtSuperAccess(final spoon.reflect.code.CtSuperAccess<T> f) {
        spoon.reflect.code.CtSuperAccess other = ((spoon.reflect.code.CtSuperAccess) (this.stack.peek()));
        enter(f);
        biScan(spoon.reflect.path.CtRole.COMMENT, f.getComments(), other.getComments());
        biScan(spoon.reflect.path.CtRole.ANNOTATION, f.getAnnotations(), other.getAnnotations());
        biScan(spoon.reflect.path.CtRole.CAST, f.getTypeCasts(), other.getTypeCasts());
        biScan(spoon.reflect.path.CtRole.TARGET, f.getTarget(), other.getTarget());
        biScan(spoon.reflect.path.CtRole.VARIABLE, f.getVariable(), other.getVariable());
        exit(f);
    }

    @java.lang.Override
    public void visitCtComment(final spoon.reflect.code.CtComment comment) {
        spoon.reflect.code.CtComment other = ((spoon.reflect.code.CtComment) (this.stack.peek()));
        enter(comment);
        biScan(spoon.reflect.path.CtRole.COMMENT, comment.getComments(), other.getComments());
        biScan(spoon.reflect.path.CtRole.ANNOTATION, comment.getAnnotations(), other.getAnnotations());
        exit(comment);
    }

    @java.lang.Override
    public void visitCtJavaDoc(final spoon.reflect.code.CtJavaDoc javaDoc) {
        spoon.reflect.code.CtJavaDoc other = ((spoon.reflect.code.CtJavaDoc) (this.stack.peek()));
        enter(javaDoc);
        biScan(spoon.reflect.path.CtRole.COMMENT, javaDoc.getComments(), other.getComments());
        biScan(spoon.reflect.path.CtRole.ANNOTATION, javaDoc.getAnnotations(), other.getAnnotations());
        biScan(spoon.reflect.path.CtRole.COMMENT_TAG, javaDoc.getTags(), other.getTags());
        exit(javaDoc);
    }

    @java.lang.Override
    public void visitCtJavaDocTag(final spoon.reflect.code.CtJavaDocTag docTag) {
        spoon.reflect.code.CtJavaDocTag other = ((spoon.reflect.code.CtJavaDocTag) (this.stack.peek()));
        enter(docTag);
        biScan(spoon.reflect.path.CtRole.COMMENT, docTag.getComments(), other.getComments());
        biScan(spoon.reflect.path.CtRole.ANNOTATION, docTag.getAnnotations(), other.getAnnotations());
        exit(docTag);
    }

    @java.lang.Override
    public void visitCtImport(final spoon.reflect.declaration.CtImport ctImport) {
        spoon.reflect.declaration.CtImport other = ((spoon.reflect.declaration.CtImport) (this.stack.peek()));
        enter(ctImport);
        biScan(spoon.reflect.path.CtRole.IMPORT_REFERENCE, ctImport.getReference(), other.getReference());
        biScan(spoon.reflect.path.CtRole.ANNOTATION, ctImport.getAnnotations(), other.getAnnotations());
        biScan(spoon.reflect.path.CtRole.COMMENT, ctImport.getComments(), other.getComments());
        exit(ctImport);
    }

    @java.lang.Override
    public void visitCtModule(spoon.reflect.declaration.CtModule module) {
        spoon.reflect.declaration.CtModule other = ((spoon.reflect.declaration.CtModule) (this.stack.peek()));
        enter(module);
        biScan(spoon.reflect.path.CtRole.COMMENT, module.getComments(), other.getComments());
        biScan(spoon.reflect.path.CtRole.ANNOTATION, module.getAnnotations(), other.getAnnotations());
        biScan(spoon.reflect.path.CtRole.MODULE_DIRECTIVE, module.getModuleDirectives(), other.getModuleDirectives());
        biScan(spoon.reflect.path.CtRole.SUB_PACKAGE, module.getRootPackage(), other.getRootPackage());
        exit(module);
    }

    @java.lang.Override
    public void visitCtModuleReference(spoon.reflect.reference.CtModuleReference moduleReference) {
        spoon.reflect.reference.CtModuleReference other = ((spoon.reflect.reference.CtModuleReference) (this.stack.peek()));
        enter(moduleReference);
        biScan(spoon.reflect.path.CtRole.ANNOTATION, moduleReference.getAnnotations(), other.getAnnotations());
        exit(moduleReference);
    }

    @java.lang.Override
    public void visitCtPackageExport(spoon.reflect.declaration.CtPackageExport moduleExport) {
        spoon.reflect.declaration.CtPackageExport other = ((spoon.reflect.declaration.CtPackageExport) (this.stack.peek()));
        enter(moduleExport);
        biScan(spoon.reflect.path.CtRole.COMMENT, moduleExport.getComments(), other.getComments());
        biScan(spoon.reflect.path.CtRole.PACKAGE_REF, moduleExport.getPackageReference(), other.getPackageReference());
        biScan(spoon.reflect.path.CtRole.MODULE_REF, moduleExport.getTargetExport(), other.getTargetExport());
        biScan(spoon.reflect.path.CtRole.ANNOTATION, moduleExport.getAnnotations(), other.getAnnotations());
        exit(moduleExport);
    }

    @java.lang.Override
    public void visitCtModuleRequirement(spoon.reflect.declaration.CtModuleRequirement moduleRequirement) {
        spoon.reflect.declaration.CtModuleRequirement other = ((spoon.reflect.declaration.CtModuleRequirement) (this.stack.peek()));
        enter(moduleRequirement);
        biScan(spoon.reflect.path.CtRole.COMMENT, moduleRequirement.getComments(), other.getComments());
        biScan(spoon.reflect.path.CtRole.MODULE_REF, moduleRequirement.getModuleReference(), other.getModuleReference());
        biScan(spoon.reflect.path.CtRole.ANNOTATION, moduleRequirement.getAnnotations(), other.getAnnotations());
        exit(moduleRequirement);
    }

    @java.lang.Override
    public void visitCtProvidedService(spoon.reflect.declaration.CtProvidedService moduleProvidedService) {
        spoon.reflect.declaration.CtProvidedService other = ((spoon.reflect.declaration.CtProvidedService) (this.stack.peek()));
        enter(moduleProvidedService);
        biScan(spoon.reflect.path.CtRole.COMMENT, moduleProvidedService.getComments(), other.getComments());
        biScan(spoon.reflect.path.CtRole.SERVICE_TYPE, moduleProvidedService.getServiceType(), other.getServiceType());
        biScan(spoon.reflect.path.CtRole.IMPLEMENTATION_TYPE, moduleProvidedService.getImplementationTypes(), other.getImplementationTypes());
        biScan(spoon.reflect.path.CtRole.ANNOTATION, moduleProvidedService.getAnnotations(), other.getAnnotations());
        exit(moduleProvidedService);
    }

    @java.lang.Override
    public void visitCtUsedService(spoon.reflect.declaration.CtUsedService usedService) {
        spoon.reflect.declaration.CtUsedService other = ((spoon.reflect.declaration.CtUsedService) (this.stack.peek()));
        enter(usedService);
        biScan(spoon.reflect.path.CtRole.COMMENT, usedService.getComments(), other.getComments());
        biScan(spoon.reflect.path.CtRole.SERVICE_TYPE, usedService.getServiceType(), other.getServiceType());
        biScan(spoon.reflect.path.CtRole.ANNOTATION, usedService.getAnnotations(), other.getAnnotations());
        exit(usedService);
    }
}

