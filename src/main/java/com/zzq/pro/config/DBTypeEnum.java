package com.zzq.pro.config;

public enum DBTypeEnum {
    MASTER("master"), SLAVE("slave");

    private String value;

    DBTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
