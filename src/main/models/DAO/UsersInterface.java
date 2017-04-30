package main.models.DAO;

import main.models.pojo.Users;

import java.util.List;

/**
 * Created by admin on 22.04.2017.
 */
public interface UsersInterface {

    public void UpdateUserTable();

    void UpdateUserTable(Users userTable);

    public void DeleteUserTable(int id);
    public void InsertUserTable();
    public String SelectUserPassTable(String login);
    void InsertUserTable(Users userTable);
    public void DeleteAllUserTable();
    public List<Users> SelectUserTable();
}
