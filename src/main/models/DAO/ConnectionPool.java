package main.models.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by admin on 22.04.2017.
 */
public class ConnectionPool {

    private String url, user, password;

    ConnectionPool(String url, String user, String password) throws ClassNotFoundException {
        this.url = url;
        this.user = user;
        this.password = password;
        Class.forName("org.postgresql.Driver");
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public void closeConnection(Connection connection) throws SQLException {
        connection.close();
    }
}
