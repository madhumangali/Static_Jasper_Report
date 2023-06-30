package com.jasper_reports.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ProcessTimeDetails", schema = "kr_production_report")
public class ProcessTimeDetails
{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "static_reports")
    @SequenceGenerator(name = "static_reports", sequenceName = "reports_seq", allocationSize = 1)
    @Column(name = "processTimeDetailsId")
    public int processTimeDetailsId;

    @Column(name = "krCycleTime")
    public double krCycleTime;

    @Column(name = "krEndTime")
    public LocalDateTime krEndTime;

    @Column(name = "krStartTime")
    public LocalDateTime krStartTime;

    @Column(name = "ladleDespatchTime")
    public LocalDateTime ladleDespatchTime;

    @Column(name = "postRakingEndTime")
    public LocalDateTime postRakingEndTime;

    @Column(name = "postRakingStartTime")
    public LocalDateTime postRakingStartTime;

    @Column(name = "pouringEndTime")
    public LocalDateTime pouringEndTime;

    @Column(name = "pouringStartTime")
    public LocalDateTime pouringStartTime;

    @Column(name = "preRakingStartTime")
    public LocalDateTime preRakingStartTime;

    @Column(name = "preRakingEndTime")
    public LocalDateTime preRakingEndTime;

    @Column(name = "tarpedoInTime")
    public LocalDateTime tarpedoInTime;

    @Column(name = "tarpedoOutTime")
    public LocalDateTime tarpedoOutTime;

    @Column(name = "treatmentEndTime")
    public LocalDateTime treatmentEndTime;

    @Column(name = "treatmentStartTime")
    public LocalDateTime treatmentStartTime;
}