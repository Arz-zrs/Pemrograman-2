package com.example.studentdata.ui;

import com.example.studentdata.util.AlertUtils;

public class FeedbackMessage implements Feedback {

    @Override
    public void info(String msg) {
        AlertUtils.info(msg);
    }

    @Override
    public void warning(String msg) {
        AlertUtils.warning(msg);
    }

    @Override
    public void error(String msg) {
        AlertUtils.error(msg);
    }

    @Override
    public boolean isCancelled(String title, String msg) {
        return !AlertUtils.confirm(title, msg);
    }
}