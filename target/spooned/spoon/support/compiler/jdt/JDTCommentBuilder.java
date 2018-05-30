package spoon.support.compiler.jdt;


class JDTCommentBuilder {
    private static final org.apache.log4j.Logger LOGGER = org.apache.log4j.Logger.getLogger(spoon.support.compiler.jdt.JDTCommentBuilder.class);

    private final org.eclipse.jdt.internal.compiler.ast.CompilationUnitDeclaration declarationUnit;

    private java.lang.String filePath;

    private spoon.reflect.cu.CompilationUnit spoonUnit;

    private spoon.reflect.factory.Factory factory;

    private org.eclipse.jdt.internal.compiler.env.ICompilationUnit sourceUnit;

    private char[] contents;

    JDTCommentBuilder(org.eclipse.jdt.internal.compiler.ast.CompilationUnitDeclaration declarationUnit, spoon.reflect.factory.Factory factory) {
        this.declarationUnit = declarationUnit;
        if ((declarationUnit.comments) == null) {
            return;
        }
        this.factory = factory;
        this.sourceUnit = declarationUnit.compilationResult.compilationUnit;
        this.contents = sourceUnit.getContents();
        this.filePath = org.eclipse.jdt.core.compiler.CharOperation.charToString(sourceUnit.getFileName());
        this.spoonUnit = factory.CompilationUnit().getOrCreate(filePath);
    }

    public void build() {
        if ((declarationUnit.comments) == null) {
            return;
        }
        for (int j = 0; j < (declarationUnit.comments.length); j++) {
            int[] positions = declarationUnit.comments[j];
            buildComment(positions);
        }
    }

    private void buildComment(int[] positions) {
        int start = positions[0];
        int end = -(positions[1]);
        spoon.reflect.code.CtComment comment;
        if (end <= 0) {
            comment = factory.Core().createJavaDoc();
            end = -end;
        }else {
            comment = factory.Core().createComment();
            comment.setCommentType(spoon.reflect.code.CtComment.CommentType.BLOCK);
            if (start < 0) {
                comment.setCommentType(spoon.reflect.code.CtComment.CommentType.INLINE);
                start = -start;
            }
        }
        comment.setContent("");
        java.lang.String commentContent = getCommentContent(start, end);
        int[] lineSeparatorPositions = declarationUnit.compilationResult.lineSeparatorPositions;
        spoon.reflect.cu.SourcePosition sourcePosition = factory.Core().createSourcePosition(spoonUnit, start, (end - 1), lineSeparatorPositions);
        comment = parseTags(comment, commentContent);
        comment.setPosition(sourcePosition);
        insertCommentInAST(comment);
    }

    private spoon.reflect.code.CtComment parseTags(spoon.reflect.code.CtComment comment, java.lang.String commentContent) {
        if (!(comment instanceof spoon.reflect.code.CtJavaDoc)) {
            comment.setContent(commentContent);
            return comment;
        }
        java.lang.String currentTagContent = "";
        spoon.reflect.code.CtJavaDocTag.TagType currentTag = null;
        java.lang.String[] lines = commentContent.split("\n");
        for (int i = 0; i < (lines.length); i++) {
            java.lang.String line = lines[i].trim();
            if (line.startsWith(spoon.reflect.code.CtJavaDocTag.JAVADOC_TAG_PREFIX)) {
                int endIndex = line.indexOf(" ");
                if (endIndex == (-1)) {
                    endIndex = line.length();
                }
                defineCommentContent(comment, currentTagContent, currentTag);
                currentTag = spoon.reflect.code.CtJavaDocTag.TagType.tagFromName(line.substring(1, endIndex).toLowerCase());
                if (endIndex == (line.length())) {
                    currentTagContent = "";
                }else {
                    currentTagContent = line.substring((endIndex + 1));
                }
            }else {
                currentTagContent += "\n" + (lines[i]);
            }
        }
        defineCommentContent(comment, currentTagContent, currentTag);
        return comment;
    }

