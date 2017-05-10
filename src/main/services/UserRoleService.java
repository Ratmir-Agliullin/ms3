package main.services;

import main.models.DAO.UserRoleDAO;
import main.models.pojo.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by admin on 08.05.2017.
 */
@Service
public class UserRoleService {
    private UserRoleDAO userRoleDAO;
@Autowired
    public void setUserRoleDAO(UserRoleDAO userRoleDAO) {
        this.userRoleDAO = userRoleDAO;
    }


    public void InsertNewUserRole(UserRole userRole){
    userRoleDAO.InsertUserRole(userRole);
    }

    public String GetRoleByUserName(String login){return userRoleDAO.GetRoleByUserName(login);}
}
