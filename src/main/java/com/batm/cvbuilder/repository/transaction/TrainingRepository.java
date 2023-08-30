package com.batm.cvbuilder.repository.transaction;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.batm.cvbuilder.model.master.Employee;
import com.batm.cvbuilder.model.transaction.Training;

@Repository
public interface TrainingRepository extends JpaRepository<Training, Integer> {
    @Query("""
            SELECT  t FROM Training t
            WHERE t.Employee = ?1
                """)
    List<Training> getMyTrainings(Employee id);
}
