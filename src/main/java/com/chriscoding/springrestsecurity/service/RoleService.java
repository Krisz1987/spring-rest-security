package com.chriscoding.springrestsecurity.service;

import com.chriscoding.springrestsecurity.domain.entity.Role;
import com.chriscoding.springrestsecurity.domain.response.RoleResponse;
import com.chriscoding.springrestsecurity.domain.response.transformers.RoleResponseTransformer;
import com.chriscoding.springrestsecurity.exception.RoleNotFoundException;
import com.chriscoding.springrestsecurity.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    RoleResponseTransformer roleResponseTransformer;

    public RoleResponse getRoleById(long roleId) throws RoleNotFoundException {
        Role role = roleRepository.findById(roleId).orElseThrow(() -> new RoleNotFoundException("Role not found!"));
        return roleResponseTransformer.transform(role);
    }
}
