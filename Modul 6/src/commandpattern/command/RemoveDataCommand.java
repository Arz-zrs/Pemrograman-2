package commandpattern.command;

import commandpattern.data.DataManager;
import commandpattern.io.InputManager;

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
        boolean success = data.removeData(id);
        if (success) System.out.println("Mahasiswa dengan NIM " + id + " dihapus.");
        else System.out.println("NIM tidak ditemukan.");
    }
}