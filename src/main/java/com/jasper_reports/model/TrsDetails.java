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
@Table(name = "TrsDetails", schema = "kr_production_report")
public class TrsDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "static_reports")
    @SequenceGenerator(name = "static_reports", sequenceName = "reports_seq", allocationSize = 1)
    @Column(name = "trsDetailsId")
    public int trsDetailsId;

    @Column(name = "castNo")
    public long castNo;

    @Column(name = "src")
    public String src;

    @Column(name = "temp")
    public long temp;

    @Column(name = "trpdGrssWgt")
    public long trpdGrssWgt;

    @Column(name = "trpdNetWgt")
    public long trpdNetWgt;

    @Column(name = "trpdNo")
    public long trpdNo;

    @Column(name = "trpdTareWgt")
    public long trpdTareWgt;
    @Column(name = "trsC")
    public double trsC;
    @Column(name = "trsMn")
    public double trsMn;
    @Column(name = "trsP")
    public double trsP;
    @Column(name = "trsS")
    public double trsS;
    @Column(name = "trsSi")
    public double trsSi;
    @Column(name = "trsTi")
    public double trsTi;


}