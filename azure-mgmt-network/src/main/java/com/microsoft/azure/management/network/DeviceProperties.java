/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.network;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * List of properties of the device.
 */
public class DeviceProperties {
    /**
     * Name of the device Vendor.
     */
    @JsonProperty(value = "deviceVendor")
    private String deviceVendor;

    /**
     * Model of the device.
     */
    @JsonProperty(value = "deviceModel")
    private String deviceModel;

    /**
     * Link speed.
     */
    @JsonProperty(value = "linkSpeedInMbps")
    private Integer linkSpeedInMbps;

    /**
     * Get the deviceVendor value.
     *
     * @return the deviceVendor value
     */
    public String deviceVendor() {
        return this.deviceVendor;
    }

    /**
     * Set the deviceVendor value.
     *
     * @param deviceVendor the deviceVendor value to set
     * @return the DeviceProperties object itself.
     */
    public DeviceProperties withDeviceVendor(String deviceVendor) {
        this.deviceVendor = deviceVendor;
        return this;
    }

    /**
     * Get the deviceModel value.
     *
     * @return the deviceModel value
     */
    public String deviceModel() {
        return this.deviceModel;
    }

    /**
     * Set the deviceModel value.
     *
     * @param deviceModel the deviceModel value to set
     * @return the DeviceProperties object itself.
     */
    public DeviceProperties withDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
        return this;
    }

    /**
     * Get the linkSpeedInMbps value.
     *
     * @return the linkSpeedInMbps value
     */
    public Integer linkSpeedInMbps() {
        return this.linkSpeedInMbps;
    }

    /**
     * Set the linkSpeedInMbps value.
     *
     * @param linkSpeedInMbps the linkSpeedInMbps value to set
     * @return the DeviceProperties object itself.
     */
    public DeviceProperties withLinkSpeedInMbps(Integer linkSpeedInMbps) {
        this.linkSpeedInMbps = linkSpeedInMbps;
        return this;
    }

}
