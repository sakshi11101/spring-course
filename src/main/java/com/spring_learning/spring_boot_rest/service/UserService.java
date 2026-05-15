package com.spring_learning.spring_boot_rest.service;

import com.spring_learning.spring_boot_rest.model.User;
import com.spring_learning.spring_boot_rest.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;
    private PasswordEncoder encoder;

    public User saveUser(User user) {
        final String bcryptPassword = encoder.encode(user.getPassword());
        user.setPassword(bcryptPassword);
        return userRepo.save(user);
    }
}
