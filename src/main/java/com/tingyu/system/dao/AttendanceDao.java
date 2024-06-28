package com.tingyu.system.dao;

import com.tingyu.system.entity.Attendance;
import com.tingyu.system.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface AttendanceDao extends JpaRepository<Attendance, Integer> {
    List<LocalDateTime> findAttendanceByUser(User user);
}
