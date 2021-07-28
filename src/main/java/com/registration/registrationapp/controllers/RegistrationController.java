package com.registration.registrationapp.controllers;

import com.registration.registrationapp.model.User;
import com.registration.registrationapp.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
public class RegistrationController {

    @Autowired
    private RegistrationService service;


    @PostMapping("/registeruser")
    @CrossOrigin(origins = "http://localhost:4200")
    public User registerUser(@RequestBody User user) throws Exception {
        String tempEmailId = user.getEmail();

        if(tempEmailId != null && !"".equals(tempEmailId)){
            User userObject = service.fetchUserByEmailId(tempEmailId);
            if(userObject != null){
                throw new Exception("user with" + tempEmailId + " already exist");
            }
        }

        User userObj = null;
        userObj = service.saveUser(user);
        return userObj;
    }

    @PostMapping("/login")
    @CrossOrigin(origins = "http://localhost:4200")
    public User loginUser(@RequestBody User user) throws Exception {
        String tempEmail = user.getEmail();
        String tempPassword = user.getPassword();
        User userObject = null;
        if(tempEmail != null && tempPassword != null){
            userObject = service.fetchUserByEmailAndPassword(tempEmail,tempPassword);
        }

        if (userObject == null) {
            throw new Exception("User does not exist.");

        }

        return userObject;
    }

}
