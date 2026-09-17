package com.harish.project176.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
@RestController 
@RequestMapping("/api/user")
public class usercontroller {

    private record user(String id, String firstName, String lastName, String email) {
    }

    @GetMapping("")
    public List<user> getAll() {
        List<user> users = List.of(
                new user("123", "Krish", "Karthik", "krish@gmail.com"),
                new user("123", "Krish", "Karthik", "krish@gmail.com")
        );

        return users;
    }
}
    