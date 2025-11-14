package design_pattern.io;

import java.util.Scanner;

public class InputManager {
    private final Scanner scanner;

    public InputManager(Scanner scanner) {
        this.scanner = scanner;
    }

    public String validateInput(String prompt) {
        String input;
        do {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
            if (input.isEmpty()) System.out.println("Input tidak boleh kosong!");
        } while (input.isEmpty());
        return input;
    }

    public String readLine(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }
}