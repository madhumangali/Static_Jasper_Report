package com.jasper_reports.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "BdsDetails", schema = "kr_production_report")
public class BdsDetails
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "static_reports")
    @SequenceGenerator(name = "static_reports", sequenceName = "reports_seq", allocationSize = 1)
    @Column(name = "bdsDetailsId")
    private int bdsDetailsId;

    @Column(name = "bdsC")
    private double bdsC;

    @Column(name = "bdsMn")
    private double bdsMn;

    @Column(name = "bdsS")
    private double bdsS;

    @Column(name = "bdsSampleNo")
    private String bdsSampleNo;

    @Column(name = "bdsSamplingTime")
    private LocalDateTime bdsSamplingTime;

    @Column(name = "bdsP")
    private double bdsP;

    @Column(name = "bdsSi")
    private double bdsSi;

    @Column(name = "bdsTi")
    private double bdsTi;

    @Column(name = "krInitialTemp")
    private long krInitialTemp;

    @Column(name = "preRaking")
    private String preRaking;

    @Column(name = "preRakingWt")
    private long preRakingWt;



}