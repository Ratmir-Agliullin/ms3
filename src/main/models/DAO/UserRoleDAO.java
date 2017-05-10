package main.models.DAO;

import main.models.pojo.UserRole;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 * Created by admin on 08.05.2017.
 */
@Service
public class UserRoleDAO {

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

    public void InsertUserRole(UserRole userTable) {
        Connection connection = initConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO  user_role(username, role) VALUES (?,?)");
            preparedStatement.setString(1, userTable.getUser_name());
            preparedStatement.setString(2, userTable.getRole());


            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            log.info(e.toString());
        }
    }

    public String GetRoleByUserName(String login){
        Connection connection = initConnection();
        String resultPass=null;

        try {


            PreparedStatement preparedStatement = connection.prepareStatement(
                    "select role from public.user_role where username = ?");
            preparedStatement.setString(1, login);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next())
            resultPass = result.getString(1);
        } catch (SQLException e) {
            log.info(e.toString());
        }
        return resultPass;
    }
}
