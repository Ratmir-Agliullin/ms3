package main.services;

import main.DAO.UsersDAO;
import main.models.Users;
import org.mindrot.jbcrypt.BCrypt;

import java.util.ArrayList;

/**
 * Created by admin on 22.04.2017.
 */
public class UserService {

    /**
     *
     *
     * Authorization for admins
     * @param login
     * @param pass
     * @return
     */
    public boolean UserAuthCheck(String login, String pass) {
        boolean check = false;
        UsersDAO usersDAO = new UsersDAO();
        ArrayList<Users> userTableAL = new ArrayList<Users>();

        for (Users user:usersDAO.SelectUserTable()
             ) {

                       //  if ((user.getUserName().equals(login)) && (BCrypt.checkpw(pass,user.getPassName()))) {
            if ((user.getUserName().equals(login)) && (BCrypt.checkpw(pass,user.getPassName()))) {
                return true;
            }

        }return false;
    }
    public boolean UserLoginRepeatCheck(String login) {

        UsersDAO usersDAO = new UsersDAO();

        for (Users user:usersDAO.SelectUserTable()
                ) {

            if (user.getUserName().equals(login)) {

                return true;
            }

        }
        return false;
    }
    public String UserPassCheck(String login) {

        UsersDAO usersDAO = new UsersDAO();


      return usersDAO.SelectUserPassTable(login);
    }



}
