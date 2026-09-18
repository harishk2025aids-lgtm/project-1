package com.harish.project176.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/")
public class HomeController {

@GetMapping
public String home() {
    return "Application is running. Try /hello or /api/user";
}

@GetMapping("hello")
public String get() {
    return "Hello world";
}
@PostMapping("create")
public String create(@RequestBody String payload) {
    return payload +" Successfully created";

}
@PutMapping("update")
public String update(@RequestBody String payload) {
    return payload +" Successfully updated";
}

@DeleteMapping("delete/{id}")
public String delete(@PathVariable String id) {
    return "Deleted"+" "+ id;
}


@GetMapping("get/{id}")
public String getById(@PathVariable String id) {
    return "Fetched"+" "+ id;
} 
}