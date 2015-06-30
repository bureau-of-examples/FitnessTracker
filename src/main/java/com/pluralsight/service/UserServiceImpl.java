package com.pluralsight.service;

import com.pluralsight.model.security.User;
import com.pluralsight.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    @Override
    public User findUser(String username) {
        return userRepository.findOne(username);
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
