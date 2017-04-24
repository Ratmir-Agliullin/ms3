package main.services;

import main.DAO.AdminDAO;
import main.models.Admin;

import java.util.ArrayList;

/**
 * Created by admin on 23.04.2017.
 */
public class AdminService {
    public boolean AdminAuthCheck(String login, String pass) {
        boolean check = false;
        AdminDAO adminDAO = new AdminDAO();
        ArrayList<Admin> userTableAL = new ArrayList<Admin>();

        for (Admin admin:adminDAO.SelectAdminTable()
                ) {

            if ((admin.getAdminName().equals(login)) && (admin.getAdminPass().equals(pass))) {

                return true;
            }

        }  return false;
    }
}
