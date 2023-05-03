package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    private final userRepository userRepository;

    @Autowired
    public UserController(com.example.demo.userRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/user")
    public void find(@RequestBody UserSaveReuqest reuqest) {
        userRepository.save(reuqest.name);
    }

    static class UserSaveReuqest{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;

        }
    }

}

