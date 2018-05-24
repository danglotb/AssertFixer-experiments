/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.datalake.analytics.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A Data Lake Analytics catalog U-SQL assembly CLR item.
 */
public class USqlAssemblyClr extends CatalogItem {
    /**
     * the name of the database.
     */
    @JsonProperty(value = "databaseName")
    private String databaseName;

    /**
     * the name of the assembly.
     */
    @JsonProperty(value = "assemblyClrName")
    private String name;

    /**
     * the name of the CLR.
     */
    @JsonProperty(value = "clrName")
    private String clrName;

    /**
     * Get the databaseName value.
     *
     * @return the databaseName value
     */
    public String databaseName() {
        return this.databaseName;
    }

    /**
     * Set the databaseName value.
     *
     * @param databaseName the databaseName value to set
     * @return the USqlAssemblyClr object itself.
     */
    public USqlAssemblyClr withDatabaseName(String databaseName) {
        this.databaseName = databaseName;
        return this;
    }

    /**
     * Get the name value.
     *
     * @return the name value
     */
    public String name() {
        return this.name;
    }

    /**
     * Set the name value.
     *
     * @param name the name value to set
     * @return the USqlAssemblyClr object itself.
     */
    public USqlAssemblyClr withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get the clrName value.
     *
     * @return the clrName value
     */
    public String clrName() {
        return this.clrName;
    }

    /**
     * Set the clrName value.
     *
     * @param clrName the clrName value to set
     * @return the USqlAssemblyClr object itself.
     */
    public USqlAssemblyClr withClrName(String clrName) {
        this.clrName = clrName;
        return this;
    }

}
