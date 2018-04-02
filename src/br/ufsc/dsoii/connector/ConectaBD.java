package br.ufsc.dsoii.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectaBD {

    public ConectaBD(){
        conexao();
    }

    public Connection conexao(){
        try {
            Class.forName("org.postgresql.Driver");
            Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dsoii", "postgres", "postgres");
            return conexao;
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("error:" + e);
            return null;
        }
    }
}

