package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Member> finder(){
        return userRepository.findAll();
    }
    public void saveMember(String name){
        userRepository.save(name);
    }

}

