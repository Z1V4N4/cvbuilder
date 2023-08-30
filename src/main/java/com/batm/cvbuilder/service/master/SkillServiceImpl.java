package com.batm.cvbuilder.service.master;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.batm.cvbuilder.model.master.Skill;
import com.batm.cvbuilder.repository.master.SkillRepository;

@Service
public class SkillServiceImpl implements SkillService<Skill> {

    @Autowired
    public SkillRepository skillRepository;

    @Override
    public List<Skill> Get() {
        return skillRepository.findAll();
    }

    @Override
    public Optional<Skill> Get(int id) {
        return skillRepository.findById(id);
    }

    @Override
    public Boolean Save(Skill model) {
        skillRepository.save(model);
        return skillRepository.findById(model.getId()).isPresent();
    }

    @Override
    public Boolean Delete(int id) {
        skillRepository.deleteById(id);
        return !skillRepository.findById(id).isPresent();
    }

}
