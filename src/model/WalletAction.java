package model;

import java.io.Serializable;
import java.util.List;

public class WalletAction implements Serializable {

    private String nameAction;
    private double qtd;

    public WalletAction(String nameAction, double qtd) {
        this.nameAction = nameAction;
        this.qtd = qtd;
    }

    public String getNameAction() {
        return nameAction;
    }

    public void setNameAction(String nameAction) {
        this.nameAction = nameAction;
    }

    public double getQtd() {
        return Math.round(this.qtd * 100) / 100d;
    }

    public void setQtd(double qtd) {
        this.qtd = qtd;
    }
}
