package spoon.support.reflect.code;


public class CtForEachImpl extends spoon.support.reflect.code.CtLoopImpl implements spoon.reflect.code.CtForEach {
    private static final long serialVersionUID = 1L;

    @spoon.reflect.annotations.MetamodelPropertyField(role = spoon.reflect.path.CtRole.EXPRESSION)
    spoon.reflect.code.CtExpression<?> expression;

    @spoon.reflect.annotations.MetamodelPropertyField(role = spoon.reflect.path.CtRole.FOREACH_VARIABLE)
    spoon.reflect.code.CtLocalVariable<?> variable;

    @java.lang.Override
    public void accept(spoon.reflect.visitor.CtVisitor visitor) {
        visitor.visitCtForEach(this);
    }

    @java.lang.Override
    public spoon.reflect.code.CtExpression<?> getExpression() {
        return expression;
    }

    @java.lang.Override
    public spoon.reflect.code.CtLocalVariable<?> getVariable() {
        return variable;
    }

    @java.lang.Override
    public <T extends spoon.reflect.code.CtForEach> T setExpression(spoon.reflect.code.CtExpression<?> expression) {
        if (expression != null) {
            expression.setParent(this);
        }
        getFactory().getEnvironment().getModelChangeListener().onObjectUpdate(this, spoon.reflect.path.CtRole.EXPRESSION, expression, this.expression);
        this.expression = expression;
        return ((T) (this));
    }

    @java.lang.Override
    public <T extends spoon.reflect.code.CtForEach> T setVariable(spoon.reflect.code.CtLocalVariable<?> variable) {
        if (variable != null) {
            variable.setParent(this);
        }
        getFactory().getEnvironment().getModelChangeListener().onObjectUpdate(this, spoon.reflect.path.CtRole.FOREACH_VARIABLE, variable, this.variable);
        this.variable = variable;
        return ((T) (this));
    }

    @java.lang.Override
    public spoon.reflect.code.CtForEach clone() {
        return ((spoon.reflect.code.CtForEach) (super.clone()));
    }
}

