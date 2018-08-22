/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.appservice;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

/**
 * MSDeploy ARM PUT core information.
 */
public class MSDeployCore {
    /**
     * Package URI.
     */
    @JsonProperty(value = "packageUri")
    private String packageUri;

    /**
     * SQL Connection String.
     */
    @JsonProperty(value = "connectionString")
    private String connectionString;

    /**
     * Database Type.
     */
    @JsonProperty(value = "dbType")
    private String dbType;

    /**
     * URI of MSDeploy Parameters file. Must not be set if SetParameters is
     * used.
     */
    @JsonProperty(value = "setParametersXmlFileUri")
    private String setParametersXmlFileUri;

    /**
     * MSDeploy Parameters. Must not be set if SetParametersXmlFileUri is used.
     */
    @JsonProperty(value = "setParameters")
    private Map<String, String> setParameters;

    /**
     * Controls whether the MSDeploy operation skips the App_Data directory.
     * If set to &lt;code&gt;true&lt;/code&gt;, the existing App_Data directory
     * on the destination
     * will not be deleted, and any App_Data directory in the source will be
     * ignored.
     * Setting is &lt;code&gt;false&lt;/code&gt; by default.
     */
    @JsonProperty(value = "skipAppData")
    private Boolean skipAppData;

    /**
     * Sets the AppOffline rule while the MSDeploy operation executes.
     * Setting is &lt;code&gt;false&lt;/code&gt; by default.
     */
    @JsonProperty(value = "appOffline")
    private Boolean appOffline;

    /**
     * Get package URI.
     *
     * @return the packageUri value
     */
    public String packageUri() {
        return this.packageUri;
    }

    /**
     * Set package URI.
     *
     * @param packageUri the packageUri value to set
     * @return the MSDeployCore object itself.
     */
    public MSDeployCore withPackageUri(String packageUri) {
        this.packageUri = packageUri;
        return this;
    }

    /**
     * Get sQL Connection String.
     *
     * @return the connectionString value
     */
    public String connectionString() {
        return this.connectionString;
    }

    /**
     * Set sQL Connection String.
     *
     * @param connectionString the connectionString value to set
     * @return the MSDeployCore object itself.
     */
    public MSDeployCore withConnectionString(String connectionString) {
        this.connectionString = connectionString;
        return this;
    }

    /**
     * Get database Type.
     *
     * @return the dbType value
     */
    public String dbType() {
        return this.dbType;
    }

    /**
     * Set database Type.
     *
     * @param dbType the dbType value to set
     * @return the MSDeployCore object itself.
     */
    public MSDeployCore withDbType(String dbType) {
        this.dbType = dbType;
        return this;
    }

    /**
     * Get uRI of MSDeploy Parameters file. Must not be set if SetParameters is used.
     *
     * @return the setParametersXmlFileUri value
     */
    public String setParametersXmlFileUri() {
        return this.setParametersXmlFileUri;
    }

    /**
     * Set uRI of MSDeploy Parameters file. Must not be set if SetParameters is used.
     *
     * @param setParametersXmlFileUri the setParametersXmlFileUri value to set
     * @return the MSDeployCore object itself.
     */
    public MSDeployCore withSetParametersXmlFileUri(String setParametersXmlFileUri) {
        this.setParametersXmlFileUri = setParametersXmlFileUri;
        return this;
    }

    /**
     * Get mSDeploy Parameters. Must not be set if SetParametersXmlFileUri is used.
     *
     * @return the setParameters value
     */
    public Map<String, String> setParameters() {
        return this.setParameters;
    }

    /**
     * Set mSDeploy Parameters. Must not be set if SetParametersXmlFileUri is used.
     *
     * @param setParameters the setParameters value to set
     * @return the MSDeployCore object itself.
     */
    public MSDeployCore withSetParameters(Map<String, String> setParameters) {
        this.setParameters = setParameters;
        return this;
    }

    /**
     * Get controls whether the MSDeploy operation skips the App_Data directory.
     If set to &lt;code&gt;true&lt;/code&gt;, the existing App_Data directory on the destination
     will not be deleted, and any App_Data directory in the source will be ignored.
     Setting is &lt;code&gt;false&lt;/code&gt; by default.
     *
     * @return the skipAppData value
     */
    public Boolean skipAppData() {
        return this.skipAppData;
    }

    /**
     * Set controls whether the MSDeploy operation skips the App_Data directory.
     If set to &lt;code&gt;true&lt;/code&gt;, the existing App_Data directory on the destination
     will not be deleted, and any App_Data directory in the source will be ignored.
     Setting is &lt;code&gt;false&lt;/code&gt; by default.
     *
     * @param skipAppData the skipAppData value to set
     * @return the MSDeployCore object itself.
     */
    public MSDeployCore withSkipAppData(Boolean skipAppData) {
        this.skipAppData = skipAppData;
        return this;
    }

    /**
     * Get sets the AppOffline rule while the MSDeploy operation executes.
     Setting is &lt;code&gt;false&lt;/code&gt; by default.
     *
     * @return the appOffline value
     */
    public Boolean appOffline() {
        return this.appOffline;
    }

    /**
     * Set sets the AppOffline rule while the MSDeploy operation executes.
     Setting is &lt;code&gt;false&lt;/code&gt; by default.
     *
     * @param appOffline the appOffline value to set
     * @return the MSDeployCore object itself.
     */
    public MSDeployCore withAppOffline(Boolean appOffline) {
        this.appOffline = appOffline;
        return this;
    }

}
