package com.batm.cvbuilder.service.master;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.batm.cvbuilder.model.master.User;
import com.batm.cvbuilder.repository.master.UserRepository;

@Service
public class UserServiceImpl implements UserService<User> {

    @Autowired
    public UserRepository userRepository;

    @Override
    public List<User> Get() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> Get(int id) {
        return userRepository.findById(id);
    }

    @Override
    public Boolean Save(User model) {
        userRepository.save(model);
        return userRepository.findById(model.getId()).isPresent();
    }

    @Override
    public Boolean Delete(int id) {
        userRepository.deleteById(id);
        return !userRepository.findById(id).isPresent();
    }

    @Override
    public User getUser(String email) {
        User user = userRepository.getUserByEmail(email);
        return user;
    }

}
