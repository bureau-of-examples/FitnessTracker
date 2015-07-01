package com.pluralsight.init;

import com.pluralsight.model.security.User;
import com.pluralsight.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DataInitializer {

    @Autowired
    private UserService userService;

    @PostConstruct
    public void initUser(){
        createUser("zhy2002","$2a$10$ioQQlFENVvWNjCYRNmm84utquF.oDWTjCuIi8SjnnrEwLNOQ1rQvC", "ROLE_USER");
        createUser("zhy2003","$2a$10$0mze52oN2GymxKYXvtOv.usa3ms8G2iKKsVCd5GSluXiitDWNezBO", "ROLE_USER", "ROLE_ADMIN");
    }

    private void createUser(String username, String password, String... roles) {
        User user = userService.findUser(username);
        if(user != null){
            return;
        }

        user = new User();
        user.setUsername(username);
        user.setPassword(password);
        if(roles != null){
            for (String role : roles)
                user.addAuthority(role);
        }
        userService.saveUser(user);

    }
}
