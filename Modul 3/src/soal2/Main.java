package soal2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<Country> countries = new LinkedList<>();

        int limit = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < limit; i++) {
            String countryName = sc.nextLine();
            String government = sc.nextLine();
            String leaderName = sc.nextLine();

            if (government.equalsIgnoreCase("monarki")) {
                countries.add(new Country(countryName, government, leaderName));
            }
            else {
                int day = sc.nextInt();
                int month = sc.nextInt();
                int year = sc.nextInt();
                sc.nextLine();

                countries.add(new Country(countryName, government, leaderName, day, month, year));
            }
        }
        for (Country country : countries) {
            country.getInfo();
        }
    }
}