package com.praktikum.studentdata.model;

public abstract class BaseData {
    private final String id;

    public BaseData(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public abstract String getDisplayInfo();
}
