package com.pluralsight.startup;

import com.pluralsight.model.security.User;
import com.pluralsight.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class DataInitializer {

    @Autowired
    private UserService userService;

    @PostConstruct
    public void initUser() {

        Map<String, String> permissions = new HashMap<>();
        permissions.put("com.pluralsight.model.Goal", "create");

        createUser("zhy2001", "$2a$10$GiGaQOyYIi0zJui8L4Ws2.kCTlGUjpnEM6FcHUselrx1txZKxH6.S", null, "ROLE_NONE");
        createUser("zhy2002", "$2a$10$ioQQlFENVvWNjCYRNmm84utquF.oDWTjCuIi8SjnnrEwLNOQ1rQvC", null, "ROLE_USER");
        createUser("zhy2003", "$2a$10$0mze52oN2GymxKYXvtOv.usa3ms8G2iKKsVCd5GSluXiitDWNezBO", null, "ROLE_USER", "ROLE_ADMIN");
        createUser("zhy2004", "$2a$10$w.3X7DDGmnLfyDGCV1hrLekCdQNQZ9xj9fKcjycZoQlZAPAQWfuu2", permissions, "ROLE_USER", "ROLE_ADMIN");

    }

    private void createUser(String username, String password, Map<String, String> permissions, String... roles) {
        User user = userService.findUser(username);
        if (user != null) {
            return;
        }

        user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setPermissions(permissions);
        if (roles != null) {
            for (String role : roles)
                user.addAuthority(role);
        }


        userService.saveUser(user);

    }
}
