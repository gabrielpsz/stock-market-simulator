package model;

import java.io.Serializable;

public class Wallet implements Serializable {

    private String nameUser;
    private double quant;

    public Wallet(String nameUser, double quant) {
        this.nameUser = nameUser;
        this.quant = quant;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public double getQuant() {
        return quant;
    }

    public void setQuant(double quant) {
        this.quant = quant;
    }

    @Override
    public String toString() {
        return "Wallet{" +
                "nameUser='" + nameUser + '\'' +
                ", quant=" + quant +
                '}';
    }
}
