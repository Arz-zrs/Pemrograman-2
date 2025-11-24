package factorymethod.factory;

import factorymethod.core.Interactable;
import factorymethod.core.UserInterface;

public interface AppFactory {
    UserInterface createUI();
    Interactable createHandler();
}