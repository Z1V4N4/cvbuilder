package com.batm.cvbuilder.model.master;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_m_tool")
public class Tool {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int Id;
    private String Name;

    public Tool() {
    }

    public Tool(int id, String name) {
        Id = id;
        Name = name;
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

}
