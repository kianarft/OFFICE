package com.mftplus.office.model.entity;

import lombok.Getter;
import lombok.Setter;
import java.util.List;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

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

    @Column(name = "name_organization", length = 50)
    private String organizationName;

    @OneToMany(mappedBy = "organization")
    private List<Department> departmentList;

    @OneToMany
    private List<Attachment> attachmentList;
}
