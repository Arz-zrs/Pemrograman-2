package PRAK202_2410817210010_AryaArrozzaRidhoSyaputra;

public class Coffee {
    private String coffeeName;
    private String buyer;
    private String size;
    private double price;

    public String getCoffeeName() {
        return coffeeName;
    }

    public void setCoffeeName(String coffeeName) {
        this.coffeeName = coffeeName;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public double getTax() {
        return this.price * 11/100;
    }

    public void info() {
        System.out.println("Nama Kopi: " + getCoffeeName());
        System.out.println("Ukuran: " + getSize());
        System.out.printf("Harga: %.1f\n", getPrice());
    }
}