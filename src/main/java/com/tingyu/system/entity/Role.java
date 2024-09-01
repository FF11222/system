package com.tingyu.system.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "role")
@Table
public class Role {
    @Id
    private Integer id;
    @Column
    private String name;
    @ManyToMany(mappedBy = "roles")
    private List<User> users;

    public Integer getId() {
        return id;
    }
}
