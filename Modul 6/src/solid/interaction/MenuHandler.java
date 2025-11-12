package solid.interaction;

import solid.core.Interactable;
import solid.data.DataManager;
import solid.io.InputManager;

public class MenuHandler implements Interactable {
    private final DataManager data;
    private final InputManager input;

    public MenuHandler(DataManager data, InputManager input) {
        this.data = data;
        this.input = input;
    }

    @Override
    public boolean handleInteraction() {
        String choice = input.readLine("\nPilihan: ");
        switch (choice) {
            case "1" -> {
                String name = input.validateInput("Masukkan Nama Mahasiswa: ");
                String nim = input.validateInput("Masukkan NIM Mahasiswa: ");
                data.insertData(name, nim);
            }
            case "2" -> {
                String id = input.validateInput("Masukkan NIM Mahasiswa yang akan dihapus: ");
                data.removeData(id);
            }
            case "3" -> {
                String id = input.validateInput("Masukkan NIM Mahasiswa yang akan dicari: ");
                data.findData(id);
            }
            case "4" -> data.displayAllData();
            case "0" -> { return false; }
            default -> System.out.println("Input tidak valid, coba lagi.");
        }
        return true;
    }
}