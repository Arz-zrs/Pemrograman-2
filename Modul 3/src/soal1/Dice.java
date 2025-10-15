package soal1;

import java.util.*;

public class Dice {
    private int rolledDice;

    public void randomizeNumber() {
        Random rand = new Random();
        this.rolledDice = rand.nextInt(6) + 1;
    }

    public int getRolledDice() {
        return rolledDice;
    }
}