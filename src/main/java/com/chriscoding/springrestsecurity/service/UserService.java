package com.chriscoding.springrestsecurity.service;

import com.chriscoding.springrestsecurity.domain.entity.User;
import com.chriscoding.springrestsecurity.domain.response.RoleResponse;
import com.chriscoding.springrestsecurity.domain.response.UserResponse;
import com.chriscoding.springrestsecurity.domain.response.transformers.UserResponseTransformer;
import com.chriscoding.springrestsecurity.exception.RoleNotFoundException;
import com.chriscoding.springrestsecurity.exception.UserNotFoundException;
import com.chriscoding.springrestsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserResponseTransformer userResponseTransformer;

    @Autowired
    private RoleService roleService;

    public List<UserResponse> findAll() {
        return userResponseTransformer.transform(userRepository.findAll());
    }

    public UserResponse getUserById(long id) throws UserNotFoundException {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found!"));
        return userResponseTransformer.transform(user);
    }

    public UserResponse getUserByName(String username) throws UserNotFoundException {
        User user = userRepository.findByName(username).orElseThrow(() -> new UserNotFoundException("User not found!"));
        return userResponseTransformer.transform(user);
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public void addRoleToUser(long userId, long roleId) throws RoleNotFoundException, UserNotFoundException {
        RoleResponse role = roleService.getRoleById(roleId);
        UserResponse user = getUserById(userId);
        user.getRoles().add(role);
    }
}
