package com.batm.cvbuilder.service.transaction;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.batm.cvbuilder.model.master.Employee;
import com.batm.cvbuilder.model.transaction.Education;
import com.batm.cvbuilder.repository.transaction.EducationRepository;

@Service
public class EducationServiceImpl implements EducationService<Education> {

    @Autowired
    public EducationRepository educationRepository;

    @Override
    public List<Education> Get() {
        return educationRepository.findAll();
    }

    @Override
    public Optional<Education> Get(int id) {
        return educationRepository.findById(id);
    }

    @Override
    public Boolean Save(Education model) {
        educationRepository.save(model);
        return educationRepository.findById(model.getId()).isPresent();
    }

    @Override
    public Boolean Delete(int id) {
        educationRepository.deleteById(id);
        return !educationRepository.findById(id).isPresent();
    }

    @Override
    public List<Education> getMyEducations(int id) {
        Employee employee = new Employee(id);
        return educationRepository.getMyEducations(employee);
    }

}
