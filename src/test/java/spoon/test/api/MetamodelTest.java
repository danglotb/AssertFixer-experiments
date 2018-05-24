package spoon.test.api;

import org.junit.Assert;
import org.junit.Test;
import spoon.Launcher;
import spoon.Metamodel;
import spoon.SpoonAPI;
import spoon.reflect.annotations.MetamodelPropertyField;
import spoon.reflect.annotations.PropertyGetter;
import spoon.reflect.annotations.PropertySetter;
import spoon.reflect.code.CtExpression;
import spoon.reflect.code.CtFieldRead;
import spoon.reflect.code.CtNewArray;
import spoon.reflect.declaration.CtAnnotation;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtElement;
import spoon.reflect.declaration.CtField;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtType;
import spoon.reflect.declaration.ModifierKind;
import spoon.reflect.factory.Factory;
import spoon.reflect.path.CtRole;
import spoon.reflect.reference.CtReference;
import spoon.reflect.reference.CtTypeReference;
import spoon.reflect.visitor.chain.CtQuery;
import spoon.reflect.visitor.filter.AnnotationFilter;
import spoon.reflect.visitor.filter.SuperInheritanceHierarchyFunction;
import spoon.reflect.visitor.filter.TypeFilter;
import spoon.test.metamodel.MMTypeKind;
import spoon.test.metamodel.MetamodelConcept;
import spoon.test.metamodel.MetamodelProperty;
import spoon.test.metamodel.SpoonMetaModel;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;


public class MetamodelTest {
	@Test
	public void testGetAllMetamodelInterfacess() {
		// contract: Spoon supports runtime introspection on the metamodel
		SpoonAPI interfaces = new Launcher();
		interfaces.addInputResource("src/main/java/spoon/reflect/declaration");
		interfaces.addInputResource("src/main/java/spoon/reflect/code");
		interfaces.addInputResource("src/main/java/spoon/reflect/reference");
		interfaces.buildModel();
		assertThat(Metamodel.getAllMetamodelInterfaces().stream().map(x->x.getQualifiedName()).collect(Collectors.toSet()), equalTo(interfaces.getModel().getAllTypes().stream().map(x->x.getQualifiedName()).collect(Collectors.toSet())));
	}

	@Test
	public void testRuntimeMetamodel() {
		// contract: Spoon supports runtime introspection on the metamodel - all (non abstract) Spoon classes and their fields are accessible by Metamodel
		SpoonMetaModel testMetaModel = new SpoonMetaModel(new File("src/main/java"));
		Map<String, MetamodelConcept> expectedTypesByName = new HashMap<>();
		testMetaModel.getConcepts().forEach(t -> {
			if (t.getKind() == MMTypeKind.LEAF) {
				expectedTypesByName.put(t.getName(), t);	
			}
		});
		for (Metamodel.Type type : Metamodel.getAllMetamodelTypes()) {
			MetamodelConcept expectedType = expectedTypesByName.remove(type.getName());
			assertSame(expectedType.getModelClass().getActualClass(), type.getModelClass());
			assertSame(expectedType.getModelInterface().getActualClass(), type.getModelInterface());
			Map<CtRole, MetamodelProperty> expectedRoleToField = new HashMap<>(expectedType.getRoleToProperty());
			for (Metamodel.Field field : type.getFields()) {
				MetamodelProperty expectedField = expectedRoleToField.remove(field.getRole());
				assertSame("Field " + expectedField + ".derived", expectedField.isDerived(), field.isDerived());
				assertSame("Field " + expectedField + ".unsettable", expectedField.isUnsettable(), field.isUnsettable());
			}
			assertTrue("These Metamodel.Field instances are missing on Type " + type.getName() +": " + expectedRoleToField.keySet(), expectedRoleToField.isEmpty());
		}
		assertTrue("These Metamodel.Type instances are missing: " + expectedTypesByName.keySet(), expectedTypesByName.isEmpty());
	}