    private void defineCommentContent(spoon.reflect.code.CtComment comment, java.lang.String tagContent, spoon.reflect.code.CtJavaDocTag.TagType tagType) {
        if (tagType != null) {
            spoon.reflect.code.CtJavaDocTag docTag = comment.getFactory().Code().createJavaDocTag(tagContent, tagType);
            ((spoon.reflect.code.CtJavaDoc) (comment)).addTag(docTag);
        }else
            if (!(tagContent.isEmpty())) {
                comment.setContent(tagContent.trim());
            }

    }

    private spoon.reflect.declaration.CtElement addCommentToNear(final spoon.reflect.code.CtComment comment, final java.util.Collection<spoon.reflect.declaration.CtElement> elements) {
        spoon.reflect.declaration.CtElement best = null;
        int smallDistance = java.lang.Integer.MAX_VALUE;
        for (spoon.reflect.declaration.CtElement element : elements) {
            if ((element.getPosition().isValidPosition()) == false) {
                continue;
            }
            if (element.isImplicit()) {
                continue;
            }
            if (element instanceof spoon.reflect.code.CtComment) {
                continue;
            }
            final boolean isAfter = (element.getPosition().getSourceEnd()) < (comment.getPosition().getSourceStart());
            int distance = java.lang.Math.abs(((element.getPosition().getSourceStart()) - (comment.getPosition().getSourceEnd())));
            if (isAfter) {
                distance = java.lang.Math.abs(((element.getPosition().getSourceEnd()) - (comment.getPosition().getSourceStart())));
            }
            int elementEndLine = element.getPosition().getEndLine();
            int commentLine = comment.getPosition().getLine();
            if ((distance < smallDistance) && (((!isAfter) || (elementEndLine == commentLine)) || (element instanceof spoon.reflect.declaration.CtType))) {
                best = element;
                smallDistance = distance;
            }
        }
        if (best != null) {
            best.addComment(comment);
        }
        return best;
    }

