package com.batm.cvbuilder.service.master;

import org.springframework.stereotype.Service;

import com.batm.cvbuilder.model.master.User;
import com.batm.cvbuilder.service.generic.GenericService;

@Service
public interface UserService<T> extends GenericService<T> {
    public User getUser(String email);
}
