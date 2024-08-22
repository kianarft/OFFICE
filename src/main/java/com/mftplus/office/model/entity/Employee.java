package com.mftplus.office.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
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

    @Column(name = "name_employee", length = 50)
    @Pattern(regexp = "^[a-zA-Z\\s]{3,50}$" ,message = "Invalid Name")
    private String nameEmployee;

    @Column(name = "position_employee", length = 50)
    @Pattern(regexp = "^[a-zA-Z\\s]{3,50}$" ,message = "Invalid Position")
    private String positionEmployee;

    @Column(name = "hourly payment")
    private String hourlyPayment;


}