    private void insertCommentInAST(final spoon.reflect.code.CtComment comment) {
        spoon.reflect.declaration.CtElement commentParent = findCommentParent(comment);
        if (commentParent == null) {
            java.io.File file = spoonUnit.getFile();
            if ((file != null) && (file.getName().equals(spoon.reflect.visitor.DefaultJavaPrettyPrinter.JAVA_PACKAGE_DECLARATION))) {
                spoonUnit.getDeclaredPackage().addComment(comment);
            }else
                if ((file != null) && (file.getName().equals(spoon.reflect.visitor.DefaultJavaPrettyPrinter.JAVA_MODULE_DECLARATION))) {
                    spoonUnit.getDeclaredModule().addComment(comment);
                }else {
                    comment.setCommentType(spoon.reflect.code.CtComment.CommentType.FILE);
                    addCommentToNear(comment, new java.util.ArrayList<spoon.reflect.declaration.CtElement>(spoonUnit.getDeclaredTypes()));
                }

            return;
        }
        spoon.reflect.visitor.CtInheritanceScanner insertionVisitor = new spoon.reflect.visitor.CtInheritanceScanner() {
            private boolean isScanned = false;

            @java.lang.Override
            public void scan(spoon.reflect.declaration.CtElement e) {
                if (e == null) {
                    return;
                }
                if (!(isScanned)) {
                    isScanned = true;
                    if ((e.getPosition().getSourceStart()) == (comment.getPosition().getSourceStart())) {
                        e.addComment(comment);
                        return;
                    }
                    super.scan(e);
                }
            }

            @java.lang.Override
            public void scanCtReference(spoon.reflect.reference.CtReference reference) {
                reference.addComment(comment);
                super.scanCtReference(reference);
            }

            @java.lang.Override
            public <R> void visitCtStatementList(spoon.reflect.code.CtStatementList e) {
                addCommentToNear(comment, new java.util.ArrayList<spoon.reflect.declaration.CtElement>(e.getStatements()));
                try {
                    comment.getParent();
                } catch (spoon.reflect.declaration.ParentNotInitializedException ex) {
                    e.addStatement(comment);
                }
            }

            @java.lang.Override
            public <T> void visitCtMethod(spoon.reflect.declaration.CtMethod<T> e) {
                e.addComment(comment);
            }

            @java.lang.Override
            public <T> void visitCtConstructor(spoon.reflect.declaration.CtConstructor<T> e) {
                e.addComment(comment);
            }

            @java.lang.Override
            public <T> void visitCtConditional(spoon.reflect.code.CtConditional<T> e) {
                java.util.List<spoon.reflect.declaration.CtElement> elements = new java.util.ArrayList<>();
                elements.add(e.getElseExpression());
                elements.add(e.getThenExpression());
                elements.add(e.getCondition());
                addCommentToNear(comment, elements);
            }

            @java.lang.Override
            public <T> void visitCtBinaryOperator(spoon.reflect.code.CtBinaryOperator<T> e) {
                java.util.List<spoon.reflect.declaration.CtElement> elements = new java.util.ArrayList<>();
                elements.add(e.getLeftHandOperand());
                elements.add(e.getRightHandOperand());
                addCommentToNear(comment, elements);
            }

            @java.lang.Override
            public <T> void visitCtClass(spoon.reflect.declaration.CtClass<T> e) {
                if ((comment.getPosition().getSourceEnd()) < (((spoon.reflect.cu.position.BodyHolderSourcePosition) (e.getPosition())).getBodyStart())) {
                    e.addComment(comment);
                    return;
                }
                final java.util.List<spoon.reflect.declaration.CtElement> elements = new java.util.ArrayList<>();
                for (spoon.reflect.declaration.CtTypeMember typeMember : e.getTypeMembers()) {
                    if (((typeMember instanceof spoon.reflect.declaration.CtField) || (typeMember instanceof spoon.reflect.declaration.CtMethod)) || (typeMember instanceof spoon.reflect.declaration.CtConstructor)) {
                        elements.add(typeMember);
                    }
                }
                addCommentToNear(comment, elements);
                try {
                    comment.getParent();
                } catch (spoon.reflect.declaration.ParentNotInitializedException ex) {
                    e.addComment(comment);
                }
            }

            @java.lang.Override
            public <T> void visitCtInterface(spoon.reflect.declaration.CtInterface<T> e) {
                final java.util.List<spoon.reflect.declaration.CtElement> elements = new java.util.ArrayList<>();
                for (spoon.reflect.declaration.CtTypeMember typeMember : e.getTypeMembers()) {
                    if ((typeMember instanceof spoon.reflect.declaration.CtField) || (typeMember instanceof spoon.reflect.declaration.CtMethod)) {
                        elements.add(typeMember);
                    }
                }
                addCommentToNear(comment, elements);
                try {
                    comment.getParent();
                } catch (spoon.reflect.declaration.ParentNotInitializedException ex) {
                    e.addComment(comment);
                }
            }

            @java.lang.Override
            public <T> void scanCtVariable(spoon.reflect.declaration.CtVariable<T> e) {
                e.addComment(comment);
            }

            @java.lang.Override
            public <E> void visitCtSwitch(spoon.reflect.code.CtSwitch<E> e) {
                java.util.List<spoon.reflect.code.CtCase<? super E>> cases = e.getCases();
                spoon.reflect.code.CtCase previous = null;
                for (int i = 0; i < (cases.size()); i++) {
                    spoon.reflect.code.CtCase<? super E> ctCase = cases.get(i);
                    if (previous == null) {
                        if (((comment.getPosition().getSourceStart()) < (ctCase.getPosition().getSourceStart())) && ((e.getPosition().getSourceStart()) < (comment.getPosition().getSourceStart()))) {
                            ctCase.addComment(comment);
                            return;
                        }
                    }else {
                        if (((previous.getPosition().getSourceEnd()) < (comment.getPosition().getSourceStart())) && ((ctCase.getPosition().getSourceStart()) > (comment.getPosition().getSourceStart()))) {
                            addCommentToNear(comment, new java.util.ArrayList<spoon.reflect.declaration.CtElement>(previous.getStatements()));
                            try {
                                comment.getParent();
                            } catch (spoon.reflect.declaration.ParentNotInitializedException ex) {
                                previous.addStatement(comment);
                            }
                            return;
                        }
                    }
                    previous = ctCase;
                }
                if ((previous.getPosition().getSourceEnd()) < (comment.getPosition().getSourceStart())) {
                    addCommentToNear(comment, new java.util.ArrayList<spoon.reflect.declaration.CtElement>(previous.getStatements()));
                    try {
                        comment.getParent();
                    } catch (spoon.reflect.declaration.ParentNotInitializedException ex) {
                        previous.addStatement(comment);
                    }
                    return;
                }
                try {
                    comment.getParent();
                } catch (spoon.reflect.declaration.ParentNotInitializedException ex) {
                    e.addComment(comment);
                }
            }

            @java.lang.Override
            public void visitCtIf(spoon.reflect.code.CtIf e) {
                if (!((e.getThenStatement()) instanceof spoon.reflect.code.CtBlock)) {
                    if ((comment.getPosition().getSourceEnd()) <= (e.getThenStatement().getPosition().getSourceStart())) {
                        e.getThenStatement().addComment(comment);
                        return;
                    }
                }
                if ((e.getElseStatement()) != null) {
                    spoon.reflect.cu.SourcePosition thenPosition = ((e.getThenStatement().getPosition().isValidPosition()) == false) ? ((spoon.reflect.code.CtBlock) (e.getThenStatement())).getStatement(0).getPosition() : e.getThenStatement().getPosition();
                    spoon.reflect.cu.SourcePosition elsePosition = ((e.getElseStatement().getPosition().isValidPosition()) == false) ? ((spoon.reflect.code.CtBlock) (e.getElseStatement())).getStatement(0).getPosition() : e.getElseStatement().getPosition();
                    if (((comment.getPosition().getSourceStart()) > (thenPosition.getSourceEnd())) && ((comment.getPosition().getSourceEnd()) < (elsePosition.getSourceStart()))) {
                        e.getElseStatement().addComment(comment);
                    }
                }
                try {
                    comment.getParent();
                } catch (spoon.reflect.declaration.ParentNotInitializedException ex) {
                    e.addComment(comment);
                }
            }

            @java.lang.Override
            public void scanCtStatement(spoon.reflect.code.CtStatement s) {
                if (!(((s instanceof spoon.reflect.code.CtStatementList) || (s instanceof spoon.reflect.code.CtSwitch)) || (s instanceof spoon.reflect.declaration.CtVariable))) {
                    s.addComment(comment);
                }
            }

            @java.lang.Override
            public void visitCtAnonymousExecutable(spoon.reflect.declaration.CtAnonymousExecutable e) {
                e.addComment(comment);
            }

            @java.lang.Override
            public <T> void visitCtNewArray(spoon.reflect.code.CtNewArray<T> e) {
                addCommentToNear(comment, new java.util.ArrayList<spoon.reflect.declaration.CtElement>(e.getElements()));
                try {
                    comment.getParent();
                } catch (spoon.reflect.declaration.ParentNotInitializedException ex) {
                    e.addComment(comment);
                }
            }

            @java.lang.Override
            public <T> void visitCtParameter(spoon.reflect.declaration.CtParameter<T> e) {
                e.addComment(comment);
            }

            @java.lang.Override
            public void visitCtCatch(spoon.reflect.code.CtCatch e) {
                if ((comment.getPosition().getLine()) <= (e.getPosition().getLine())) {
                    e.addComment(comment);
                }
            }

            @java.lang.Override
            public void visitCtModule(spoon.reflect.declaration.CtModule module) {
                addCommentToNear(comment, new java.util.ArrayList<>(module.getModuleDirectives()));
            }
        };
        insertionVisitor.scan(commentParent);
        try {
            comment.getParent();
        } catch (spoon.reflect.declaration.ParentNotInitializedException e) {
            spoon.support.compiler.jdt.JDTCommentBuilder.LOGGER.error((comment + " is not added into the AST"), e);
        }
    }

