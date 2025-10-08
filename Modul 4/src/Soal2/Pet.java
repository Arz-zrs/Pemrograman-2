package Soal2;

public class Pet {
    private String name;
    private String race;

    public Pet(String name, String race) {
        this.name = name;
        this.race = race;
    }

    public String getName() {
        return name;
    }

    public String getRace() {
        return race;
    }

    public void display() {
        System.out.println("Detail Hewan Peliharaan:");
        System.out.println("Nama hewan peliharaanku adalah: " + name);
        System.out.println("Dengan ras: " + race);
    }
}