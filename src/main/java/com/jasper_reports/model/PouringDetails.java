package com.jasper_reports.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PouringDetails", schema = "kr_production_report")
public class PouringDetails
{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "static_reports")
    @SequenceGenerator(name = "static_reports", sequenceName = "reports_seq", allocationSize = 1)
    @Column(name = "pouringDetailsId")
    private int pouringDetailsId;

    @Column(name = "ldlGrsWgt")
    private long ldlGrsWgt;

    @Column(name = "ldlTareWgt")
    private long ldlTareWgt;

    @Column(name = "aimGrade")
    private String aimGrade;

    @Column(name = "finalGrade")
    private String finalGrade;

    @Column(name = "heatNo")
    private String heatNo;

    @Column(name = "hmQty")
    private long hmQty;

    @Column(name = "hmlLife")
    private long hmlLife;

    @Column(name = "hmlNo")
    private long hmlNo;

    @Column(name = "pourTemp")
    private long pourTemp;

    @Column(name = "scrap")
    private long scrap;


}