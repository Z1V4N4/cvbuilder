package com.batm.cvbuilder.repository.transaction;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.batm.cvbuilder.model.master.Employee;
import com.batm.cvbuilder.model.master.Skill;
import com.batm.cvbuilder.model.transaction.Skills;

@Repository
public interface SkillsRepository extends JpaRepository<Skills, Integer> {
    @Query("""
            SELECT  s.Skill FROM Skills s
            WHERE s.Employee = ?1
                """)
    List<Skill> getMySkills(Employee id);
}
