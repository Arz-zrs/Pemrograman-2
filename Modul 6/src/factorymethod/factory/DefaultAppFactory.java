package factorymethod.factory;

import factorymethod.data.DataManager;
import factorymethod.core.Interactable;
import factorymethod.core.UserInterface;
import factorymethod.interaction.MenuHandler;
import factorymethod.io.InputManager;
import factorymethod.pages.HomePage;

import java.util.Scanner;

public class DefaultAppFactory implements AppFactory {
    @Override
    public UserInterface createUI() {
        return new HomePage();
    }

    @Override
    public Interactable createHandler() {
        Scanner scanner = new Scanner(System.in);
        InputManager input = new InputManager(scanner);
        DataManager data = new DataManager();

        return new MenuHandler(data, input);
    }
}