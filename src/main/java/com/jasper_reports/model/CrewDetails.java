package com.jasper_reports.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CrewDetails", schema = "kr_production_report")
public class CrewDetails
{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "static_reports")
    @SequenceGenerator(name = "static_reports", sequenceName = "reports_seq", allocationSize = 1)
    @Column(name = "crewDetailsId")
    private int crewDetailsId;

    @Column(name = "krOperator")
    private String krOperator;

    @Column(name = "rankingOperator")
    private String rankingOperator;

    @Column(name = "shiftManager")
    private String shiftManager;


}