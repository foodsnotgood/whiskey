package be.johannes.whiskey.service;

import be.johannes.whiskey.model.User;
import be.johannes.whiskey.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User getUser(Authentication authentication) {
        return userRepository.findByEmail(authentication.getName());
    }
}
