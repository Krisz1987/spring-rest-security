package com.chriscoding.springrestsecurity.domain.response;

import lombok.Data;

import java.util.List;

@Data
public class UserResponse {

    private long id;
    private String userName;
    private String email;
    private List<RoleResponse> roles;
}
