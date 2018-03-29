package model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class User implements Serializable {

    private int userId;
    private String login;
    private String password;
    private String name;
    private String cpf;
//    private Map<String, float> wallet;


    public User(int userId, String login, String password, String name, String cpf) {
        super();
        this.userId = userId;
        this.login = login;
        this.password = password;
        this.name = name;
        this.cpf = cpf;
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
}
