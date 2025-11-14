package design_pattern.command;

import design_pattern.data.DataManager;
import design_pattern.io.InputManager;

public class AddDataCommand implements Command {
    private final DataManager data;
    private final InputManager input;

    public AddDataCommand(DataManager data, InputManager input) {
        this.data = data;
        this.input = input;
    }


    @Override
    public void execute() {
        String name = input.validateInput("Masukkan Nama Mahasiswa: ");
        String id = input.validateInput("Masukkan NIM Mahasiswa: ");
        data.insertData(name, id);
    }
}