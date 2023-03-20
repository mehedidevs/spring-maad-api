package com.mehedi.maad.api.services.impl;

import com.mehedi.maad.api.entities.ResponseUpload;
import com.mehedi.maad.api.entities.User;
import com.mehedi.maad.api.repositories.UserRepository;
import com.mehedi.maad.api.services.UserService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

    @Override
    public ResponseUpload UploadFile(String path, MultipartFile file) {

        String name = file.getOriginalFilename();
        String filePath = path + File.separator + name;
        File mFile = new File(path);

        Path dir = Paths.get(filePath);

        if (!mFile.exists()) {
            try {
                Files.createDirectories(dir);
                Files.copy(file.getInputStream(), dir);
            } catch (IOException e) {
                return new ResponseUpload(e.getLocalizedMessage(), false);

            }

        }


        return new ResponseUpload("File Uploaded !", true);
    }
}
