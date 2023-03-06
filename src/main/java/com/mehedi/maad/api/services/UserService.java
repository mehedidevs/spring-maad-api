package com.mehedi.maad.api.services;

import com.mehedi.maad.api.entities.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


public interface UserService {

    User createUser(User user);

    User deleteUser(Integer userId);

    User updateUser(User user, Integer userId);

    List<User> getAllUser();


}
