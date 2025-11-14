package design_pattern.command;

import design_pattern.data.DataManager;

public class DisplayAllDataCommand implements Command {
    private final DataManager data;

    public DisplayAllDataCommand(DataManager data) {
        this.data = data;
    }

    @Override
    public void execute() {
        data.displayAllData();
    }
}