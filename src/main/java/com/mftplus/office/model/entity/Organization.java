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

@Entity(name = "organizationEntity")
@Table(name = "organization_tbl")

public class Organization extends Base {
    @Id
    @SequenceGenerator(name = "organizationSeq", sequenceName = "organization_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "organizationSeq")
    @Column(name = "id")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "organization")
    private List<Department> departmentList;

    @OneToMany
    private List<Attachment> attachmentList;
}
