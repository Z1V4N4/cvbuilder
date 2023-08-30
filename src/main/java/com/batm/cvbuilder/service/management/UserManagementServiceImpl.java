package com.batm.cvbuilder.service.management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.batm.cvbuilder.model.master.User;
import com.batm.cvbuilder.repository.management.UserManagementRepository;

@Service
public class UserManagementServiceImpl implements UserManagementService {

    @Autowired
    public UserManagementRepository userManagementRepository;

    @Override
    public User login(String email, String password) {
        User user = userManagementRepository.getLogin(email, password);
        return user;
    }
}
