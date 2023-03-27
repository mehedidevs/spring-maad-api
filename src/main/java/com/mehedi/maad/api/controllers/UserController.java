package com.mehedi.maad.api.controllers;

import com.mehedi.maad.api.entities.ResponseUpload;
import com.mehedi.maad.api.entities.User;
import com.mehedi.maad.api.services.UserService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
@RequestMapping("/v1/api")
public class UserController {

    @Autowired
    public UserService userService;

    @Value("${project.image}")
    String path;

    @PostMapping("/user")
    public ResponseEntity<User> createUser(
            @RequestBody User user
    ) {
        User savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<User> deleteUser(
            @PathVariable Integer id
    ) {
        User deleteUser = userService.deleteUser(id);
        return new ResponseEntity<>(deleteUser, HttpStatus.OK);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<User> updateUser(
            @RequestBody User user,
            @PathVariable Integer id
    ) {
        User updateUser = userService.updateUser(user, id);
        return new ResponseEntity<>(updateUser, HttpStatus.OK);
    }


    @GetMapping("/user")
    public ResponseEntity<List<User>> getAllUser() {
        List<User> users = userService.getAllUser();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping("/image")
    public ResponseEntity<ResponseUpload> uploadFile(
            @RequestParam("file") MultipartFile file

    ) {
        ResponseUpload responseUpload = null;
        try {
            responseUpload = userService.UploadFile(path, file);
        } catch (IOException e) {
            new ResponseEntity<>(responseUpload, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(responseUpload, HttpStatus.OK);


    }

    @GetMapping(value = "/image_file/{imgName}",
            produces = MediaType.IMAGE_JPEG_VALUE)
    public void downloadFileLink(
            @PathVariable("imgName") String fileName,
            HttpServletResponse response
    ) throws IOException {
        InputStream inputStream = userService.getLink(path, fileName);
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        StreamUtils.copy(inputStream, response.getOutputStream());
    }


}
