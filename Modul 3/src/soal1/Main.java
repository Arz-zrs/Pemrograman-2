package soal1;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rollAmount = sc.nextInt();

        LinkedList<Dice> list = new LinkedList<>();
        for (int i = 1; i <= rollAmount; i++) {
            Dice dice = new Dice();
            dice.randomizeNumber();
            list.add(dice);
        }

        int total = 0;
        for (int i = 0; i < list.size(); i++) {
            int roll = list.get(i).getRolledDice();
            System.out.println("Dadu ke-" + (i + 1) + " bernilai " + roll);
            total += roll;
        }
        System.out.println("Total nilai dadu keseluruhan " + total);

        sc.close();
    }
}