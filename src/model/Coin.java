package model;

public class Coin {

    private String extId;
    private String name;
    private float price;

    public Coin(String extId, String name, float price) {
        this.extId = extId;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Coin{" +
                "extId='" + extId + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public String getExtId() {
        return extId;
    }

    public void setExtId(String extId) {
        this.extId = extId;
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
