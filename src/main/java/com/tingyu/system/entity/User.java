package com.tingyu.system.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "user")
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private Integer uuid;
    @Column
    private String name;
    @Column
    private String password;
    @ManyToMany
    @JoinTable(name = "User_Department",
    joinColumns = @JoinColumn(name = "User_Id"),
    inverseJoinColumns = @JoinColumn(name = "Department_Id"))
    private List<Department> departments;
    @ManyToMany
    @JoinTable(name = "User_Role",
    joinColumns = @JoinColumn(name = "User_Id"),
    inverseJoinColumns = @JoinColumn(name = "Role_Id"))
    private List<Role> roles;

    @Override
    public String toString() {
        return id.toString() + " " + uuid.toString() + " " + name;
    }
}
