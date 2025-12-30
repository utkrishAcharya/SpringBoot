package myApplication.service;

import myApplication.model.User;
import myApplication.pojo.LoginRequest;
import myApplication.pojo.SignupRequest;
import myApplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    public User signup(SignupRequest request) {
        User user = new User(request.getUsername(), request.getEmail(), request.getPassword());
        return userRepository.save(user);
    }

    public User login(LoginRequest request) {
        return userRepository.findByUsernameAndPassword(request.getUsername(), request.getPassword());
    }
}

