package main.DAO;

import main.models.Users;

import java.util.List;

/**
 * Created by admin on 22.04.2017.
 */
public interface UsersInterface {

    public void UpdateUserTable();

    void UpdateUserTable(Users userTable);

    public void DeleteUserTable(int id);
    public void InsertUserTable();

    void InsertUserTable(Users userTable);
    public void DeleteAllUserTable();
    public List<Users> SelectUserTable();
}
