/**
 * Copyright (c) 2016, All partners of the iTesla project (http://www.itesla-project.eu/consortium)
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package cim1.parser;

import cim1.CIMURI;
import javax.xml.stream.XMLStreamReader;
import java.io.Reader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * This file has been automatically generated by CIMGateway
 *
 * This class is the interface between the data read in the CIM XML document and
 * the utilities to call in CIMModel and the associated instances.
 * The progressive parse is used to validate the CIM XML document by checking
 * the CIMURI.
 */

public class CIMProgressiveParser {

    /**
     * The logger of the ProgressiveParser
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(CIMProgressiveParser.class);

    /**
     * The name associated to what is parsed.
     */
    private String name;

    /**
     * Boolean attribute used to know if the checking has been done
     * If true : the checking has been done
     * If false : the checking has not been done yet
     */
    private boolean done;

    /**
     * Boolean attribute used to know if the XML Document has the expected
     * CIMURI or not
     * If true : the CIMURI is the one expected
     * If false : the CIMURI is not the one expected
     */
    private boolean hasGoodVersion;

    private boolean profileElement;

    private String profileName;


    /**
     * Constructor of the class
     *
     * @param name
     *            The name associated to the CIM XML document to validate
     *            If we parse a file, then it should be the filename
     *            Else it should be the name associated, for the loggers.
     */
    public CIMProgressiveParser(final String name) {
        this.name = name;
        this.done = false;
        this.hasGoodVersion = true;
        this.profileElement = false;
    }

    /**
     * Utility to use when we meet a startElement in the CIM XML Document.
     * Only the startElement that contains the CIMURI is used.
     *
     * @param xmlsr
     *            The XMLStreamReader used to read the CIM XML Document
     */
    public void startElement(final XMLStreamReader xmlsr) {

        // if null, the element is not interpreted

        // We search for a <cim:...> element or for the <md:Model.profile> element
        if(xmlsr.getPrefix().equals("cim")) {
            hasGoodVersion = (xmlsr.getNamespaceURI().equals(CIMURI.CIMURI));
            done = true;
        }
        else if(xmlsr.getPrefix().equals("md") && xmlsr.getName().equals("Model.profile")){
            profileElement = true;
        }
    
    }

    public void characters(final XMLStreamReader xmlsr) {
        if (profileElement) {
            String value = xmlsr.getText();

            if (value.contains("EquipmentBoundary")) {
                profileName = "EQBD";
            } else if (value.contains("TopologyBoundary")) {
                profileName = "TPBD";
            } else if (value.contains("EquipmentCore")) {
                profileName = "EQ";
            } else if (value.contains("Topology")) {
                profileName = "TP";
            } else if (value.contains("StateVariables")) {
                profileName = "SV";
            } else if (value.contains("SteadyStateHypothesis")) {
                profileName = "SSH";
            } else if (value.contains("Dynamics")) {
                profileName = "DY";
            }
            profileElement = false;
        }
        }

    /**
     * Utility only useful for the logger, to use when we meet the end of the
     * CIM XML document
     */
    public void endDocument() {
        StringBuilder infoMessage = new StringBuilder(
                "... end progressive parse \"");
        infoMessage.append(name);
        infoMessage.append("\"\n");
        LOGGER.info(infoMessage.toString());
    }

    /**
     * Utility only useful for the logger, to use when we meet the start of the
     * CIM XML document
     */
    public void startDocument() {
        StringBuilder infoMessage = new StringBuilder(
                "Starting progressive parse \"");
        infoMessage.append(name);
        infoMessage.append("\"...");
        LOGGER.info(infoMessage.toString());
    }

    /**
     * The getter for the done attribute
     *
     * @return the done attribute
     */
    public boolean getDone() {
        return done;
    }

    /**
     * The getter for the hasGoodVersion attribute
     *
     * @return the hasGoodVersion attribute
     */
    public boolean hasGoodVersion() {
        return hasGoodVersion;
    }

    /**
     * The getter for the profileName attribute
     *
     * @return the profileName attribute
     */
    public String getProfileName() {
        return profileName;
    }


}







