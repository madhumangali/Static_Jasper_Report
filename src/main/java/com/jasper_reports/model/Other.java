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
@Table(name = "Other", schema = "kr_production_report")
public class Other
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "static_reports")
    @SequenceGenerator(name = "static_reports", sequenceName = "reports_seq", allocationSize = 1)
    @Column(name = "otherId")
    private int otherId;

    @Column(name = "desStation")
    private String desStation;


    @Column(name = "pouringStationNo")
    private String pouringStationNo;

    @Column(name = "productionDate")
    private LocalDateTime productionDate;

    @Column(name = "shift")
    private String shift;

    @Column(name = "srNo")
    private long srNo;

    @Column(name = "treatNo")
    private String treatNo;




}