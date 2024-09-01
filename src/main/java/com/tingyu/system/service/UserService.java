package com.tingyu.system.service;

import com.tingyu.system.entity.User;

import java.util.List;

public interface UserService {
    public List<User> getAll();
    public User getUserByName(String name);
    public String createUser(User user);
}
