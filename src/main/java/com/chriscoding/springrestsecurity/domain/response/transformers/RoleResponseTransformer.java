package com.chriscoding.springrestsecurity.domain.response.transformers;

import com.chriscoding.springrestsecurity.domain.entity.Role;
import com.chriscoding.springrestsecurity.domain.response.RoleResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleResponseTransformer {

    public RoleResponse transform(Role role) {
        RoleResponse response = new RoleResponse();
        response.setId(role.getId());
        response.setName(role.getName());

        return response;
    }

    public List<RoleResponse> transform (List<Role> roles) {
        List<RoleResponse> responses = new ArrayList<>();
        for (Role role : roles) {
            responses.add(transform(role));
        }
        return responses;
    }
}
