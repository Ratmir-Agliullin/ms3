package main.DAO;

import main.models.Admin;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * Created by admin on 22.04.2017.
 */
public class AdminDAO implements AdminInteface {
    private static Logger log = Logger.getLogger(AdminDAO.class.getName());
    public Connection initConnection(){

        Connection connection = null;
        try {
            ConnectionPool cp = new ConnectionPool("jdbc:postgresql://localhost/Kurs4","postgres", "Kbctyrjgbljh48");
            try {
                connection =  cp.getConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return connection;
    }


    public void UpdateAdminTable() {

    }

    public void UpdateAdminTable(Admin userTable) {
        Connection connection = initConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "update admins set admin_pass = ? where id=?");
            preparedStatement.setString(1, userTable.getAdminPass());
            preparedStatement.setInt(2, userTable.getId());



            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            log.info(e.toString());
        }
    }

    public void DeleteAdminTable() {
        Connection connection = initConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "delete from admins");
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            log.info(e.toString());
        }
    }

    public void InsertAdminTable() {

    }

    public void InsertAdminTable(Admin userTable) {
        Connection connection = initConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO  admins(admin_name,admin_pass) VALUES (?,?)");
            preparedStatement.setString(1, userTable.getAdminName());
            preparedStatement.setString(2, userTable.getAdminPass());


            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            log.info(e.toString());
        }
    }

    public ArrayList<Admin> SelectAdminTable() {
        Connection connection = initConnection();
        ArrayList<Admin> userTableAL = new ArrayList<Admin>();
             try {
            Statement statement = connection.createStatement();
            ResultSet result =
                    statement.executeQuery("select * from public.admins");
            while (result.next()) {
                Admin userTable = new Admin();
                userTable.setId(result.getInt(1));
                userTable.setAdminName(result.getString(2));
                userTable.setAdminPass(result.getString(3));
                userTableAL.add(userTable);

            }
        } catch (SQLException e) {
            log.info(e.toString());
        }
        return userTableAL;

    }
}
