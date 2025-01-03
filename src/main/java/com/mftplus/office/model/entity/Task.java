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

@Entity(name = "taskEntity")
@Table(name = "task-tbl")

public class Task extends Base{
    @Id
    @SequenceGenerator(name = "taskSeq", sequenceName = "task_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "taskSeq")
    @Column(name = "id")
    private Long id;

    @Column(name = "name_task", length = 50)
    private String taskName;

}
