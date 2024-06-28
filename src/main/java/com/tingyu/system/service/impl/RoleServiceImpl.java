package com.tingyu.system.service.impl;

import com.tingyu.system.dao.RoleDao;
import com.tingyu.system.entity.Role;
import com.tingyu.system.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleDao dao;

    @Override
    public List<Role> getAll() {
        return dao.findAll();
    }
}
