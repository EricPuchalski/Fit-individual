package ar.gym.gym.security.controller;


import ar.gym.gym.security.model.User;
import ar.gym.gym.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping
public class TestController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/test/all")
    public String allAccess() {
        return "Public Content.";
    }

    @GetMapping("/test/user")
    @PreAuthorize("hasRole('ROLE_TRAINER') or hasRole('ROLE_CLIENT') or hasRole('ROLE_NUTRITIONIST') or hasRole('ROLE_ADMIN') ")
    public String userAccess() {
        return "User Content.";
    }

    @GetMapping("/test/trainer")
    @PreAuthorize("hasRole('ROLE_TRAINER')")
    public String trainerAccess() {
        return "Trainer Board.";
    }

    @GetMapping("/test/admin")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String adminAccess() {
        return "Admin Board.";
    }

    @GetMapping("/test/nutritionist")
    @PreAuthorize("hasRole('ROLE_NUTRITIONIST')")
    public String nutritionistAccess() {
        return "Admin Board.";
    }

    @GetMapping("/test/client")
    @PreAuthorize("hasRole('ROLE_CLIENT')")
    public String clientAccesss() {
        return "Client Board.";
    }
}
