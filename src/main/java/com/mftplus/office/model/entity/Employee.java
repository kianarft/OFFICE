package com.mftplus.office.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder

@Entity(name = "employeeEntity")
@Table(name = "employee_tbl")

public class Employee extends Base {
    @Id
    @SequenceGenerator(name = "employeeSeq", sequenceName = "employee_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employeeSeq")
    @Column(name = "id")
    private Long id;

    @Column(name = "employee_name", length = 50)
    private String employeeName;

    @Column(name = "position_employee")
    private String positionEmployee;

    @Column(name = "hourly payment")
    private String hourlyPayment;


}
