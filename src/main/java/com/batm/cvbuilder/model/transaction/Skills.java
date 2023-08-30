package com.batm.cvbuilder.model.transaction;

import com.batm.cvbuilder.model.master.Employee;
import com.batm.cvbuilder.model.master.Skill;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_tr_skills")
public class Skills {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int Id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee Employee;

    @ManyToOne
    @JoinColumn(name = "skill_id")
    private Skill Skill;

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

    public Skill getSkill() {
        return Skill;
    }

    public void setSkill(Skill skill) {
        Skill = skill;
    }

}
