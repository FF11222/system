package com.tingyu.system.controller;

import com.alibaba.fastjson.JSONObject;
import com.tingyu.system.entity.Department;
import com.tingyu.system.entity.Role;
import com.tingyu.system.entity.User;
import com.tingyu.system.service.DepartmentService;
import com.tingyu.system.service.RoleService;
import com.tingyu.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    DepartmentService departmentService;
    @Autowired
    RoleService roleService;

    Map<String, String> statusMap = new HashMap<String, String>() {{
        put("400", "請求失敗");
        put("201", "請求成功");
    }};

    @PostMapping
    public JSONObject createUser (@RequestBody User user) {
        for (Department dept : user.getDepartments()) {
            if (dept.getId() == null) {
                // 在這裡處理未持久化的 Department 對象
                // 你可以選擇先保存這些對象
                departmentService.save(dept);
            }
        }

        for (Role role : user.getRoles()) {
            if (role.getId() == null) {
                // 在這裡處理未持久化的 Department 對象
                // 你可以選擇先保存這些對象
                roleService.save(role);
            }
        }

        String status = userService.createUser(user);
        String statusCode = status.substring(0, 3);
        String message = status.substring(4);

        JSONObject result = new JSONObject();
        result.put("status", statusMap.get(statusCode));
        if (statusCode.equals("200")) result.put("data", user);
        result.put("message", message);
        return result;
    }
}
