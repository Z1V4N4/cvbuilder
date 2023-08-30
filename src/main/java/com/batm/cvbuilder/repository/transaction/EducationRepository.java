package com.batm.cvbuilder.repository.transaction;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.batm.cvbuilder.model.master.Employee;
import com.batm.cvbuilder.model.transaction.Education;

@Repository
public interface EducationRepository extends JpaRepository<Education, Integer> {
    @Query("""
            SELECT  e FROM Education e
            WHERE e.Employee = ?1
                """)
    List<Education> getMyEducations(Employee id);
}
