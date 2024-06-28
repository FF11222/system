package com.tingyu.system;

import com.tingyu.system.dao.AttendanceDao;
import com.tingyu.system.dao.UserDao;
import com.tingyu.system.entity.Attendance;
import com.tingyu.system.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class DaoTest {

    @Autowired
    UserDao userDao;
    @Autowired
    AttendanceDao attendanceDao;
    @Test
    public void testUserSearchAll() {
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user.toString());
        }
    }

    @Test
    public void testAttendanceSearchAll() {
        List<Attendance> attendances = attendanceDao.findAll();
        for (Attendance attendance : attendances) {
            System.out.println(attendance.toString());
        }
    }

    @Test
    public void test() {
        System.out.println("hihi");
    }
}
