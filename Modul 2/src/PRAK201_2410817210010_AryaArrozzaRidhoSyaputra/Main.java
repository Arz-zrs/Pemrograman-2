package PRAK201_2410817210010_AryaArrozzaRidhoSyaputra;

public class Main {
    public static void main(String[] args) {
        Fruits apple = new Fruits();
        Fruits mango = new Fruits();
        Fruits avocado = new Fruits();

        apple.setName("Apel");
        mango.setName("mangga");
        avocado.setName("alpukat");

        apple.setWeight(0.4);
        mango.setWeight(0.2);
        avocado.setWeight(0.25);

        apple.setPrice(7000.0);
        mango.setPrice(3500.0);
        avocado.setPrice(10000.0);

        apple.setQuantity(40);
        mango.setQuantity(15);
        avocado.setQuantity(12);

        System.out.println("Nama Buah: " + apple.getName());
        System.out.println("Berat: " + apple.getWeight());
        System.out.println("Harga: " + apple.getPrice());
        System.out.println("Jumlah Beli: " + apple.getQuantity() + "kg");
        System.out.printf("Harga Sebelum Diskon: Rp%.2f\n", apple.getAmountPrice());
        System.out.printf("Total Diskon: Rp%.2f\n", apple.getDiscountTotal());
        System.out.printf("Harga Setelah Diskon: Rp%.2f\n\n", apple.getDiscountedPrice());

        System.out.println("Nama Buah: " + mango.getName());
        System.out.println("Berat: " + mango.getWeight());
        System.out.println("Harga: " + mango.getPrice());
        System.out.println("Jumlah Beli: " + mango.getQuantity() + "kg");
        System.out.printf("Harga Sebelum Diskon: Rp%.2f\n", mango.getAmountPrice());
        System.out.printf("Total Diskon: Rp%.2f\n", mango.getDiscountTotal());
        System.out.printf("Harga Setelah Diskon: Rp%.2f\n\n", mango.getDiscountedPrice());

        System.out.println("Nama Buah: " + avocado.getName());
        System.out.println("Berat: " + avocado.getWeight());
        System.out.println("Harga: " + avocado.getPrice());
        System.out.println("Jumlah Beli: " + avocado.getQuantity() + "kg");
        System.out.printf("Harga Sebelum Diskon: Rp%.2f\n", avocado.getAmountPrice());
        System.out.printf("Total Diskon: Rp%.2f\n", avocado.getDiscountTotal());
        System.out.printf("Harga Setelah Diskon: Rp%.2f\n", avocado.getDiscountedPrice());
    }
}