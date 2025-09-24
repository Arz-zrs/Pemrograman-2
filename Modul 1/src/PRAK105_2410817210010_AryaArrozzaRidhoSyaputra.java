import java.util.Scanner;

public class PRAK105_2410817210010_AryaArrozzaRidhoSyaputra {
    public static float pi = 3.14F;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Masukkan jari-jari: ");
        float radius = sc.nextFloat();

        System.out.print("Masukkan Tinggi: ");
        float height = sc.nextFloat();

        float volume = pi * radius * radius * height;
        System.out.printf("Volume tabung dengan jari-jari %2.1f cm dan tinggi %2.1f cm adalah %4.3f m3", radius, height, volume);
    }
}
