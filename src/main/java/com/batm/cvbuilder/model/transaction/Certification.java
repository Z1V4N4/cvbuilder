package com.batm.cvbuilder.model.transaction;

import com.batm.cvbuilder.model.master.Employee;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_tr_certification")
public class Certification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int Id;
    private String Name;
    private String Publisher;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee Employee;

    public Certification() {
    }

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

    public String getPublisher() {
        return Publisher;
    }

    public void setPublisher(String publisher) {
        Publisher = publisher;
    }

    public Employee getEmployee() {
        return Employee;
    }

    public void setEmployee(Employee employee) {
        this.Employee = employee;
    }

}
