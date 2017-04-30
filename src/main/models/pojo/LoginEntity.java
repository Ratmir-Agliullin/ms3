package main.models.pojo;

import org.springframework.stereotype.Component;

/**
 * Created by admin on 29.04.2017.
 */
@Component
public class LoginEntity {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
