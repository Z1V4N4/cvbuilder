package com.batm.cvbuilder.service.transaction;

import java.util.List;

import org.springframework.stereotype.Service;

import com.batm.cvbuilder.model.master.Skill;
import com.batm.cvbuilder.service.generic.GenericService;

@Service
public interface SkillsService<T> extends GenericService<T> {
    public List<Skill> getMySkills(int id);
}