    private spoon.reflect.declaration.CtElement findCommentParent(spoon.reflect.code.CtComment comment) {
        class FindCommentParentScanner extends spoon.reflect.visitor.CtScanner {
            public spoon.reflect.declaration.CtElement commentParent;

            private int start;

            private int end;

            FindCommentParentScanner(int start, int end) {
                this.start = start;
                this.end = end;
            }

            private boolean isCommentBetweenElementPosition(spoon.reflect.declaration.CtElement element) {
                return ((element.getPosition().isValidPosition()) && ((element.getPosition().getSourceStart()) <= (this.start))) && ((element.getPosition().getSourceEnd()) >= (this.end));
            }

            @java.lang.Override
            public void scan(spoon.reflect.declaration.CtElement element) {
                if (element == null) {
                    return;
                }
                if (element.isImplicit()) {
                    return;
                }
                spoon.reflect.declaration.CtElement body = spoon.support.compiler.jdt.JDTCommentBuilder.getBody(element);
                if ((body != null) && ((body.getPosition().isValidPosition()) == false)) {
                    body = null;
                }
                boolean betweenElementPosition = this.isCommentBetweenElementPosition(element);
                boolean bodyBetweenElementPosition = (body != null) && (this.isCommentBetweenElementPosition(body));
                if (betweenElementPosition || bodyBetweenElementPosition) {
                    commentParent = element;
                    element.accept(this);
                }
            }
        }
        FindCommentParentScanner findCommentParentScanner = new FindCommentParentScanner(comment.getPosition().getSourceStart(), comment.getPosition().getSourceEnd());
        if (!(spoonUnit.getDeclaredTypes().isEmpty())) {
            findCommentParentScanner.scan(spoonUnit.getDeclaredTypes());
        }else
            if ((spoonUnit.getDeclaredModule()) != null) {
                findCommentParentScanner.scan(spoonUnit.getDeclaredModule());
            }

        return findCommentParentScanner.commentParent;
    }

