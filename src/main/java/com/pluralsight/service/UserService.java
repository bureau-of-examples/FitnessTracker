package com.pluralsight.service;


import com.pluralsight.model.security.User;

import java.util.List;

public interface UserService {

    User findUser(String username);

    User saveUser(User user);

    List<User> findAllUsers();
}
