package main.models.DAO;

import main.models.pojo.Admin;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * Created by admin on 22.04.2017.
 */
public class AdminDAO implements AdminInteface {
    private static Logger log = Logger.getLogger(AdminDAO.class.getName());

    /**
     *
     * @return connection
     */


    public Connection initConnection(){

        Connection connection = null;
        try {
            ConnectionPool cp = new ConnectionPool("jdbc:postgresql://localhost/Kurs4","postgres", "Kbctyrjgbljh48");
            try {
                connection =  cp.getConnection();
            } catch (SQLException e) {
                log.info(e.toString());
            }
        } catch (ClassNotFoundException e) {
            log.info(e.toString());
        }

        return connection;
    }

    /**
     * update table in sql
     */
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

    /**
     * Delete table
     */
    public void DeleteAdminTable(int id) {
        Connection connection = initConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "delete from admins WHERE admin_id=?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            log.info(e.toString());
        }
    }

    public void InsertAdminTable() {

    }


    /**
     *
     * @param userTable insert new empty in table
     */
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


    /**
     *
     * @return arraylist of all recors in table
     */
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

    /**
     *
     *
     * @param login
     * @return password, where login = login
     */
    public String SelectAdminPassTable(String login){
        Connection connection = initConnection();
        String resultPass=null;

        try {


            PreparedStatement preparedStatement = connection.prepareStatement(
                    "select admin_pass from public.admins where admin_name = ?");
            preparedStatement.setString(1, login);
            ResultSet result = preparedStatement.executeQuery();
            resultPass = result.getString(1);
        } catch (SQLException e) {
            log.info(e.toString());
        }
        return resultPass;
    }
}
