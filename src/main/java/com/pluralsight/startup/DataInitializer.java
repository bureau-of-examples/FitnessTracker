package com.pluralsight.startup;

import com.pluralsight.model.security.User;
import com.pluralsight.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Component
public class DataInitializer {

    @Autowired
    private UserService userService;


    @Resource(name = "passwordEncoder")
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void initUser() {

        Map<String, String> permissions = new HashMap<>();
        permissions.put("com.pluralsight.model.Goal", "create");

        createUser("zhy2001", "zhy2001", null, "ROLE_NONE");
        createUser("zhy2002", "zhy2002", null, "ROLE_USER");
        createUser("zhy2003", "zhy2003", null, "ROLE_USER", "ROLE_ADMIN");
        createUser("zhy2004", "zhy2004", permissions, "ROLE_USER", "ROLE_ADMIN");
    }

    private void createUser(String username, String password, Map<String, String> permissions, String... roles) {
        User user = userService.findUser(username);
        if (user != null) {
            return;
        }

        String pwdHash = passwordEncoder.encode(password);
        user = new User();
        user.setUsername(username);
        user.setPassword(pwdHash);
        user.setPermissions(permissions);
        if (roles != null) {
            for (String role : roles)
                user.addAuthority(role);
        }

        userService.saveUser(user);
    }
}
