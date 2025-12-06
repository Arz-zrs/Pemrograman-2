package com.praktikum.studentdata.app;

import com.praktikum.studentdata.controller.StudentController;
import com.praktikum.studentdata.manager.AppManager;
import com.praktikum.studentdata.manager.IAppManager;
import com.praktikum.studentdata.repository.MemoryStudentRepository;
import com.praktikum.studentdata.repository.StudentRepository;
import com.praktikum.studentdata.service.IStudentService;
import com.praktikum.studentdata.service.StudentService;
import com.praktikum.studentdata.ui.Feedback;
import com.praktikum.studentdata.ui.FeedbackMessage;
import com.praktikum.studentdata.validation.StudentValidator;
import com.praktikum.studentdata.validation.StudentValidatorLogic;
import com.praktikum.studentdata.viewmodel.StudentViewModel;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/com/praktikum/studentdata/view/student_view.fxml")
        );
        Scene scene = new Scene(loader.load());

        StudentController controller = loader.getController();

        StudentRepository repo = new MemoryStudentRepository();
        StudentValidator validator = new StudentValidatorLogic();
        IStudentService service = new StudentService(repo, validator);
        IAppManager app = new AppManager();

        StudentViewModel viewModel = new StudentViewModel(service);
        Feedback feedback = new FeedbackMessage();


        controller.setDependencies(viewModel, feedback, app);

        stage.setScene(scene);
        stage.setTitle("CRUD Data Mahasiswa");
        stage.show();
    }
}
