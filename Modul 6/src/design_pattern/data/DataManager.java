package design_pattern.data;

import java.util.ArrayList;
import java.util.Iterator;

public class DataManager {
    private final ArrayList<Student> studentList = new ArrayList<>();

    public void insertData(String name, String id) {
        for (Student s : studentList) {
            if (s.getId().equals(id)) {
                System.out.println("NIM sudah digunakan");
                return;
            }
        }
        studentList.add(new Student(name, id));
        System.out.println("Mahasiswa " + name + " ditambahkan.");
    }

    public void removeData(String id) {
        Iterator<Student> iterator = studentList.iterator();
        boolean found = false;

        while (iterator.hasNext()) {
            Student s = iterator.next();
            if (s.getId().equals(id)) {
                iterator.remove();
                found = true;
                System.out.println("Mahasiswa dengan NIM " + id + " dihapus.");
                break;
            }
        }

        if (!found) {
            System.out.println("NIM tidak ditemukan.");
        }
    }

    public void findData(String id) {
        for (Student s : studentList) {
            if (s.getId().equals(id)) {
                System.out.println("NIM: " + s.getId() + ", Nama: " + s.getName());
                return;
            }
        }
        System.out.println("NIM tidak ditemukan.");
    }

    public void displayAllData() {
        if (studentList.isEmpty()) {
            System.out.println("Daftar Mahasiswa Kosong.");
        } else {
            System.out.println("Daftar Mahasiswa:");
            for (Student s : studentList) {
                System.out.println("NIM: " + s.getId() + ", Nama: " + s.getName());
            }
        }
    }
}