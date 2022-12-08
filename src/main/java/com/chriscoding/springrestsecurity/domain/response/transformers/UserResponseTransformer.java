package com.chriscoding.springrestsecurity.domain.response.transformers;

import com.chriscoding.springrestsecurity.domain.entity.User;
import com.chriscoding.springrestsecurity.domain.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserResponseTransformer {

    @Autowired
    RoleResponseTransformer roleResponseTransformer;

    public UserResponse transform(User user) {
        UserResponse response = new UserResponse();

        response.setId(user.getId());
        response.setUserName(user.getUserName());
        response.setEmail(user.getEmail());
        response.setRoles(roleResponseTransformer.transform(user.getRoles()));

        return response;
    }

    public List<UserResponse> transform(List<User> users) {
        List<UserResponse> responses = new ArrayList<>();
        for (User user : users) {
            responses.add(transform(user));
        }
        return responses;
    }
}
