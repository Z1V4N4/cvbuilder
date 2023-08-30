package com.batm.cvbuilder.service.master;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.batm.cvbuilder.model.master.Gender;
import com.batm.cvbuilder.repository.master.GenderRepository;

@Service
public class GenderServiceImpl implements GenderService<Gender> {

    @Autowired
    public GenderRepository genderRepository;

    @Override
    public List<Gender> Get() {
        return genderRepository.findAll();
    }

    @Override
    public Optional<Gender> Get(int id) {
        return genderRepository.findById(id);
    }

    @Override
    public Boolean Save(Gender model) {
        genderRepository.save(model);
        return genderRepository.findById(model.getId()).isPresent();
    }

    @Override
    public Boolean Delete(int id) {
        genderRepository.deleteById(id);
        return !genderRepository.findById(id).isPresent();
    }

}
