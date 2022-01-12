package be.johannes.whiskey.service;

import be.johannes.whiskey.dto.UserDto;
import be.johannes.whiskey.model.User;
import be.johannes.whiskey.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Component
@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerNewUserAccount(UserDto userDto) throws Exception {
        if (emailExists(userDto.getEmail())) {
            throw new Exception("This email address is already in use: " + userDto.getEmail());
        }

        User user = new User();

        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));

        return userRepository.save(user);
    }

    private boolean emailExists(String email) {
        return userRepository.findByEmail(email) != null;
    }

    public User getUser(Authentication authentication) {
        return userRepository.findByEmail(authentication.getName());
    }
}
