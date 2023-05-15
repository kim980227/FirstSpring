package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public void find(@RequestBody UserSaveReuqest reuqest) {
        userService.saveMember(reuqest.name);
    }

    @GetMapping("")
    public List<Member> find(Member member){
        return userService.finder();
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

