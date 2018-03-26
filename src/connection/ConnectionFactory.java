package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public ConnectionFactory() {

    }

    public Connection connection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/wallet", "root", "root");
            return connection;
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error: " + e);
            return null;
        }
    }

}
