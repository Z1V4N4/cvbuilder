package com.batm.cvbuilder.model.master;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_m_user")
public class User {
    @Id
    @Column(name = "id")
    private int Id;
    private String Email;
    private String Password;

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Employee Employee;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role Role;

    public User() {
    }

    public User(int id, String email, String password,
            com.batm.cvbuilder.model.master.Role role) {
        Id = id;
        Email = email;
        Password = password;
        Role = role;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Role getRole() {
        return Role;
    }

    public void setRole(Role role) {
        Role = role;
    }

    public Employee getEmployee() {
        return Employee;
    }

    public void setEmployee(Employee employee) {
        Employee = employee;
    }

}
