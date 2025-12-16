package com.praktikum.studentdata.model;

public class StudentData extends BaseData {
    private final String name;

    public StudentData(String id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getDisplayInfo() {
        return "mahasiswa " + name + " (" + getId() + ")";
    }
}