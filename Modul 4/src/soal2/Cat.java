package soal2;

public class Cat extends Pet {
    private String furColor;

    public Cat(String name, String race, String furColor) {
        super(name, race);
        this.furColor = furColor;
    }

    @Override
    public void display() {
        System.out.println("Detail Hewan Peliharaan:");
        System.out.println("Nama hewan peliharaanku adalah: " + getName());
        System.out.println("Dengan ras: " + getRace());
        System.out.println("Memiliki warna bulu: " + furColor);
    }
}