package io.opensaber.registry.middleware.transform.commons;

public enum ErrorCode {

    NODE_MAPPING_NOT_DEFINED("NODE_MAPPING_NOT_DEFINED", 1000),
    JSON_TO_JSONLD_TRANFORMATION_ERROR("JSON_TO_JSONLD_TRANFORMATION_ERROR", 1010),
    JSONLD_TO_JSON_TRANFORMATION_ERROR("JSONLD_TO_JSON_TRANFORMATION_ERROR", 1020),
    REGISTRY_SERVICE_UNAVAILABLE("REGISTRY_SERVICE_UNAVAILABLE", 1030);

    private String errorMessage;
    private int errorCode;

    private ErrorCode(String errorMessage, int errorCode) {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public int getErrorCode() {
        return errorCode;
    }
}
