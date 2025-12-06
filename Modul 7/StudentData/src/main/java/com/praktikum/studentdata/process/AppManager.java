package com.praktikum.studentdata.process;

import javafx.application.Platform;

public class AppManager implements IAppManager {
    @Override
    public void close() {
        Platform.exit();
    }
}