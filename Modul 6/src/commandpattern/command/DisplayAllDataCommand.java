package commandpattern.command;

import commandpattern.data.DataManager;

public class DisplayAllDataCommand implements Command {
    private final DataManager data;

    public DisplayAllDataCommand(DataManager data) {
        this.data = data;
    }

    @Override
    public void execute() {
        var students = data.displayAllData();
        if (students.isEmpty()) {
            System.out.println("Daftar Mahasiswa Kosong.");
        } else {
            System.out.println("Daftar Mahasiswa:");
            students.forEach(s -> System.out.println("NIM: " + s.getId() + ", Nama: " + s.getName()));
        }
    }
}