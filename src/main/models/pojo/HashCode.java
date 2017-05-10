package main.models.pojo;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created by admin on 07.05.2017.
 */
@Service
public class HashCode {
    public String getHashPassword(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);


        return hashedPassword;
    }

}
