package PRAK201_2410817210010_AryaArrozzaRidhoSyaputra;

public class Fruits {
    private String name;
    private double weight;
    private double price;
    private double quantity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double amountPrice() {
        return this.price * this.quantity / this.weight;
    }

    public double discountTotal() {
        int discPerWeight = (int)(this.quantity/4);
        return discPerWeight * (4 * this.price) * 0.02;
    }

    public double discountedPrice() {
        return amountPrice() - discountTotal();
    }
}