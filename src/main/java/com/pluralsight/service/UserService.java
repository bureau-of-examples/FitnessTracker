package com.pluralsight.service;


import com.pluralsight.model.security.User;

public interface UserService {

    User findUser(String username);

    User saveUser(User user);

}
