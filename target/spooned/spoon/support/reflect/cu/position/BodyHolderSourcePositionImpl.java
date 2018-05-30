package spoon.support.reflect.cu.position;


public class BodyHolderSourcePositionImpl extends spoon.support.reflect.cu.position.DeclarationSourcePositionImpl implements java.io.Serializable , spoon.reflect.cu.position.BodyHolderSourcePosition {
    private static final long serialVersionUID = 1L;

    private int bodyStart;

    private int bodyEnd;

    public BodyHolderSourcePositionImpl(spoon.reflect.cu.CompilationUnit compilationUnit, int sourceStart, int sourceEnd, int modifierSourceStart, int modifierSourceEnd, int declarationSourceStart, int declarationSourceEnd, int bodyStart, int bodyEnd, int[] lineSeparatorPositions) {
        super(compilationUnit, sourceStart, sourceEnd, modifierSourceStart, modifierSourceEnd, declarationSourceStart, declarationSourceEnd, lineSeparatorPositions);
        spoon.support.reflect.cu.position.SourcePositionImpl.checkArgsAreAscending(declarationSourceStart, modifierSourceStart, (modifierSourceEnd + 1), sourceStart, (sourceEnd + 1), bodyStart, (bodyEnd + 1), (declarationSourceEnd + 1));
        this.bodyStart = bodyStart;
        this.bodyEnd = bodyEnd;
    }

    @java.lang.Override
    public int getBodyStart() {
        return bodyStart;
    }

    @java.lang.Override
    public int getBodyEnd() {
        return bodyEnd;
    }

    @java.lang.Override
    public java.lang.String getSourceDetails() {
        return ((super.getSourceDetails()) + "\nbody = ") + (getFragment(getBodyStart(), getBodyEnd()));
    }
}

