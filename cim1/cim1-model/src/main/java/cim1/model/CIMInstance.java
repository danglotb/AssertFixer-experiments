/**
 * Copyright (c) 2016, All partners of the iTesla project (http://www.itesla-project.eu/consortium)
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package cim1.model;

import cim1.exc.InterpretationException;
import cim1.exc.LinkageException;
import javax.xml.stream.XMLStreamWriter;

/**
 *
 * This file has been automatically generated by CIMGateway
 *
 */

public abstract class CIMInstance {

    public abstract void readAttribute(final String className, 
            final String attributeName,
            final String value, CIMModel model)
            throws InterpretationException;

    public abstract void readResource(final String className, 
            final String resourceName,
            final String id, CIMModel model)
            throws InterpretationException, LinkageException;

    public abstract void write(XMLStreamWriter xmlsw, boolean writeID);

    public abstract void write(XMLStreamWriter xmlsw, final Subset subset,
            boolean writeID) ;

    public abstract void resolveLinks(CIMModel model, CIMModel boundaryModel) 
            throws LinkageException;

    public abstract void clearContent(final Subset subset) ;

    public abstract ConsistencyCheck modelConsistency() ;
    
    public abstract ConsistencyCheck modelConsistency(final Subset subset) ;

    public CIMInstance() {
        this.addedToUnresolved = false;
        this.fromBoundary = false;
    }

    public final String getId() {
        return this.id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public final Subset getSubset() {
        return this.subset;
    }
    
    public final boolean isAddedToUnresolved() {
        return this.addedToUnresolved;
    }
    
    public void setFromBoundary(final boolean fromBoundary) { 
 	    this.fromBoundary = fromBoundary; 
 	} 
 	
 	public boolean isFromBoundary() {
 	    return this.fromBoundary; 
	}

    protected boolean addedToUnresolved;
    
    protected boolean fromBoundary;

    protected String id;

    protected Subset subset;

    protected void addToUnresolved() {
        this.addedToUnresolved = true;
    }
    
    protected void removeFromUnresolved() {
        this.addedToUnresolved = false;
    }

    protected void copyBase(final CIMInstance otherCIMInstance) {
        this.id = otherCIMInstance.getId();
        this.subset = otherCIMInstance.getSubset();
        this.addedToUnresolved = otherCIMInstance.isAddedToUnresolved();
        this.fromBoundary = otherCIMInstance.isFromBoundary();
    }
    
    protected abstract void clearAssociations(final Subset subset);    

}

