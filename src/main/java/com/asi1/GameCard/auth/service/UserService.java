package com.asi1.GameCard.auth.service;

import com.asi1.GameCard.auth.model.User;
import com.asi1.GameCard.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> findUserById(Long userId) {
        return userRepository.findById(userId);
    }

    public void saveUser(User updatedUser) {
        userRepository.save(updatedUser);
    }

    public Optional<User> findUserByLogin(String login) {
        return Optional.ofNullable(userRepository.findByLogin(login));
    }
}
