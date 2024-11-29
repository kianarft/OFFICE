package com.mftplus.office.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder

@Entity(name = "departmentEntity")
@Table(name = "department_tbl")

public class Department extends Base{
    @Id
    @SequenceGenerator(name = "departmentSeq", sequenceName = "department_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "depatmentSeq")
    @Column(name = "id")
    private Long id;

    @Column(name = "department_name", length = 50)
    private String departmentName;

    @Column(name = "description_department")
    private String descriptionDepartment;

    @Column(name = "location_department")
    private String LocationDepartment;

    @OneToMany(mappedBy = "department")
    private List<Employee> employeeList = new ArrayList<>();

    @OneToMany(mappedBy = "department")
    private List<Section> sectionList;

    @ManyToOne
    private Organization organization;

    public void Department(boolean b) {
    }
}
