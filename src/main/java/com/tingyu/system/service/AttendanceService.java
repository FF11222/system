package com.tingyu.system.service;

import com.tingyu.system.entity.Attendance;
import com.tingyu.system.entity.User;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface AttendanceService {
    public List<Attendance> getAll();
    public List<LocalDateTime> searchAttendanceByUser(User user);
    public Map<User, List<String>> getAttendanceSummary();
}
