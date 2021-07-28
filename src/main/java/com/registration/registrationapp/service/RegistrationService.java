package com.registration.registrationapp.service;

import com.registration.registrationapp.model.User;
import com.registration.registrationapp.repository.RegistrationRepository;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    private final RegistrationRepository repository;

    public RegistrationService(RegistrationRepository repository) {
        this.repository = repository;
    }

    public User saveUser (User user) {
        return repository.save(user);
    }

    public User fetchUserByEmailId (String email) {
        User user = repository.findUserByEmail(email);
        return user;
    }

    public User fetchUserByEmailAndPassword (String email, String password) {
        return repository.findUserByEmailAndPassword(email, password);
    }
}
