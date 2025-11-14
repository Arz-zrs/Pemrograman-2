package design_pattern.interaction;

import design_pattern.command.*;
import design_pattern.core.Interactable;
import design_pattern.data.DataManager;
import design_pattern.io.InputManager;

import java.util.HashMap;

public class MenuHandler implements Interactable {
    private final HashMap<String, Command> commands = new HashMap<>();
    private final InputManager input;

    public MenuHandler(DataManager data, InputManager input) {
        this.input = input;
        commands.put("1", new AddDataCommand(data, input));
        commands.put("2", new RemoveDataCommand(data, input));
        commands.put("3", new SearchDataCommand(data, input));
        commands.put("4", new DisplayAllDataCommand(data));
    }

    @Override
    public boolean handleInteraction() {
        String choice = input.readLine("\nPilihan: ");
        if (choice.equals("0")) return false;
        Command command = commands.get(choice);
        if (command != null) command.execute();
        else System.out.println("Input tidak valid, coba lagi.");
        return true;
    }
}