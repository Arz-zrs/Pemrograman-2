package soal2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<Country> countries = new LinkedList<>();

        int limit;
        do {
            while(!sc.hasNextInt()) {
                System.out.println("Invalid input, try again");
                sc.next();
            }
            limit = sc.nextInt();
            if (limit < 1) System.out.println("Invalid input, try again");
        }
        while (limit < 1);
        sc.nextLine();

        for (int i = 0; i < limit; i++) {
            String countryName = sc.nextLine();
            String government = sc.nextLine();
            String leaderName = sc.nextLine();

            if (government.equalsIgnoreCase("monarki")) {
                countries.add(new Country(countryName, government, leaderName));
            }
            else {
                int day;
                do {
                    while (!sc.hasNextInt()) {
                        System.out.println("Invalid input, try again");
                        sc.next();
                    }
                    day = sc.nextInt();
                    if (day < 1 || day > 31) System.out.println("Invalid input, try again");
                }
                while (day < 1 || day > 31);

                int month;
                do {
                    while (!sc.hasNextInt()) {
                        System.out.println("Invalid input, try again");
                        sc.next();
                    }
                    month = sc.nextInt();
                    if (month < 1 || month > 12) System.out.println("Invalid input, try again");
                }
                while (month < 1 || month > 12);

                int year;
                do {
                    while(!sc.hasNextInt()) {
                        System.out.println("Invalid input, try again");
                        sc.next();
                    }
                    year = sc.nextInt();
                    if (year < 1) System.out.println("Invalid input, try again");
                }
                while (year < 1);
                sc.nextLine();

                countries.add(new Country(countryName, government, leaderName, day, month, year));
            }
        }
        for (Country country : countries) {
            country.getInfo();
        }
        sc.close();
    }
}