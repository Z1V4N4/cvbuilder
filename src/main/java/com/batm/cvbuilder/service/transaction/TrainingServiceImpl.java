package com.batm.cvbuilder.service.transaction;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.batm.cvbuilder.model.master.Employee;
import com.batm.cvbuilder.model.transaction.Training;
import com.batm.cvbuilder.repository.transaction.TrainingRepository;

@Service
public class TrainingServiceImpl implements TrainingService<Training> {

    @Autowired
    public TrainingRepository trainingRepository;

    @Override
    public List<Training> Get() {
        return trainingRepository.findAll();
    }

    @Override
    public Optional<Training> Get(int id) {
        return trainingRepository.findById(id);
    }

    @Override
    public Boolean Save(Training model) {
        trainingRepository.save(model);
        return trainingRepository.findById(model.getId()).isPresent();
    }

    @Override
    public Boolean Delete(int id) {
        trainingRepository.deleteById(id);
        return !trainingRepository.findById(id).isPresent();
    }

    @Override
    public List<Training> getMyTrainings(int id) {
        Employee employee = new Employee(id);
        return trainingRepository.getMyTrainings(employee);
    }
}
