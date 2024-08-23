package com.mftplus.office.model.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import java.time.LocalDateTime;
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@Entity(name = "salarySlipEntity")
@Table(name = "salary_slip_tbl")
public class SalarySlip {
    @Id
    @SequenceGenerator(name = "salarySlipSeq", sequenceName = "salarySlip_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "salarySlipSeq")
    @Column(name = "id")
    private Long id;
    @Column(name = "month")
    private LocalDateTime month;
    @Column(name = "total_hours")
    private String totalHours;
    @Column(name = "total_salary")
    private String totalSalary;
    @Column(name = "bonus")
    private String bonus;
    @OneToOne
    private Employee employee;
}
