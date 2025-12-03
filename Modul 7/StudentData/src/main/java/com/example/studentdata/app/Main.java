package com.example.studentdata.app;

import com.example.studentdata.controller.StudentController;
import com.example.studentdata.repository.MemoryStudentRepository;
import com.example.studentdata.repository.StudentRepository;
import com.example.studentdata.service.StudentService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/com/example/studentdata/student_view.fxml")
        );

        Scene scene = new Scene(loader.load());

        StudentController controller = loader.getController();

        StudentRepository repo = new MemoryStudentRepository();
        StudentService service = new StudentService(repo);

        controller.setService(service);

        stage.setTitle("CRUD Data Mahasiswa");
        stage.setScene(scene);
        stage.show();
    }
}