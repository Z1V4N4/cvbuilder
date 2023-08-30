package com.batm.cvbuilder.repository.master;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.batm.cvbuilder.model.master.Tool;

@Repository
public interface ToolRepository extends JpaRepository<Tool, Integer> {

}
