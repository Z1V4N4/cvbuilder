package com.batm.cvbuilder.repository.transaction;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.batm.cvbuilder.model.master.Employee;
import com.batm.cvbuilder.model.master.Tool;
import com.batm.cvbuilder.model.transaction.Tools;

@Repository
public interface ToolsRepository extends JpaRepository<Tools, Integer> {
    @Query("""
            SELECT  t.Tool FROM Tools t
            WHERE t.Employee = ?1
                """)
    List<Tool> getMyTools(Employee id);
}
