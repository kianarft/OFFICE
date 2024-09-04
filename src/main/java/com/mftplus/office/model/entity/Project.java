package com.mftplus.office.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder

@Entity(name = "projectEntity")
@Table(name = "project_tbl")

public class Project extends Base{
    @Id
    @SequenceGenerator(name = "projectSeq", sequenceName = "project_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "projectSeq")
    @Column(name = "id")
    private Long id;

    @Column(name = "project_name")
    private String projectName;

    @Column(name = "project_start_date")
    private LocalDateTime projectStartDate;

    @Column(name = "project_bonus")
    private LocalDateTime projectEndDate;

    @ManyToMany(mappedBy = "projects")
    private List<Employee> employees=
            new ArrayList<>();
}

