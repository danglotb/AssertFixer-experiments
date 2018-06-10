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
package spoon.template;


/**
 * handles the well-formedness and helper methods of templates
 */
public abstract class AbstractTemplate<T extends spoon.reflect.declaration.CtElement> implements spoon.template.Template<T> {
    private boolean addGeneratedBy = false;

    /**
     * verifies whether there is at least one template parameter.
     */
    public boolean isWellFormed() {
        return (spoon.support.template.Parameters.getAllTemplateParameterFields(this.getClass()).size()) > 0;
    }

    /**
     * verifies whether all template parameters are filled.
     */
    public boolean isValid() {
        try {
            for (java.lang.reflect.Field f : spoon.support.template.Parameters.getAllTemplateParameterFields(this.getClass())) {
                if ((f.get(this)) == null) {
                    return false;
                }
            }
            return true;
        } catch (java.lang.Exception e) {
            throw new spoon.SpoonException(e);
        }
    }

    /**
     * returns a Spoon factory object from the first template parameter that contains one
     */
    public spoon.reflect.factory.Factory getFactory() {
        return spoon.template.Substitution.getFactory(this);
    }

    /**
     *
     *
     * @return true if the template engine ({@link SubstitutionVisitor}) adds Generated by ... comments into generated code
     */
    public boolean isAddGeneratedBy() {
        return addGeneratedBy;
    }

    /**
     *
     *
     * @param addGeneratedBy
     * 		if true the template engine ({@link SubstitutionVisitor}) will add Generated by ... comments into generated code
     */
    public spoon.template.AbstractTemplate<T> addGeneratedBy(boolean addGeneratedBy) {
        this.addGeneratedBy = addGeneratedBy;
        return this;
    }
}

