package model;

import java.io.Serializable;
import java.util.List;

public class WalletCoin implements Serializable {

    private String nameCoin;
    private double qtd;

    public WalletCoin(String nameCoin, double qtd) {
        this.nameCoin = nameCoin;
        this.qtd = qtd;
    }

    public String getNameCoin() {
        return nameCoin;
    }

    public void setNameCoin(String nameCoin) {
        this.nameCoin = nameCoin;
    }

    public double getQtd() {
        return qtd;
    }

    public void setQtd(double qtd) {
        this.qtd = qtd;
    }
}
