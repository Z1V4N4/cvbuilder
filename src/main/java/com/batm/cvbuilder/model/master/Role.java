package com.batm.cvbuilder.model.master;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_m_role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int Id;
    private String Name;
    private int Level;

    public Role() {

    }

    public Role(int id, String name, int level) {
        this.Id = id;
        this.Name = name;
        this.Level = level;
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

    public int getLevel() {
        return Level;
    }

    public void setLevel(int level) {
        Level = level;
    }
}
