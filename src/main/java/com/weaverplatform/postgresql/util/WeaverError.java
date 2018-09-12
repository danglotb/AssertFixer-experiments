package com.weaverplatform.postgresql.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;

public class WeaverError extends RuntimeException {

  public final static int
    OTHER_CAUSE                = -1,
    NODE_NOT_FOUND             = 101,
    NODE_ALREADY_EXISTS        = 161,
    DATATYPE_INVALID           = 322,
    DATATYPE_UNSUPPORTED       = 333,
    WRITE_OPERATION_NOT_EXISTS = 344,
    WRITE_OPERATION_INVALID    = 345,
    WRITE_OPERATION_FAILED     = 366,
    INCREMENT_ERROR            = 346,
    QUERY_INVALID              = 356,
    CONDITION_INVALID          = 442,
    DATABASE_NOT_PROVIDED      = 443,
    DATABASE_CONNECTION        = 876,
    RESULTSET_ERROR            = 743;

  @Expose
  private int code;

  @Expose
  private String message;

  private final static Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

  public WeaverError(int code, String message) {
    super(message);
    this.code = code;
    this.message = message;
  }

  public String toJson() {
    return gson.toJson(this);
  }
}
