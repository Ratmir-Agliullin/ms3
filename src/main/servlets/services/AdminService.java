package main.servlets.services;

import main.models.DAO.AdminDAO;
import main.models.pojo.Admin;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 23.04.2017.
 */
@Service
public class AdminService {

  private   AdminDAO adminDAO = new AdminDAO();

 //   @Autowired
//    public void setAdminDAO(AdminDAO adminDAO) {
//        this.adminDAO = adminDAO;
//    }




    /**
     * Authorization for admins
     *
     * @param login
     * @param pass
     * @return
     */
    public boolean AdminAuthCheck(String login, String pass) {
        boolean check = false;

        ArrayList<Admin> userTableAL = new ArrayList<Admin>();

        for (Admin admin : adminDAO.SelectAdminTable()
                ) {

            if ((admin.getAdminName().equals(login)) && (admin.getAdminPass().equals(pass))) {

                return true;
            }

        }
        return false;
    }


    public boolean AdminLoginRepeatCheck(String login) {



        for (Admin admin : adminDAO.SelectAdminTable()
                ) {

            if (admin.getAdminName().equals(login)) {

                return true;
            }

        }
        return false;
    }
    public List<Admin> SelectAdminsFromTable(){
        return adminDAO.SelectAdminTable();
    }
    public void InsertInAdmin(Admin admin){
        adminDAO.InsertAdminTable(admin);
    }
}