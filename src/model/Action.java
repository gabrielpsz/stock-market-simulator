package model;

import java.io.Serializable;

public class Action implements Serializable {

    private String name;
    private double price;

    public Action(String name, double price) {
        super();
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return getName() +" - "+ getPrice();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
