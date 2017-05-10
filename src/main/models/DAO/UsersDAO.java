package main.models.DAO;

import main.models.pojo.Users;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


/**
 * Created by admin on 22.04.2017.
 */
public class UsersDAO implements UsersInterface{
    private static Logger log = Logger.getLogger(UsersDAO.class.getName());

    /**
     *
     * @return connection with dataBase
     */

    public Connection initConnection() {

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            log.info(e.toString());
        } finally {

        }
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost/Kurs4", "postgres", "Kbctyrjgbljh48");
        } catch (SQLException e) {
            log.info(e.toString());
        }

        return connection;
    }

    /**
     *
     * Update table
     */

    public void UpdateUserTable() {

    }

    public void UpdateUserTable(Users userTable) {
        Connection connection = initConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "update users set password = ? where id=?");
            preparedStatement.setString(1, userTable.getPassName());
            preparedStatement.setInt(2, userTable.getId());



            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            log.info(e.toString());
        }
    }

    /**
     *
     *
     * @param id Delete user which has user_id = id from table
     */
    public void DeleteUserTable(int id) {
        Connection connection = initConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "delete from users where user_id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            log.info(e.toString());
        }
    }


    /**
     *
     * delete all users
     */
    public void DeleteAllUserTable() {
        Connection connection = initConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "delete from users");
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            log.info(e.toString());
        }
    }

    public void InsertUserTable() {

    }


    /**
     *
     *
     * Insert new user in table
     * @param userTable
     */
    public void InsertUserTable(Users userTable) {
       Connection connection = initConnection();
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {

        }
        try {
//            Connection myConnection2 = DriverManager.getConnection("jdbc:postgresql://localhost/Kurs4", "postgres", "Kbctyrjgbljh48");
//            PreparedStatement preparedStatement =
//                    myConnection2.prepareStatement("INSERT INTO  users(user_name,user_pass) VALUES (?,?)");

            PreparedStatement preparedStatement = connection.prepareStatement(
                   "INSERT INTO  users(username,password) VALUES (?,?)");
            preparedStatement.setString(1, userTable.getUserName());
            preparedStatement.setString(2, userTable.getPassName());


            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            log.info(e.toString());
        }
    }

    /**
     *
     *
     * Get List consist of records users
     * @return
     */
    public List<Users> SelectUserTable() {
        Connection connection = initConnection();
        List<Users> userTableAL = new ArrayList<Users>();

        try {
            Statement statement = connection.createStatement();
            ResultSet result =
                    statement.executeQuery("select * from public.users order by user_id asc");
            while (result.next()) {
                Users userTable = new Users();
                userTable.setId(result.getInt(1));
                userTable.setUserName(result.getString(2));
                userTable.setPassName(result.getString(3));
                userTableAL.add(userTable);

            }
        } catch (SQLException e) {
            log.info(e.toString());
        }
        return userTableAL;
    }

    @Override
    public int SelectIdFromName(String username) {
        Connection connection = initConnection();
       int user_id=0;
        try {
            Statement statement = connection.createStatement();
            ResultSet result =
                    statement.executeQuery("select user_id from public.users WHERE username='" + username+"'" );
            while (result.next())
           user_id=result.getInt(1);

        } catch (SQLException e) {
            log.info(e.toString());
        }
        return user_id;
    }

    public String SelectUserPassTable(String login) {
        Connection connection = initConnection();
       String resultPass=null;

        try {


            PreparedStatement preparedStatement = connection.prepareStatement(
                    "select user_pass from public.users where username = ?");
            preparedStatement.setString(1, login);
            ResultSet result = preparedStatement.executeQuery();
            resultPass = result.getString(1);
        } catch (SQLException e) {
            log.info(e.toString());
        }
        return resultPass;
    }
}
