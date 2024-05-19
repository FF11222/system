package com.tingyu.system.entity;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.Pair;

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
    @CollectionTable(name = "attend_date", joinColumns = @JoinColumn(name = "attend_id"))
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private List<Pair<Date, Date>> attend;

}
