package com.mftplus.office.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
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

@Entity(name = "roleEntity")
@Table(name = "role_tbl")

public class Role extends Base{
    @Id
    @SequenceGenerator(name = "employeeSeq", sequenceName = "employee_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employeeSeq")
    @Column(name = "id")
    private Long id;

    @Column(name = "name_role", length = 50)
    @Pattern(regexp = "^[a-zA-Z\\s]{3,50}$" ,message = "Invalid Name")
    private String nameRole;

    @Column(name = "description_role")
    @Pattern(regexp = "^[a-zA-Z\\s]{3,50}$")
    private String descriptionRole;
}
