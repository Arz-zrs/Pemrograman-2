package com.praktikum.studentdata.ui;

public interface Feedback {
    void info(String msg);
    void warning(String msg);
    void error(String msg);
    boolean isCancelled(String title, String msg);
}