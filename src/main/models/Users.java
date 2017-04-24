package main.models;

/**
 * Created by admin on 22.04.2017.
 */
public class Users {
    private int id;
    private String userName;
    private String passName;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassName() {
        return passName;
    }

    public void setPassName(String passName) {
        this.passName = passName;
    }


    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", name='" + userName + '\'' +
                ", pass=" + passName +

                '}';
    }
}
