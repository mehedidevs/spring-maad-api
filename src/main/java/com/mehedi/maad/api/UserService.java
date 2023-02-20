package com.mehedi.maad.api;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private List<User> userList;

    public UserService() {
        userList = new ArrayList<>();

        userList.add(new User(1, "mehedi", "mehedi@gmail.com"));
        userList.add(new User(2, "mehedi", "mehedi@gmail.com"));
        userList.add(new User(3, "mehedi", "mehedi@gmail.com"));
        userList.add(new User(4, "mehedi", "mehedi@gmail.com"));
        userList.add(new User(5, "mehedi", "mehedi@gmail.com"));
        userList.add(new User(6, "mehedi", "mehedi@gmail.com"));
        userList.add(new User(7, "mehedi", "mehedi@gmail.com"));
        userList.add(new User(8, "mehedi", "mehedi@gmail.com"));
        userList.add(new User(9, "mehedi", "mehedi@gmail.com"));
        userList.add(new User(9, "mehedi", "mehedi@gmail.com"));
        userList.add(new User(9, "mehedi", "mehedi@gmail.com"));
        userList.add(new User(9, "mehedi", "mehedi@gmail.com"));
        userList.add(new User(9, "mehedi", "mehedi@gmail.com"));
        userList.add(new User(9, "mehedi", "mehedi@gmail.com"));
        userList.add(new User(9, "mehedi", "mehedi@gmail.com"));
        userList.add(new User(9, "mehedi", "mehedi@gmail.com"));
        userList.add(new User(9, "mehedi", "mehedi@gmail.com"));
        userList.add(new User(9, "mehedi", "mehedi@gmail.com"));
        userList.add(new User(9, "mehedi", "mehedi@gmail.com"));


    }


    public List<User> getUserList() {

        return userList;
    }


}
