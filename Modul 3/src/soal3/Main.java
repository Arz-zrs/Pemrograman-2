package soal3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Students> studentList = new ArrayList<>();

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Hapus Mahasiswa Berdasarkan NIM");
            System.out.println("3. Cari Mahasiswa Berdasarkan NIM");
            System.out.println("4. Tampilkan Daftar Mahasiswa");
            System.out.println("0. Keluar");
            System.out.print("Pilihan: ");

            String choice = sc.nextLine();

            switch (choice) {
                case "0":
                    studentList.clear();
                    System.out.println("Terima Kasih!");
                    sc.close();
                    System.exit(0);

                case "1":
                    System.out.print("Masukkan Nama Mahasiswa: ");
                    String student = sc.nextLine();
                    System.out.print("Masukkan NIM Mahasiswa (harus unuk): ");
                    String ID = sc.nextLine();

                    boolean duplicateExists = false;
                    for (Students cStudent : studentList) {
                        if (ID.equals(cStudent.getID())) {
                            duplicateExists = true;
                            break;
                        }
                    }

                    if (duplicateExists) System.out.println("NIM sudah digunakan.");
                    else {
                        studentList.add(new Students(student, ID));
                        System.out.println("Mahasiswa " + student + " ditambahkan.");
                    }
                    break;

                case "2":
                    System.out.print("Masukkan NIM Mahasiswa yang akan dihapus: ");
                    String deleteID = sc.nextLine();

                    boolean isIDFound = false;
                    for (Students cStudent : studentList) {
                        if (deleteID.equals(cStudent.getID())) {
                            isIDFound = true;
                            studentList.remove(cStudent);
                            System.out.println("Mahasiswa dengan NIM " + deleteID + " dihapus.");
                            break;
                        }
                    }
                    if (!isIDFound) System.out.println("NIM tidak ditemukan.");
                    break;

                case "3":
                    System.out.print("Masukkan NIM Mahasiswa yang akan dicari: ");
                    String searchID = sc.nextLine();

                    boolean hasIDfound = false;
                    for (Students cStudent : studentList) {
                        if (searchID.equals(cStudent.getID())) {
                            hasIDfound = true;
                            System.out.println("NIM: " + cStudent.getID() + ", Nama: " + cStudent.getName());
                            break;
                        }
                    }
                    if (!hasIDfound) System.out.println("NIM tidak ditemukan.");
                    break;

                case "4":
                    System.out.println("Daftar Mahasiswa:");
                    if (studentList.isEmpty()) System.out.println("Daftar Mahasiswa Kosong.");
                    else {
                        for (Students cStudent : studentList) {
                            System.out.println("NIM: " + cStudent.getID() + ", Nama: " + cStudent.getName());
                        }
                    }
                    break;

                default:
                    System.out.println("Input tidak valid, coba lagi");
            }
        }
    }
}