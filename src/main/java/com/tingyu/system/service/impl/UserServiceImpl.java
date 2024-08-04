package com.tingyu.system.service.impl;

import com.tingyu.system.dao.UserDao;
import com.tingyu.system.entity.User;
import com.tingyu.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
//            throw new UsernameNotFoundException("用戶名不存在"); TODO:
            return null;
        } else {
            return dao.findByName(name);
        }
    }
}
