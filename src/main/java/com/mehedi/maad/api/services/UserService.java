package com.mehedi.maad.api.services;

import com.mehedi.maad.api.entities.ResponseUpload;
import com.mehedi.maad.api.entities.User;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public interface UserService {

    User createUser(User user);

    User deleteUser(Integer userId);

    User updateUser(User user, Integer userId);

    List<User> getAllUser();

    ResponseUpload UploadFile(String path, MultipartFile file) throws IOException;
     InputStream getLink(String path, String fileName) throws FileNotFoundException;


}
