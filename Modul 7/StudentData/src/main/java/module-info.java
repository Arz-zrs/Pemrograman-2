module com.example.studentdata {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.studentdata.controller to javafx.fxml;
    exports com.example.studentdata.app;
}
