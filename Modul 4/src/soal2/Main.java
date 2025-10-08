package soal2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Pilih jenis hewan yang ingin diinputkan:");
        System.out.println("1 = Kucing");
        System.out.println("2 = Anjing");
        System.out.print("Masukkan pilihan: ");

        int choice = input.nextInt();
        input.nextLine();

        if (choice == 1) {
            System.out.print("Nama Hewan Peliharaan: ");
            String petName = input.nextLine();

            System.out.print("Ras: ");
            String petRace = input.nextLine();

            System.out.print("Warna Bulu: ");
            String furColor = input.nextLine();

            Cat cat = new Cat(petName, petRace, furColor);
            cat.display();
        }
        else if (choice == 2) {
            System.out.print("Nama Hewan Peliharaan: ");
            String petName = input.nextLine();

            System.out.print("Ras: ");
            String petRace = input.nextLine();

            System.out.print("Warna Bulu: ");
            String furColor = input.nextLine();

            System.out.print("Kemampuan: ");
            String ability = input.nextLine();
            String[] abilities = ability.split(",");

            Dog dog = new Dog(petName, petRace, furColor, abilities);
            dog.display();
        }
        else {
            System.out.print("Input tidak valid");
        }
    }
}