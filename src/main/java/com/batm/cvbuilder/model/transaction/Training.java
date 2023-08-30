package com.batm.cvbuilder.model.transaction;

import com.batm.cvbuilder.model.master.Employee;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_tr_training")
public class Training {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int Id;
    private String Name;
    private String Place;
    private String Description;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee Employee;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPlace() {
        return Place;
    }

    public void setPlace(String place) {
        Place = place;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Employee getEmployee() {
        return Employee;
    }

    public void setEmployee(Employee employee) {
        Employee = employee;
    }

}
