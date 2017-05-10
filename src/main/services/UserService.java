package main.services;

import main.models.DAO.UsersDAO;
import main.models.pojo.HashCode;
import main.models.pojo.UserRole;
import main.models.pojo.Users;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 22.04.2017.
 */
@Service
public class UserService {


    private UsersDAO usersDAO=new UsersDAO();

    private UserRoleService userRoleService;
    @Autowired
    public void setUserRoleService(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    private HashCode hashCode;
    @Autowired
    public void setHashCode(HashCode hashCode) {
        this.hashCode = hashCode;
    }

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



        for (Users user:usersDAO.SelectUserTable()
                ) {

            if (user.getUserName().equals(login)) {

                return true;
            }

        }
        return false;
    }
    public String UserPassCheck(String login) {




      return usersDAO.SelectUserPassTable(login);
    }
    public List<Users> SelectUsersFromTable(){
        return usersDAO.SelectUserTable();
    }
    public void DeleteUsers(int delete_id){
        usersDAO.DeleteUserTable(delete_id);
    }

public void InsertInTable(Users users){
    usersDAO.InsertUserTable(users);
    UserRole userRole = new UserRole();
    userRole.setRole("user");
    userRole.setUser_name(users.getUserName());
    userRoleService.InsertNewUserRole(userRole);
}
public int SelectUserIdFromName(String username){return usersDAO.SelectIdFromName(username);}

}