    static spoon.reflect.declaration.CtElement getBody(spoon.reflect.declaration.CtElement e) {
        if (e instanceof spoon.reflect.code.CtBodyHolder) {
            return ((spoon.reflect.code.CtBodyHolder) (e)).getBody();
        }
        return null;
    }

    private java.lang.String getCommentContent(int start, int end) {
        return spoon.support.compiler.jdt.JDTCommentBuilder.cleanComment(new java.io.CharArrayReader(contents, start, (end - start)));
    }

    public static java.lang.String cleanComment(java.lang.String comment) {
        return spoon.support.compiler.jdt.JDTCommentBuilder.cleanComment(new java.io.StringReader(comment));
    }

    private static final java.util.regex.Pattern startCommentRE = java.util.regex.Pattern.compile("^/\\*{1,2} ?");

    private static final java.util.regex.Pattern middleCommentRE = java.util.regex.Pattern.compile("^[ \t]*\\*? ?");

    private static final java.util.regex.Pattern endCommentRE = java.util.regex.Pattern.compile("\\*/$");

    private static java.lang.String cleanComment(java.io.Reader comment) {
        java.lang.StringBuilder ret = new java.lang.StringBuilder();
        try (java.io.BufferedReader br = new java.io.BufferedReader(comment)) {
            java.lang.String line = br.readLine();
            if (((line.length()) < 2) || ((line.charAt(0)) != '/')) {
                throw new spoon.SpoonException("Unexpected beginning of comment");
            }
            boolean isLastLine = false;
            if ((line.charAt(1)) == '/') {
                isLastLine = true;
                line = line.substring(2);
            }else {
                if (line.endsWith("*/")) {
                    line = spoon.support.compiler.jdt.JDTCommentBuilder.endCommentRE.matcher(line).replaceFirst("");
                    isLastLine = true;
                }
                line = spoon.support.compiler.jdt.JDTCommentBuilder.startCommentRE.matcher(line).replaceFirst("");
            }
            ret.append(line);
            while ((line = br.readLine()) != null) {
                if (isLastLine) {
                    throw new spoon.SpoonException("Unexpected next line after last line");
                }
                if (line.endsWith("*/")) {
                    line = spoon.support.compiler.jdt.JDTCommentBuilder.endCommentRE.matcher(line).replaceFirst("");
                    isLastLine = true;
                }
                line = spoon.support.compiler.jdt.JDTCommentBuilder.middleCommentRE.matcher(line).replaceFirst("");
                ret.append(spoon.reflect.code.CtComment.LINE_SEPARATOR);
                ret.append(line);
            } 
            return ret.toString().trim();
        } catch (java.io.IOException e) {
            throw new spoon.SpoonException(e);
        }
    }
}

