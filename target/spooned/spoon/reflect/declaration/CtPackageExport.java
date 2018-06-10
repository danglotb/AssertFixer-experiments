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
package spoon.reflect.declaration;


/**
 * Represents an exported or opened package in a Java module
 *
 * The exports directive specifies the name of a package to be exported by the current module.
 * For code in other modules, this grants access at compile time and run time to the public and protected types in the package,
 * and the public and protected members of those types. It also grants reflective access to those types and members for code in other modules.
 *
 * The opens directive specifies the name of a package to be opened by the current module.
 * For code in other modules, this grants access at run time, but not compile time, to the public and protected types in the package,
 * and the public and protected members of those types. It also grants reflective access to all types in the package, and all their members, for code in other modules.
 *
 * It is permitted for opens to specify a package which is not declared by a compilation unit associated with the current module.
 * (If the package should happen to be declared by an observable compilation unit associated with another module, the opens directive has no effect on that other module.)
 *
 * If an exports or opens directive has a to clause, then the directive is qualified; otherwise, it is unqualified.
 * For a qualified directive, the public and protected types in the package, and their public and protected members, are accessible solely to code in the modules specified in the to clause.
 * The modules specified in the to clause are referred to as friends of the current module. For an unqualified directive, these types and their members are accessible to code in any module.
 * It is permitted for the to clause of an exports or opens directive to specify a module which is not observable (§7.7.6).
 *
 * Examples:
 * <pre>
 *     exports com.example.foo.internal to com.example.foo.probe;
 *     opens com.example.foo.quux;
 * </pre>
 */
public interface CtPackageExport extends spoon.reflect.declaration.CtModuleDirective {
    @spoon.reflect.annotations.PropertySetter(role = spoon.reflect.path.CtRole.OPENED_PACKAGE)
    <T extends spoon.reflect.declaration.CtPackageExport> T setOpenedPackage(boolean openedPackage);

    @spoon.reflect.annotations.PropertyGetter(role = spoon.reflect.path.CtRole.OPENED_PACKAGE)
    boolean isOpenedPackage();

    @spoon.reflect.annotations.PropertyGetter(role = spoon.reflect.path.CtRole.PACKAGE_REF)
    spoon.reflect.reference.CtPackageReference getPackageReference();

    @spoon.reflect.annotations.PropertySetter(role = spoon.reflect.path.CtRole.PACKAGE_REF)
    <T extends spoon.reflect.declaration.CtPackageExport> T setPackageReference(spoon.reflect.reference.CtPackageReference packageReference);

    @spoon.reflect.annotations.PropertyGetter(role = spoon.reflect.path.CtRole.MODULE_REF)
    java.util.List<spoon.reflect.reference.CtModuleReference> getTargetExport();

    @spoon.reflect.annotations.PropertySetter(role = spoon.reflect.path.CtRole.MODULE_REF)
    <T extends spoon.reflect.declaration.CtPackageExport> T setTargetExport(java.util.List<spoon.reflect.reference.CtModuleReference> targetExport);

    @spoon.reflect.annotations.PropertySetter(role = spoon.reflect.path.CtRole.MODULE_REF)
    <T extends spoon.reflect.declaration.CtPackageExport> T addTargetExport(spoon.reflect.reference.CtModuleReference targetExport);

    @java.lang.Override
    spoon.reflect.declaration.CtPackageExport clone();
}

