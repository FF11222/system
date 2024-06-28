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
}
