package com.batm.cvbuilder.repository.master;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.batm.cvbuilder.model.master.Skill;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Integer> {

}
