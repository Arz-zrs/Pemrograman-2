package factorypattern.factory;

import factorypattern.data.DataManager;
import factorypattern.core.Interactable;
import factorypattern.core.UserInterface;
import factorypattern.interaction.MenuHandler;
import factorypattern.io.InputManager;
import factorypattern.pages.HomePage;

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