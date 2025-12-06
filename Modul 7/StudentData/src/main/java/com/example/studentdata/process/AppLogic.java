package com.example.studentdata.process;

import javafx.application.Platform;

public class AppLogic implements IAppLogic {
    @Override
    public void close() {
        Platform.exit();
    }
}