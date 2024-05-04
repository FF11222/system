package com.tingyu.system.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Role {
    @Id
    private Integer id;
    @Column
    private String name;
    @ManyToMany(mappedBy = "roles")
    private List<User> users;
}
