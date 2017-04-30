package main.models.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 * Created by admin on 22.04.2017.
 */
public class DataBaseManager {
    private static Logger log = Logger.getLogger(DataBaseManager.class.getName());


    public Connection initConnection(){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            log.info(e.toString());
        } finally {

        }
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost/Kurs4","postgres", "Kbctyrjgbljh48");
        } catch (SQLException e) {
            log.info(e.toString());
        }

        return connection;
    }
}
