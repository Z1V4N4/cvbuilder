package com.batm.cvbuilder.repository.transaction;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.batm.cvbuilder.model.master.Employee;
import com.batm.cvbuilder.model.transaction.Experience;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Integer> {
    @Query("""
            SELECT  e FROM Experience e
            WHERE e.Employee = ?1
                """)
    List<Experience> getMyExperiences(Employee id);
}
