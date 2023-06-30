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
@Table(name = "PostKrDetails", schema = "kr_production_report")
public class PostKrDetails
{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "static_reports")
    @SequenceGenerator(name = "static_reports", sequenceName = "reports_seq", allocationSize = 1)
    @Column(name = "postKrDetailsId")
    private int postKrDetailsId;

    @Column(name = "adsSampleNo")
    private String adsSampleNo;

    @Column(name = "adsSamplingTime")
    private LocalDateTime adsSamplingTime;

    @Column(name = "krFinalTemp")
    private long krFinalTemp;

    @Column(name = "pkrC")
    private double pkrC;

    @Column(name = "pkrMn")
    private double pkrMn;

    @Column(name = "pkrP")
    private double pkrP;

    @Column(name = "pkrS")
    private double pkrS;

    @Column(name = "pkrSi")
    private double pkrSi;

    @Column(name = "pkrTi")
    private double pkrTi;

    @Column(name = "postRaking")
    private String postRaking;

    @Column(name = "postRakingWg")
    private long postRakingWg;

    @Column(name = "stagRakingQty")
    private String stagRakingQty;

}