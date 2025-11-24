package commandpattern;

import commandpattern.core.AppLogic;
import commandpattern.core.Interactable;
import commandpattern.core.UserInterface;
import commandpattern.data.DataManager;
import commandpattern.interaction.MenuHandler;
import commandpattern.io.InputManager;
import commandpattern.pages.HomePage;

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