package main.services;

import main.DAO.UsersDAO;
import main.models.Users;

import java.util.ArrayList;

/**
 * Created by admin on 22.04.2017.
 */
public class UserService {
    public boolean UserAuthCheck(String login, String pass) {
        boolean check = false;
        UsersDAO usersDAO = new UsersDAO();
        ArrayList<Users> userTableAL = new ArrayList<Users>();

        for (Users user:usersDAO.SelectUserTable()
             ) {

                         if ((user.getUserName().equals(login)) && (user.getPassName().equals(pass))) {

                return true;
            }

        }  return false;
    }
    public boolean UserLoginRepeatCheck(String login) {

        UsersDAO usersDAO = new UsersDAO();

        for (Users user:usersDAO.SelectUserTable()
                ) {

            if (user.getUserName().equals(login)) {

                return true;
            }

        }  return false;
    }



}
