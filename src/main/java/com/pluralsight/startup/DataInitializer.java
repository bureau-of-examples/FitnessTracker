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
        User zhy2002 = userService.findUser("zhy2002");
        if(zhy2002 == null){
            zhy2002 = new User();
            zhy2002.setUsername("zhy2002");
            zhy2002.setPassword("zhy2002");
            zhy2002.addAuthority("ROLE_USER");
            userService.saveUser(zhy2002);
        }
    }
}
