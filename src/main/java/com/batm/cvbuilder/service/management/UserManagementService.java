package com.batm.cvbuilder.service.management;

import org.springframework.stereotype.Service;

import com.batm.cvbuilder.model.master.User;

@Service
public interface UserManagementService {
    public User login(String email, String password);
}
