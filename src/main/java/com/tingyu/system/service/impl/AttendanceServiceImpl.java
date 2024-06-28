package com.tingyu.system.service.impl;

import com.tingyu.system.dao.AttendanceDao;
import com.tingyu.system.entity.Attendance;
import com.tingyu.system.entity.User;
import com.tingyu.system.service.AttendanceService;
import org.hibernate.internal.util.collections.CollectionHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AttendanceServiceImpl implements AttendanceService {
    @Autowired
    AttendanceDao dao;

    @Override
    public List<Attendance> getAll() {
        return dao.findAll();
    }

    @Override
    public List<LocalDateTime> searchAttendanceByUser(User user) {
        return dao.findAttendanceByUser(user);
    }

    @Override
    public Map<User, List<String>> getAttendanceSummary() {
        List<Attendance> attendances = this.getAll();

        return attendances.stream().collect(Collectors.groupingBy(
                Attendance::getUser, Collectors.flatMapping(
                        attendance -> attendance.getAttendDuration().stream(), Collectors.toList())));
    }
}