	@Test
	public void testGetterSetterFroRole() {
		// contract: all roles in spoon metamodel must at least have a setter and a getter
		SpoonAPI interfaces = new Launcher();
		interfaces.addInputResource("src/main/java/spoon/reflect/declaration");
		interfaces.addInputResource("src/main/java/spoon/reflect/code");
		interfaces.addInputResource("src/main/java/spoon/reflect/reference");
		interfaces.buildModel();
		Factory factory = interfaces.getFactory();
		CtTypeReference propertyGetter = factory.Type().get(PropertyGetter.class).getReference();
		CtTypeReference propertySetter = factory.Type().get(PropertySetter.class).getReference();

		Set<String> expectedRoles = Arrays.stream(CtRole.values()).map(r -> r.name()).collect(Collectors.toSet());

		List<CtMethod<?>> getters = interfaces.getModel().getElements(new AnnotationFilter<CtMethod<?>>(PropertyGetter.class));
		Set<String> getterRoles = getters.stream().map(g -> ((CtFieldRead)g.getAnnotation(propertyGetter).getValue("role")).getVariable().getSimpleName()).collect(Collectors.toSet());
		Set<CtMethod<?>> isNotGetter = getters.stream().filter(m -> !(m.getSimpleName().startsWith("get") || m.getSimpleName().startsWith("is"))).collect(Collectors.toSet());

		List<CtMethod<?>> setters = interfaces.getModel().getElements(new AnnotationFilter<CtMethod<?>>(PropertySetter.class));
		Set<String> setterRoles = setters.stream().map(g -> ((CtFieldRead)g.getAnnotation(propertySetter).getValue("role")).getVariable().getSimpleName()).collect(Collectors.toSet());
		Set<CtMethod<?>> isNotSetter = setters.stream().filter(m -> !(m.getSimpleName().startsWith("set") || m.getSimpleName().startsWith("add") || m.getSimpleName().startsWith("insert") || m.getSimpleName().startsWith("remove"))).collect(Collectors.toSet());

		Assert.assertEquals(expectedRoles, getterRoles);
		Assert.assertEquals(expectedRoles, setterRoles);
		Assert.assertEquals(Collections.EMPTY_SET, isNotGetter);
		Assert.assertEquals(Collections.EMPTY_SET, isNotSetter);
	}


	@Test
	public void testRoleOnField() {
		//  contract: all non-final fields must be annotated with {@link spoon.reflect.annotations.MetamodelPropertyField}
		System.setProperty("line.separator","\n");
		SpoonAPI implementations = new Launcher();
		implementations.addInputResource("src/main/java/spoon/support/reflect");
		implementations.buildModel();

		Factory factory = implementations.getFactory();

		CtTypeReference metamodelPropertyField = factory.Type().get(MetamodelPropertyField.class).getReference();

		final List<String> result = new ArrayList();
		List<CtField> fieldWithoutAnnotation = (List<CtField>) implementations.getModel().getElements(new TypeFilter<CtField>(CtField.class) {
			@Override
			public boolean matches(CtField candidate) {
				if (candidate.hasModifier(ModifierKind.FINAL) || candidate.hasModifier(ModifierKind.STATIC) || candidate.hasModifier(ModifierKind.TRANSIENT)) {
					return false;
				}
				if ( 	// not a role
						"parent".equals(candidate.getSimpleName())
						|| "metadata".equals(candidate.getSimpleName())
						|| "factory".equals(candidate.getSimpleName())
						// cache field
						|| "valueOfMethod".equals(candidate.getSimpleName())) {
					return false;
				}
				CtClass parent = candidate.getParent(CtClass.class);
				return parent != null
						// code and reference element fields must be annotated
						&&
						(parent.isSubtypeOf(candidate.getFactory().createCtTypeReference(CtReference.class))
						|| parent.isSubtypeOf(candidate.getFactory().createCtTypeReference(CtElement.class))
						);
			}
		}).stream().map(x -> {result.add(x.toString()); return x;}).filter(f -> f.getAnnotation(metamodelPropertyField) == null).collect(Collectors.toList());

		assertTrue(result.contains("@spoon.reflect.annotations.MetamodelPropertyField(role = spoon.reflect.path.CtRole.IS_SHADOW)\nboolean isShadow;"));
		assertTrue(result.contains("@spoon.reflect.annotations.MetamodelPropertyField(role = spoon.reflect.path.CtRole.TYPE)\nspoon.reflect.reference.CtTypeReference<T> type;"));
		assertTrue(result.size()>100);
		Assert.assertEquals(Collections.emptyList(), fieldWithoutAnnotation);


		final CtTypeReference propertySetter = factory.Type().get(PropertySetter.class).getReference();
		final CtTypeReference propertyGetter = factory.Type().get(PropertyGetter.class).getReference();

		List<CtField> fields = factory.getModel().getElements(new AnnotationFilter<CtField>(MetamodelPropertyField.class));
		for (CtField field : fields) {
			CtClass parent = field.getParent(CtClass.class);
			CtExpression roleExpression = field.getAnnotation(metamodelPropertyField).getValue("role");
			List<String> roles = new ArrayList<>();
			if (roleExpression instanceof CtFieldRead) {
				roles.add(((CtFieldRead) roleExpression).getVariable().getSimpleName());
			} else  if (roleExpression instanceof CtNewArray) {
				List<CtFieldRead> elements = ((CtNewArray) roleExpression).getElements();
				for (int i = 0; i < elements.size(); i++) {
					CtFieldRead ctFieldRead =  elements.get(i);
					roles.add(ctFieldRead.getVariable().getSimpleName());
				}
			}

			CtQuery superQuery = parent.map(new SuperInheritanceHierarchyFunction());

			List<CtMethod> methods = superQuery.map((CtType type) -> type.getMethodsAnnotatedWith(propertyGetter, propertySetter)).list();

			boolean setterFound = false;
			boolean getterFound = false;
			for (CtMethod method : methods) {
				CtAnnotation getterAnnotation = method.getAnnotation(propertyGetter);
				CtAnnotation setterAnnotation = method.getAnnotation(propertySetter);
				if (getterAnnotation != null) {
					getterFound |= roles.contains(((CtFieldRead) getterAnnotation.getValue("role")).getVariable().getSimpleName());
				}
				if (setterAnnotation != null) {
					setterFound |= roles.contains(((CtFieldRead) setterAnnotation.getValue("role")).getVariable().getSimpleName());
				}
			}

			assertTrue(roles + " must have a getter in " + parent.getQualifiedName(), getterFound);
			assertTrue(roles + " must have a setter in " + parent.getQualifiedName(), setterFound);
		}

	}

