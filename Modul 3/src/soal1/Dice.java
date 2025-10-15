package soal1;

import java.util.*;

public class Dice {
    private int rollAmount;
    private int min = 1;
    private int max = 6;

    public void setRollAmount(int rollAmount) {
        this.rollAmount = rollAmount;
    }

    public void randomizeNumber() {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= 6; i++) list.add(i);

        Random rand = new Random();
        int total = 0;

        for (int i = 0; i < rollAmount; i++) {
            int rolledDice = rand.nextInt(max) + min;
            System.out.println("Dadu ke-" + (i + 1) + " bernilai " + rolledDice);
            total += rolledDice;
        }
        System.out.println("Total nilai dadu keseluruhan " + total);
    }
}