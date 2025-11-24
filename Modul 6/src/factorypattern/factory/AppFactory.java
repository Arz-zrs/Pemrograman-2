package factorypattern.factory;

import factorypattern.core.Interactable;
import factorypattern.core.UserInterface;

public interface AppFactory {
    UserInterface createUI();
    Interactable createHandler();
}