package com.batm.cvbuilder.model.master;

import java.sql.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_m_employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int Id;
    private String Name;
    private String Phonenumber;
    private Date Birthdate;
    private String Summary;

    @ManyToOne
    @JoinColumn(name = "gender_id")
    private Gender Gender;

    public Employee() {
    }

    public Employee(int id) {
        Id = id;
    }

    public Employee(int id, String name, String phonenumber, Date birthdate, String summary, Gender gender) {
        Id = id;
        Name = name;
        Phonenumber = phonenumber;
        Birthdate = birthdate;
        Summary = summary;
        Gender = gender;
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

    public String getPhonenumber() {
        return Phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        Phonenumber = phonenumber;
    }

    public Date getBirthdate() {
        return Birthdate;
    }

    public void setBirthdate(Date birthdate) {
        Birthdate = birthdate;
    }

    public String getSummary() {
        return Summary;
    }

    public void setSummary(String summary) {
        Summary = summary;
    }

    public Gender getGender() {
        return Gender;
    }

    public void setGender(Gender gender) {
        Gender = gender;
    }

}
