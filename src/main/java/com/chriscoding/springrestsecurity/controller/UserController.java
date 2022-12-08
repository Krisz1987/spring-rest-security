package com.chriscoding.springrestsecurity.controller;

import com.chriscoding.springrestsecurity.domain.entity.User;
import com.chriscoding.springrestsecurity.domain.response.UserResponse;
import com.chriscoding.springrestsecurity.exception.RoleNotFoundException;
import com.chriscoding.springrestsecurity.exception.UserNotFoundException;
import com.chriscoding.springrestsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/get-all-users")
    public List<UserResponse> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/get-user-by-id/{id}")
    public UserResponse getUserById(@PathVariable long id) throws UserNotFoundException {
        return userService.getUserById(id);
    }

    @GetMapping("/get-user-by-name/{username}")
    public UserResponse getUserByName(@PathVariable String username) throws UserNotFoundException {
        return userService.getUserByName(username);
    }

    @PostMapping("/save-user")
    public void saveUser(@RequestBody User user){
        userService.saveUser(user);
    }

    @PostMapping("/addRoleToUser")
    public void addRoleToUser(@RequestParam(required = true) int userId, @RequestParam(required = true) int roleId) throws UserNotFoundException, RoleNotFoundException {
        userService.addRoleToUser(userId, roleId);
    }


}
