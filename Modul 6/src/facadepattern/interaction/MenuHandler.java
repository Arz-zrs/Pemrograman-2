package facadepattern.interaction;

import facadepattern.core.Interactable;
import facadepattern.service.StudentService;
import facadepattern.io.InputManager;

public class MenuHandler implements Interactable {
    private final StudentService service;
    private final InputManager input;

    public MenuHandler(StudentService service, InputManager input) {
        this.service = service;
        this.input = input;
    }

    @Override
    public boolean handleInteraction() {
        String choice = input.readLine("\nPilihan: ");
        switch (choice) {
            case "1" -> {
                String name = input.validateInput("Masukkan Nama Mahasiswa: ");
                String nim = input.validateInput("Masukkan NIM Mahasiswa: ");
                service.insertData(name, nim);
            }
            case "2" -> {
                String id = input.validateInput("Masukkan NIM Mahasiswa yang akan dihapus: ");
                service.removeData(id);
            }
            case "3" -> {
                String id = input.validateInput("Masukkan NIM Mahasiswa yang akan dicari: ");
                service.searchData(id);
            }
            case "4" -> service.displayAllData();
            case "0" -> { return false; }
            default -> System.out.println("Input tidak valid, coba lagi.");
        }
        return true;
    }
}