package com.tingyu.system;

import com.tingyu.system.entity.User;
import com.tingyu.system.service.impl.AttendanceServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
public class AttendanceServiceTest {
    @Autowired
    AttendanceServiceImpl attendanceService;

    @Test
    public void testGetAttendanceSummary() {
        Map<User, List<String>> result = attendanceService.getAttendanceSummary();
        for (Map.Entry<User, List<String>> i : result.entrySet()) {
            System.out.println(i);
        }
    }
}
