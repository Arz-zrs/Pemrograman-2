package soal1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Dice dice = new Dice();

        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        dice.setRollAmount(input);
        dice.randomizeNumber();
    }
}