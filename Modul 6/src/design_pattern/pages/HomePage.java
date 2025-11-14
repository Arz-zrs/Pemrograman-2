package design_pattern.pages;

import design_pattern.core.UserInterface;

public class HomePage extends UserInterface {
    @Override
    protected void displayBody(){
        System.out.println("Menu:");
        System.out.println("1. Tambah Mahasiswa");
        System.out.println("2. Hapus Mahasiswa Berdasarkan NIM");
        System.out.println("3. Cari Mahasiswa Berdasarkan NIM");
        System.out.println("4. Tampilkan Daftar Mahasiswa");
        System.out.println("0. Keluar");
    }
}
