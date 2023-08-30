package com.batm.cvbuilder.service.transaction;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.batm.cvbuilder.model.master.Employee;
import com.batm.cvbuilder.model.master.Skill;
import com.batm.cvbuilder.model.transaction.Skills;
import com.batm.cvbuilder.repository.transaction.SkillsRepository;

@Service
public class SkillsServiceImpl implements SkillsService<Skills> {

    @Autowired
    public SkillsRepository skillsRepository;

    @Override
    public List<Skills> Get() {
        return skillsRepository.findAll();
    }

    @Override
    public Optional<Skills> Get(int id) {
        return skillsRepository.findById(id);
    }

    @Override
    public Boolean Save(Skills model) {
        skillsRepository.save(model);
        return skillsRepository.findById(model.getId()).isPresent();
    }

    @Override
    public Boolean Delete(int id) {
        skillsRepository.deleteById(id);
        return !skillsRepository.findById(id).isPresent();
    }

    @Override
    public List<Skill> getMySkills(int id) {
        Employee employee = new Employee(id);
        return skillsRepository.getMySkills(employee);
    }

}
