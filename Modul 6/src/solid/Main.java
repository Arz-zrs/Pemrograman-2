package solid;

import solid.core.AppLogic;
import solid.core.Interactable;
import solid.core.UserInterface;
import solid.data.DataManager;
import solid.interaction.MenuHandler;
import solid.io.InputManager;
import solid.pages.HomePage;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputManager input = new InputManager(scanner);
        DataManager data = new DataManager();
        UserInterface view = new HomePage();
        Interactable handler = new MenuHandler(data, input);
        AppLogic app = new AppLogic(view, handler);

        app.run();
    }
}