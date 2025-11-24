package commandpattern.command;

import commandpattern.data.DataManager;
import commandpattern.io.InputManager;

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
        boolean success = data.insertData(name, id);
        if (success) System.out.println("Mahasiswa " + name + " ditambahkan.");
        else System.out.println("NIM sudah digunakan.");
    }
}