package com.batm.cvbuilder.service.master;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.batm.cvbuilder.model.master.Role;
import com.batm.cvbuilder.repository.master.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService<Role> {

    @Autowired
    public RoleRepository roleRepository;

    @Override
    public List<Role> Get() {
        return roleRepository.findAll();
    }

    @Override
    public Optional<Role> Get(int id) {
        return roleRepository.findById(id);
    }

    @Override
    public Boolean Save(Role model) {
        roleRepository.save(model);
        return roleRepository.findById(model.getId()).isPresent();
    }

    @Override
    public Boolean Delete(int id) {
        roleRepository.deleteById(id);
        return !roleRepository.findById(id).isPresent();
    }
}
