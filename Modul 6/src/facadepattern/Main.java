package facadepattern;

import facadepattern.core.AppLogic;
import facadepattern.core.Interactable;
import facadepattern.core.UserInterface;
import facadepattern.data.DataManager;
import facadepattern.interaction.MenuHandler;
import facadepattern.io.InputManager;
import facadepattern.pages.HomePage;
import facadepattern.service.StudentService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        InputManager input = new InputManager(scanner);
        DataManager data = new DataManager();
        StudentService service = new StudentService(data);

        UserInterface view = new HomePage();
        Interactable handler = new MenuHandler(service, input);

        AppLogic app = new AppLogic(view, handler);
        app.run();
    }
}
