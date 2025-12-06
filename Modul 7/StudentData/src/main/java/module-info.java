module com.example.studentdata {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.praktikum.studentdata.controller to javafx.fxml;
    exports com.praktikum.studentdata.app;
}
