package design_pattern;

import design_pattern.core.AppLogic;
import design_pattern.core.Interactable;
import design_pattern.core.UserInterface;
import design_pattern.data.DataManager;
import design_pattern.interaction.MenuHandler;
import design_pattern.io.InputManager;
import design_pattern.pages.HomePage;

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