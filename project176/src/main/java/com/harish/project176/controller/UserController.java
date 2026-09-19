package com.harish.project176.controller;


import java.util.List;

import com.harish.project176.model.User;
import com.harish.project176.model.UserRepository;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("{userId}")
    public User getById(@PathVariable String userId){
return this.userRepository.findById(userId).orElseThrow();}

    @GetMapping("")
    public List<User> getAll() {
        return this.userRepository.findAll();
    }
    
    @PostMapping("")
    public User createUser(@RequestBody User user) {
        return this.userRepository.save(user);
    }
    @PutMapping("{userId}")
    public User putMethodName(@PathVariable String userId, @RequestBody User entity){
        if(entity.getId() == null){
            entity.setId(userId);
        }
        User savedUser = this.userRepository.save(entity);
        return savedUser;
    }
    @DeleteMapping("{userId}")
    public void deleteUser(@PathVariable String userId) {
        this.userRepository.deleteById(userId);
    }

}