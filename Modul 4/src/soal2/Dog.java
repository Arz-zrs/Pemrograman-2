package soal2;

public class Dog extends Pet {
    private String furColor;
    private String[] abilities;

    public Dog(String name, String race, String furColor, String[] abilities) {
        super(name, race);
        this.furColor = furColor;
        this.abilities = abilities;
    }

    @Override
    public void display() {
        System.out.println("Detail Hewan Peliharaan:");
        System.out.println("Nama hewan peliharaanku adalah: " + getName());
        System.out.println("Dengan ras: " + getRace());
        System.out.println("Memiliki warna bulu: " + furColor);
        System.out.print("Kemampuan: ");
        for (String ability : abilities) {
            System.out.print(ability);
        }
    }
}