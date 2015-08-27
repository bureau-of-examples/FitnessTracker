package com.pluralsight.service;

import com.pluralsight.model.security.User;
import com.pluralsight.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    @Override
    public User findUser(String username) {
        User user = userRepository.findOne(username);
        if(user != null){ //load collections
            user.getAuthorities().iterator().hasNext();
            user.getPermissions().entrySet().iterator().hasNext();
        }
        return user;
    }

    @Transactional
    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
}
