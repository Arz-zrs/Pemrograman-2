package com.example.studentdata.app;

import com.example.studentdata.controller.StudentController;
import com.example.studentdata.process.AppLogic;
import com.example.studentdata.process.IAppLogic;
import com.example.studentdata.repository.MemoryStudentRepository;
import com.example.studentdata.repository.StudentRepository;
import com.example.studentdata.service.IStudentService;
import com.example.studentdata.service.StudentService;
import com.example.studentdata.ui.Feedback;
import com.example.studentdata.ui.FeedbackMessage;
import com.example.studentdata.validation.StudentValidator;
import com.example.studentdata.validation.StudentValidatorLogic;
import com.example.studentdata.viewmodel.StudentViewModel;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/com/example/studentdata/view/student_view.fxml")
        );
        Scene scene = new Scene(loader.load());

        StudentController controller = loader.getController();

        StudentRepository repo = new MemoryStudentRepository();
        StudentValidator validator = new StudentValidatorLogic();
        IStudentService service = new StudentService(repo, validator);
        IAppLogic app = new AppLogic();

        StudentViewModel viewModel = new StudentViewModel(service);
        Feedback feedback = new FeedbackMessage();


        controller.setDependencies(viewModel, feedback, app);

        stage.setScene(scene);
        stage.setTitle("CRUD Data Mahasiswa");
        stage.show();
    }
}
