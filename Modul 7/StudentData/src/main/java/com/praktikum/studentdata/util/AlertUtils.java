package com.praktikum.studentdata.util;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class AlertUtils {

    public static void info(String msg) {
        alert(Alert.AlertType.INFORMATION, "Info", msg);
    }

    public static void error(String msg) {
        alert(Alert.AlertType.ERROR, "Error", msg);
    }

    public static void warning(String msg) {
        alert(Alert.AlertType.WARNING, "Warning", msg);
    }

    public static boolean confirm(String title, String msg) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, msg, ButtonType.OK, ButtonType.CANCEL);
        alert.setTitle(title);
        alert.setHeaderText(null);
        return alert.showAndWait().orElse(ButtonType.CANCEL) == ButtonType.OK;
    }

    private static void alert(Alert.AlertType type, String title, String msg) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}
