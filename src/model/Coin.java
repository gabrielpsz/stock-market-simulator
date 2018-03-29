package model;

public class Coin {

    private String name;
    private float price;

    public Coin(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Coin{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
