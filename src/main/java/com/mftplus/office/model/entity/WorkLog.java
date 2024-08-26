package com.mftplus.office.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder

@Entity(name = "worklogEntity")
@Table(name = "worklog_tbl")

public class WorkLog extends Base{
    @Id
    @SequenceGenerator(name = "worklogSeq", sequenceName = "worklog_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "worklogSeq")
    @Column(name = "id")
    private Long id;

    @Column(name = "check_in_time")
    private LocalDateTime checkInTime;

    @Column(name = "check_out_time")
    private LocalDateTime checkOutTime;

    @ManyToOne
    private Employee employee;
}

