package com.tingyu.system.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity(name = "user")
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private Integer uuid; // uuid of the ic card
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

    public Integer getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public List<Role> getRoles() {
        return roles;
    }

//    @Override
//    public String toString() {
//        return name;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(id, user.id) && Objects.equals(uuid, user.uuid) && Objects.equals(name, user.name) && Objects.equals(password, user.password) && Objects.equals(departments, user.departments) && Objects.equals(roles, user.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, uuid, name, password, departments, roles);
    }
}
