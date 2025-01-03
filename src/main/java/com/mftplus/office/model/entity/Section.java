package com.mftplus.office.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;


@NoArgsConstructor
@Getter
@Setter
@SuperBuilder

@Entity(name = "sectionEntity")
@Table(name = "section_tbl")

public class Section extends Base {
    @Id
    @SequenceGenerator(name = "sectionSeq", sequenceName = "section_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sectionSeq")
    @Column(name = "id")
    private Long id;

    @Column(name = "title_section", length = 50)
    private String titleSection;

    @ManyToOne
    private Department department;

    @OneToMany(mappedBy = "section")
    private List<Employee> employeeList;
}
