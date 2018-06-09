package spoon.support.reflect.declaration;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import spoon.reflect.annotations.MetamodelPropertyField;
import spoon.reflect.declaration.CtProvidedService;
import spoon.reflect.path.CtRole;
import spoon.reflect.reference.CtTypeReference;
import spoon.reflect.visitor.CtVisitor;


public class CtProvidedServiceImpl extends CtElementImpl implements CtProvidedService {
    @MetamodelPropertyField(role = CtRole.SERVICE_TYPE)
    private CtTypeReference serviceType;

    @MetamodelPropertyField(role = CtRole.IMPLEMENTATION_TYPE)
    private List<CtTypeReference> implementationTypes = CtElementImpl.emptyList();

    public CtProvidedServiceImpl() {
        super();
    }

    @Override
    public CtTypeReference getServiceType() {
        return this.serviceType;
    }

    @Override
    public <T extends CtProvidedService> T setServiceType(CtTypeReference providingType) {
        if (providingType != null) {
            providingType.setParent(this);
        }
        getFactory().getEnvironment().getModelChangeListener().onObjectUpdate(this, CtRole.SERVICE_TYPE, providingType, this.serviceType);
        this.serviceType = providingType;
        return ((T) (this));
    }

    @Override
    public List<CtTypeReference> getImplementationTypes() {
        return Collections.unmodifiableList(this.implementationTypes);
    }

    @Override
    public <T extends CtProvidedService> T setImplementationTypes(List<CtTypeReference> usedTypes) {
        getFactory().getEnvironment().getModelChangeListener().onListDeleteAll(this, CtRole.IMPLEMENTATION_TYPE, this.implementationTypes, new ArrayList<>(this.implementationTypes));
        if ((usedTypes == null) || ((usedTypes.size()) == 0)) {
            this.implementationTypes = CtElementImpl.emptyList();
            return ((T) (this));
        }
        if ((this.implementationTypes) == (CtElementImpl.<CtTypeReference>emptyList())) {
            this.implementationTypes = new ArrayList<>();
        }
        this.implementationTypes.clear();
        for (CtTypeReference usedType : usedTypes) {
            this.addImplementationType(usedType);
        }
        return ((T) (this));
    }

    @Override
    public <T extends CtProvidedService> T addImplementationType(CtTypeReference usedType) {
        if (usedType == null) {
            return ((T) (this));
        }
        if ((this.implementationTypes) == (CtElementImpl.<CtTypeReference>emptyList())) {
            this.implementationTypes = new ArrayList<>();
        }
        getFactory().getEnvironment().getModelChangeListener().onListAdd(this, CtRole.IMPLEMENTATION_TYPE, this.implementationTypes, usedType);
        usedType.setParent(this);
        this.implementationTypes.add(usedType);
        return ((T) (this));
    }

    @Override
    public void accept(CtVisitor visitor) {
        visitor.visitCtProvidedService(this);
    }

    @Override
    public CtProvidedService clone() {
        return ((CtProvidedService) (super.clone()));
    }
}

