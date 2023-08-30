package com.batm.cvbuilder.repository.transaction;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.batm.cvbuilder.model.master.Employee;
import com.batm.cvbuilder.model.transaction.Certification;

@Repository
public interface CertificationRepository extends JpaRepository<Certification, Integer> {
    @Query("""
            SELECT  c FROM Certification c
            WHERE c.Employee = ?1
                """)
    List<Certification> getMyCertifications(Employee id);
}
