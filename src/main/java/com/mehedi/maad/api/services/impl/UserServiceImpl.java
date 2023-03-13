package com.mehedi.maad.api.services.impl;

import com.mehedi.maad.api.entities.User;
import com.mehedi.maad.api.repositories.UserRepository;
import com.mehedi.maad.api.services.UserService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;


    @Override
    public User createUser(User user) {

        User savedUser = userRepository.save(user);

        return savedUser;
    }

    @Override
    public User deleteUser(Integer userId) {

        User user = userRepository.findById(userId).orElseThrow(
                () -> new RuntimeException("User Not Found")
        );
        userRepository.delete(user);

        return user;
    }

    @Override
    public User updateUser(User user, Integer userId) {

        User existingUserduser = userRepository.findById(userId).orElseThrow(
                () -> new RuntimeException("User Not Found")
        );
        existingUserduser.setId(userId);
        existingUserduser.setName(user.getName());
        existingUserduser.setEmail(user.getEmail());

        userRepository.save(existingUserduser);

        return existingUserduser;


    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }
}
