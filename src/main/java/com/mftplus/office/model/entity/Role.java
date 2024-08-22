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

@Entity(name = "employeeEntity")
@Table(name = "employee_tbl")

public class Role {
    @Id
    @SequenceGenerator(name = "employeeSeq", sequenceName = "employee_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employeeSeq")
    @Column(name = "id")
    private Long id;

    @Column(name = "role_name", length = 50)
    private String roleName;

    @Column(name = "description_role")
    private String descriptionRole;

    @ManyToMany(mappedBy = "roles")
    private List<Employee> employeeList = new ArrayList<>();
}
