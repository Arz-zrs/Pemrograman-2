package com.praktikum.studentdata.manager;

import javafx.application.Platform;

public class AppManager implements IAppManager {
    @Override
    public void close() {
        Platform.exit();
    }
}