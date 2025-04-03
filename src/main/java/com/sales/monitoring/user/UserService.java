package com.sales.monitoring.user;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserModel createUser(UserModel userModel) {
        UserModel existingUser = userRepository.findByUsername(userModel.getUsername());

        if (existingUser != null) {
            // Lançar um erro
            return existingUser;
        } else {
            return userRepository.save(userModel);
        }

    }

    public UserModel getByUsername(String username) {
        UserModel user = userRepository.findByUsername(username);

        return user;
    }
}
