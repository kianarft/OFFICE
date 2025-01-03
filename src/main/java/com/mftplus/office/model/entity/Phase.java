package com.mftplus.office.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder

@Entity(name = "phaseEntity")
@Table(name = "phase-tbl")

public class Phase extends Base{
    @Id
    @SequenceGenerator(name = "phaseSeq", sequenceName = "phase-seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "phaseSeq")
    @Column(name = "id")
    private Long id;

    @Column(name = "name_phase", length = 50)
    private String phaseName;
}
