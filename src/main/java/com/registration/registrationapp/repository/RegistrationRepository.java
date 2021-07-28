package com.registration.registrationapp.repository;

import com.registration.registrationapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository extends JpaRepository<User,Integer> {
    User findUserByEmail(String email);
    User findUserByEmailAndPassword(String email, String password);
}