	@Test
	public void testMetamodelWithoutSources() {
		//contract: metamodel based on spoon sources delivers is same like metamodel based on shadow classes
		SpoonMetaModel runtimeMM = new SpoonMetaModel();
		Collection<MetamodelConcept> concepts = runtimeMM.getConcepts();
		
		SpoonMetaModel sourceBasedMM = new SpoonMetaModel(new File("src/main/java"));
		Map<String, MetamodelConcept> expectedConceptsByName = new HashMap<>();
		sourceBasedMM.getConcepts().forEach(c -> {
			expectedConceptsByName.put(c.getName(), c);
		});
		for (MetamodelConcept runtimeConcept : concepts) {
			MetamodelConcept expectedConcept = expectedConceptsByName.remove(runtimeConcept.getName());
			assertNotNull(expectedConcept);
			assertConceptsEqual(expectedConcept, runtimeConcept);
		}
		assertEquals(0, expectedConceptsByName.size());
	}

	private void assertConceptsEqual(MetamodelConcept expectedConcept, MetamodelConcept runtimeConcept) {
		assertEquals(expectedConcept.getName(), runtimeConcept.getName());
		if (expectedConcept.getModelClass() == null) {
			assertNull(runtimeConcept.getModelClass());
		} else {
			assertNotNull(runtimeConcept.getModelClass());
			assertEquals(expectedConcept.getModelClass().getActualClass(), runtimeConcept.getModelClass().getActualClass());
		}
		assertEquals(expectedConcept.getModelInterface().getActualClass(), runtimeConcept.getModelInterface().getActualClass());
		assertEquals(expectedConcept.getKind(), runtimeConcept.getKind());
		assertEquals(expectedConcept.getSuperConcepts().size(), runtimeConcept.getSuperConcepts().size());
		for (int i = 0; i < expectedConcept.getSuperConcepts().size(); i++) {
			assertConceptsEqual(expectedConcept.getSuperConcepts().get(i), runtimeConcept.getSuperConcepts().get(i));
		}
		Map<CtRole, MetamodelProperty> expectedRoleToProperty = new HashMap(expectedConcept.getRoleToProperty());
		for (Map.Entry<CtRole, MetamodelProperty> e : runtimeConcept.getRoleToProperty().entrySet()) {
			MetamodelProperty runtimeProperty = e.getValue();
			MetamodelProperty expectedProperty = expectedRoleToProperty.remove(e.getKey());
			assertPropertiesEqual(expectedProperty, runtimeProperty);
		}
		assertEquals(0, expectedRoleToProperty.size());
	}

	private void assertPropertiesEqual(MetamodelProperty expectedProperty, MetamodelProperty runtimeProperty) {
		assertSame(expectedProperty.getRole(), runtimeProperty.getRole());
		assertEquals(expectedProperty.getName(), runtimeProperty.getName());
		assertEquals(expectedProperty.getItemValueType().getActualClass(), runtimeProperty.getItemValueType().getActualClass());
		assertEquals(expectedProperty.getOwnerConcept().getName(), runtimeProperty.getOwnerConcept().getName());
		assertSame(expectedProperty.getValueContainerType(), runtimeProperty.getValueContainerType());
		assertEquals(expectedProperty.getValueType(), runtimeProperty.getValueType());
		assertEquals(expectedProperty.isDerived(), runtimeProperty.isDerived());
		assertEquals(expectedProperty.isUnsettable(), runtimeProperty.isUnsettable());
	}
}
