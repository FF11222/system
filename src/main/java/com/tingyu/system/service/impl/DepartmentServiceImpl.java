package com.tingyu.system.service.impl;

import com.tingyu.system.dao.DepartmentDao;
import com.tingyu.system.entity.Department;
import com.tingyu.system.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    @Autowired
    DepartmentDao dao;
    @Override
    public List<Department> getAll() {
        return dao.findAll();
    }
}
