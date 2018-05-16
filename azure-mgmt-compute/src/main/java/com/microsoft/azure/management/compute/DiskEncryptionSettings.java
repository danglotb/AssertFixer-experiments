/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.compute;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Describes a Encryption Settings for a Disk.
 */
public class DiskEncryptionSettings {
    /**
     * Specifies the location of the disk encryption key, which is a Key Vault
     * Secret.
     */
    @JsonProperty(value = "diskEncryptionKey")
    private KeyVaultSecretReference diskEncryptionKey;

    /**
     * Specifies the location of the key encryption key in Key Vault.
     */
    @JsonProperty(value = "keyEncryptionKey")
    private KeyVaultKeyReference keyEncryptionKey;

    /**
     * Specifies whether disk encryption should be enabled on the virtual
     * machine.
     */
    @JsonProperty(value = "enabled")
    private Boolean enabled;

    /**
     * Get the diskEncryptionKey value.
     *
     * @return the diskEncryptionKey value
     */
    public KeyVaultSecretReference diskEncryptionKey() {
        return this.diskEncryptionKey;
    }

    /**
     * Set the diskEncryptionKey value.
     *
     * @param diskEncryptionKey the diskEncryptionKey value to set
     * @return the DiskEncryptionSettings object itself.
     */
    public DiskEncryptionSettings withDiskEncryptionKey(KeyVaultSecretReference diskEncryptionKey) {
        this.diskEncryptionKey = diskEncryptionKey;
        return this;
    }

    /**
     * Get the keyEncryptionKey value.
     *
     * @return the keyEncryptionKey value
     */
    public KeyVaultKeyReference keyEncryptionKey() {
        return this.keyEncryptionKey;
    }

    /**
     * Set the keyEncryptionKey value.
     *
     * @param keyEncryptionKey the keyEncryptionKey value to set
     * @return the DiskEncryptionSettings object itself.
     */
    public DiskEncryptionSettings withKeyEncryptionKey(KeyVaultKeyReference keyEncryptionKey) {
        this.keyEncryptionKey = keyEncryptionKey;
        return this;
    }

    /**
     * Get the enabled value.
     *
     * @return the enabled value
     */
    public Boolean enabled() {
        return this.enabled;
    }

    /**
     * Set the enabled value.
     *
     * @param enabled the enabled value to set
     * @return the DiskEncryptionSettings object itself.
     */
    public DiskEncryptionSettings withEnabled(Boolean enabled) {
        this.enabled = enabled;
        return this;
    }

}
