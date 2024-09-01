package com.tingyu.system.service.impl;

import com.tingyu.system.dao.UserDao;
import com.tingyu.system.entity.User;
import com.tingyu.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao dao;

    @Override
    public List<User> getAll() {
        return dao.findAll();
    }

    @Override
    public User getUserByName(String name) {
        if (dao.findByName(name) == null) {
            return null;
        } else {
            return dao.findByName(name);
        }
    }


    @Override
    public String createUser(User user) {
        if (user.getDepartments() == null || user.getRoles() == null || user.getUuid() == null || user.getPassword() == null) {
            return "400 form have something lost";
        } else {
            if (this.getUserByName(user.getName())!=null)
                return "400 Username have been used";
        }
        User newUser = dao.save(user);
        return "201 " + newUser.getId() + " create successfully";
    }
}
