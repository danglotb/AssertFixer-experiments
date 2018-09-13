package org.fogbowcloud.ras.core.exceptions;

import org.fogbowcloud.ras.core.constants.Messages;

public class NoAvailableResourcesException extends FogbowRasException {
    private static final long serialVersionUID = 1L;

    public NoAvailableResourcesException() {
        super(Messages.Exception.RESOURCES_NOT_AVAILABLE);
    }

    public NoAvailableResourcesException(String message) {
        super(message);
    }

    public NoAvailableResourcesException(String message, Throwable cause) {
        super(message, cause);
    }
}
