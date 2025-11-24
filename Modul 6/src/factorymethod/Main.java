package factorymethod;

import factorymethod.core.AppLogic;
import factorymethod.core.Interactable;
import factorymethod.core.UserInterface;
import factorymethod.factory.AppFactory;
import factorymethod.factory.DefaultAppFactory;

public class Main {
    public static void main(String[] args) {
        AppFactory factory = new DefaultAppFactory();

        UserInterface view = factory.createUI();
        Interactable handler = factory.createHandler();

        AppLogic app = new AppLogic(view, handler);
        app.run();
    }
}