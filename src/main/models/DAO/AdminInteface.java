package main.models.DAO;

import main.models.pojo.Admin;

import java.util.ArrayList;

/**
 * Created by admin on 22.04.2017.
 */
public interface AdminInteface {
    public void UpdateAdminTable();

    void UpdateAdminTable(Admin userTable);

    public void DeleteAdminTable(int id);
    public void InsertAdminTable();

    void InsertAdminTable(Admin userTable);
    public String SelectAdminPassTable(String login);
    public ArrayList<Admin> SelectAdminTable();
}
