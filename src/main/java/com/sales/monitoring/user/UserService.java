package com.sales.monitoring.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Optional<UserModel> createUser(UserModel userModel) {
        Optional<UserModel> existingUser = userRepository.findByUsername(userModel.getUsername());

        if (existingUser.isPresent()) {
            return existingUser;
        } else {
            userModel.setPassword(passwordEncoder.encode(userModel.getPassword()));
            UserModel createdUser = userRepository.save(userModel);

            return Optional.ofNullable(createdUser);
        }
    }

    public Optional<UserModel> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
