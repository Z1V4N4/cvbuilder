package com.batm.cvbuilder.model.transaction;

import java.sql.Date;

import com.batm.cvbuilder.model.master.Employee;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_tr_education")
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int Id;
    private String School;
    private String Description;
    private Date Startdate;
    private Date Enddate;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee Employee;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getSchool() {
        return School;
    }

    public void setSchool(String school) {
        School = school;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Date getStartdate() {
        return Startdate;
    }

    public void setStartdate(Date startdate) {
        Startdate = startdate;
    }

    public Date getEnddate() {
        return Enddate;
    }

    public void setEnddate(Date enddate) {
        Enddate = enddate;
    }

    public Employee getEmployee() {
        return Employee;
    }

    public void setEmployee(Employee employee) {
        this.Employee = employee;
    }

}
