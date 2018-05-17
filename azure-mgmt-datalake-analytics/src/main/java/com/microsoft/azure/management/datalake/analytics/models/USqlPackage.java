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
 * A Data Lake Analytics catalog U-SQL package item.
 */
public class USqlPackage extends CatalogItem {
    /**
     * the name of the database containing the package.
     */
    @JsonProperty(value = "databaseName")
    private String databaseName;

    /**
     * the name of the schema associated with this package and database.
     */
    @JsonProperty(value = "schemaName")
    private String schemaName;

    /**
     * the name of the package.
     */
    @JsonProperty(value = "packageName")
    private String name;

    /**
     * the definition of the package.
     */
    @JsonProperty(value = "definition")
    private String definition;

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
     * @return the USqlPackage object itself.
     */
    public USqlPackage withDatabaseName(String databaseName) {
        this.databaseName = databaseName;
        return this;
    }

    /**
     * Get the schemaName value.
     *
     * @return the schemaName value
     */
    public String schemaName() {
        return this.schemaName;
    }

    /**
     * Set the schemaName value.
     *
     * @param schemaName the schemaName value to set
     * @return the USqlPackage object itself.
     */
    public USqlPackage withSchemaName(String schemaName) {
        this.schemaName = schemaName;
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
     * @return the USqlPackage object itself.
     */
    public USqlPackage withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get the definition value.
     *
     * @return the definition value
     */
    public String definition() {
        return this.definition;
    }

    /**
     * Set the definition value.
     *
     * @param definition the definition value to set
     * @return the USqlPackage object itself.
     */
    public USqlPackage withDefinition(String definition) {
        this.definition = definition;
        return this;
    }

}
