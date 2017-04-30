package main.models.pojo;

/**
 * Created by admin on 22.04.2017.
 */
public class Admin {
    private int id;
    private String adminName;
    private String adminPass;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPass() {
        return adminPass;
    }

    public void setAdminPass(String adminPass) {
        this.adminPass = adminPass;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", name='" + adminName + '\'' +
                ", pass=" + adminPass +

                '}';
    }
}
