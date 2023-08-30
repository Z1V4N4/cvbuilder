package com.batm.cvbuilder.service.transaction;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.batm.cvbuilder.model.master.Employee;
import com.batm.cvbuilder.model.transaction.Experience;
import com.batm.cvbuilder.repository.transaction.ExperienceRepository;

@Service
public class ExperienceServiceImpl implements ExperienceService<Experience> {

    @Autowired
    public ExperienceRepository experienceRepository;

    @Override
    public List<Experience> Get() {
        return experienceRepository.findAll();
    }

    @Override
    public Optional<Experience> Get(int id) {
        return experienceRepository.findById(id);
    }

    @Override
    public Boolean Save(Experience model) {
        experienceRepository.save(model);
        return experienceRepository.findById(model.getId()).isPresent();
    }

    @Override
    public Boolean Delete(int id) {
        experienceRepository.deleteById(id);
        return !experienceRepository.findById(id).isPresent();
    }

    @Override
    public List<Experience> getMyExperiences(int id) {
        Employee employee = new Employee(id);
        return experienceRepository.getMyExperiences(employee);
    }

}
