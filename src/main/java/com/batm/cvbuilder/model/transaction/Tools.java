package com.batm.cvbuilder.model.transaction;

import com.batm.cvbuilder.model.master.Employee;
import com.batm.cvbuilder.model.master.Tool;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_tr_tools")
public class Tools {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int Id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee Employee;

    @ManyToOne
    @JoinColumn(name = "tool_id")
    private Tool Tool;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Employee getEmployee() {
        return Employee;
    }

    public void setEmployee(Employee employee) {
        Employee = employee;
    }

    public Tool getTool() {
        return Tool;
    }

    public void setTool(Tool tool) {
        Tool = tool;
    }

}
