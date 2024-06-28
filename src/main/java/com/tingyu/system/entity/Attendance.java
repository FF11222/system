package com.tingyu.system.entity;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.Pair;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne
    private User user;
    @ElementCollection
    @CollectionTable(name = "attend_time", joinColumns = @JoinColumn(name = "attend_id"))
    private List<AttendPeriod> attend = new ArrayList<>();

    @Override
    public String toString() {
        String result = "";
        for (AttendPeriod date : attend) {
            result += date.getStartDate().toString() + date.getEndDate().toString();
        }
        return attend + result;
    }

    public User getUser() {
        return user;
    }

    public List<AttendPeriod> getAttend() {
        return this.attend;
    }

    public List<String> getAttendDuration() {
        List<String> result = new ArrayList<>();

        for (AttendPeriod i : this.attend) {
//            result.add(dateSubtract(i.getStartDate(), i.getEndDate()));   because test data didn't hava start_date and end_date in the same day
            if (i.getStartDate().getDayOfMonth() == i.getEndDate().getDayOfMonth()) {
                result.add(dateSubtract(i.getStartDate(), i.getEndDate()));
            } else {
                continue;
                // todo: add exception
            }
        }

        return result;
    }

    /**
     *  Description: This is a method that subtract two LocalDateTime(b-a)
     *  Return: b-a in a format of HH-MM-SS
     */
    private String dateSubtract(LocalDateTime a, LocalDateTime b) {
        String result = "";

        result += Integer.toString(b.getHour() - a.getHour()) + "-";
        result += Integer.toString(b.getMinute() - a.getMinute()) + "-";
        result += Integer.toString(b.getSecond() - a.getSecond());

        return result;
    }
}
