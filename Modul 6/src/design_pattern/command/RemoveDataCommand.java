package design_pattern.command;

import design_pattern.data.DataManager;
import design_pattern.io.InputManager;

public class RemoveDataCommand implements Command {
    private final DataManager data;
    private final InputManager input;

    public RemoveDataCommand(DataManager data, InputManager input) {
        this.data = data;
        this.input = input;
    }

    @Override
    public void execute() {
        String id = input.validateInput("Masukkan NIM Mahasiswa yang akan dihapus: ");
        data.removeData(id);
    }
}