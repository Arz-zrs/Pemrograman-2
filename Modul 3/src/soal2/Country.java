package soal2;

import java.util.*;

public class Country {
    private String countryName;
    private String governmentType;
    private String leaderName;
    private int independenceDay;
    private int independenceMonth;
    private int independenceYear;



    public Country(String name, String governmentType, String leaderName, int independenceDay, int independenceMonth, int independenceYear) {
        this.countryName = name;
        this.governmentType = governmentType;
        this.leaderName = leaderName;
        this.independenceDay = independenceDay;
        this.independenceMonth = independenceMonth;
        this.independenceYear = independenceYear;
    }

    public Country(String name, String governmentType, String leaderName) {
        this.countryName = name;
        this.governmentType = governmentType;
        this.leaderName = leaderName;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getGovernmentType() {
        return governmentType;
    }

    public String getLeaderName() {
        return leaderName;
    }

    public int getIndependenceDay() {
        return independenceDay;
    }

    public int getIndependenceMonth() {
        return independenceMonth;
    }

    public int getIndependenceYear() {
        return independenceYear;
    }

    public void getInfo() {
        HashMap<Integer, String> monthName = new HashMap<>();
        monthName.put(1, "Januari");
        monthName.put(2, "Februari");
        monthName.put(3, "Maret");
        monthName.put(4, "April");
        monthName.put(5, "Mei");
        monthName.put(6, "Juni");
        monthName.put(7, "Juli");
        monthName.put(8, "Agustus");
        monthName.put(9, "September");
        monthName.put(10, "Oktober");
        monthName.put(11, "November");
        monthName.put(12, "Desember");

        if (governmentType.equalsIgnoreCase("monarki")) {
            System.out.println("Negara " + getCountryName() + " mempunyai Raja bernama " + getLeaderName());
            System.out.println();
        }
        else {
            System.out.println("Negara " + getCountryName() + " mempunyai " + getGovernmentType() + " bernama " + getLeaderName());
            System.out.println("Deklarasi Kemerdekaan pada Tanggal " + getIndependenceDay() + " " + monthName.get(getIndependenceMonth()) + " " + getIndependenceYear());
            System.out.println();
        }
    }
}