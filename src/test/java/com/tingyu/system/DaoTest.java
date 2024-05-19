package com.tingyu.system;

import com.tingyu.system.dao.UserDao;
import com.tingyu.system.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class DaoTest {

    @Autowired
    UserDao userDao;
    @Test
    public void testSearchAll() {
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user.toString());
        }
    }

    @Test
    public void test() {
        System.out.println("hihi");
    }
}
