package com.tingyu.system.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "department")
@Table
public class Department {
    @Id
    private Integer id;
    @Column
    private String name;
    @ManyToMany(mappedBy = "departments")
    private List<User> users;
}
