package design_pattern.core;

public class AppLogic {
    private final UserInterface view;
    private final Interactable handler;
    private boolean running = true;

    public AppLogic(UserInterface view, Interactable handler) {
        this.view = view;
        this.handler = handler;
    }

    public void run() {
        while (running) {
            view.showUI();
            running = handler.handleInteraction();
        }
        System.out.println("Shutting down...");
    }
}