package model;

import java.io.Serializable;
import java.util.*;

public class User implements Serializable {

    private int userId;
    private String login;
    private String password;
    private String name;
    private String cpf;
    //    private Map<String, Double> walletAction;
    private List<WalletAction> wallet;
    private List<String> history;

    public User(String login, String password, String name, String cpf, List<WalletAction> wallet) {
        super();
        this.login = login;
        this.password = password;
        this.name = name;
        this.cpf = cpf;
        this.wallet = wallet;
//        this.walletAction = new HashMap<>(walletAction);
        this.history = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }

    public List<WalletAction> getWallet() {
        return wallet;
    }

    public void setWallet(List<WalletAction> wallet) {
        this.wallet = wallet;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<String> getHistory() {
        return history;
    }

    public void setHistory(List<String> history) {
        this.history = history;
    }

}
