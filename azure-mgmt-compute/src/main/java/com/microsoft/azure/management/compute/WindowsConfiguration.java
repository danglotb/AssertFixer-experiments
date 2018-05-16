/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.compute;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Specifies Windows operating system settings on the virtual machine.
 */
public class WindowsConfiguration {
    /**
     * Indicates whether virtual machine agent should be provisioned on the
     * virtual machine. &lt;br&gt;&lt;br&gt; When this property is not
     * specified in the request body, default behavior is to set it to true.
     * This will ensure that VM Agent is installed on the VM so that extensions
     * can be added to the VM later.
     */
    @JsonProperty(value = "provisionVMAgent")
    private Boolean provisionVMAgent;

    /**
     * Indicates whether virtual machine is enabled for automatic updates.
     */
    @JsonProperty(value = "enableAutomaticUpdates")
    private Boolean enableAutomaticUpdates;

    /**
     * Specifies the time zone of the virtual machine. e.g. "Pacific Standard
     * Time".
     */
    @JsonProperty(value = "timeZone")
    private String timeZone;

    /**
     * Specifies additional base-64 encoded XML formatted information that can
     * be included in the Unattend.xml file, which is used by Windows Setup.
     */
    @JsonProperty(value = "additionalUnattendContent")
    private List<AdditionalUnattendContent> additionalUnattendContent;

    /**
     * Specifies the Windows Remote Management listeners. This enables remote
     * Windows PowerShell.
     */
    @JsonProperty(value = "winRM")
    private WinRMConfiguration winRM;

    /**
     * Get the provisionVMAgent value.
     *
     * @return the provisionVMAgent value
     */
    public Boolean provisionVMAgent() {
        return this.provisionVMAgent;
    }

    /**
     * Set the provisionVMAgent value.
     *
     * @param provisionVMAgent the provisionVMAgent value to set
     * @return the WindowsConfiguration object itself.
     */
    public WindowsConfiguration withProvisionVMAgent(Boolean provisionVMAgent) {
        this.provisionVMAgent = provisionVMAgent;
        return this;
    }

    /**
     * Get the enableAutomaticUpdates value.
     *
     * @return the enableAutomaticUpdates value
     */
    public Boolean enableAutomaticUpdates() {
        return this.enableAutomaticUpdates;
    }

    /**
     * Set the enableAutomaticUpdates value.
     *
     * @param enableAutomaticUpdates the enableAutomaticUpdates value to set
     * @return the WindowsConfiguration object itself.
     */
    public WindowsConfiguration withEnableAutomaticUpdates(Boolean enableAutomaticUpdates) {
        this.enableAutomaticUpdates = enableAutomaticUpdates;
        return this;
    }

    /**
     * Get the timeZone value.
     *
     * @return the timeZone value
     */
    public String timeZone() {
        return this.timeZone;
    }

    /**
     * Set the timeZone value.
     *
     * @param timeZone the timeZone value to set
     * @return the WindowsConfiguration object itself.
     */
    public WindowsConfiguration withTimeZone(String timeZone) {
        this.timeZone = timeZone;
        return this;
    }

    /**
     * Get the additionalUnattendContent value.
     *
     * @return the additionalUnattendContent value
     */
    public List<AdditionalUnattendContent> additionalUnattendContent() {
        return this.additionalUnattendContent;
    }

    /**
     * Set the additionalUnattendContent value.
     *
     * @param additionalUnattendContent the additionalUnattendContent value to set
     * @return the WindowsConfiguration object itself.
     */
    public WindowsConfiguration withAdditionalUnattendContent(List<AdditionalUnattendContent> additionalUnattendContent) {
        this.additionalUnattendContent = additionalUnattendContent;
        return this;
    }

    /**
     * Get the winRM value.
     *
     * @return the winRM value
     */
    public WinRMConfiguration winRM() {
        return this.winRM;
    }

    /**
     * Set the winRM value.
     *
     * @param winRM the winRM value to set
     * @return the WindowsConfiguration object itself.
     */
    public WindowsConfiguration withWinRM(WinRMConfiguration winRM) {
        this.winRM = winRM;
        return this;
    }

}
