package com.booking.replication.augmenter.model;

public class AugmenterModel {

    public interface Configuration {
        String UUID_FIELD_NAME = "transaction_uuid";
        String XID_FIELD_NAME = "transaction_xid";
    }

}
