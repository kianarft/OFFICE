package com.mftplus.office.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceArray;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder

@Entity(name = "departmentEntity")
@Table(name = "department_tbl")

public class Department {
    @Id
    @SequenceGenerator(name = "departmentSeq", sequenceName = "department_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "depatmentSeq")
    @Column(name = "id")
    private Long id;

    @Column(name = "department_name", length = 50)
    private String departmentName;

    @Column(name = "description_department")
    private String descriptionDepartment;

    @OneToMany(mappedBy = "department")
    private List<Employee> employeeList = new ArrayList<>();

}
