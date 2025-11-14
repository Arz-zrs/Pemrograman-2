package design_pattern.core;

public abstract class UserInterface {
    public void showUI() {
        System.out.println("\n========= MHS DATABASE =========");
        displayBody();
        System.out.print("======== (C) 2025 MHS DB =======");
    }

    protected abstract void displayBody();
}

