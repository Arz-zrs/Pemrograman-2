package factorypattern;

import factorypattern.core.AppLogic;
import factorypattern.core.Interactable;
import factorypattern.core.UserInterface;
import factorypattern.factory.AppFactory;
import factorypattern.factory.DefaultAppFactory;

public class Main {
    public static void main(String[] args) {
        AppFactory factory = new DefaultAppFactory();

        UserInterface view = factory.createUI();
        Interactable handler = factory.createHandler();

        AppLogic app = new AppLogic(view, handler);
        app.run();
    }
}