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
@Table(name = "TreatmentDetails", schema = "kr_production_report")
public class TreatmentDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "static_reports")
    @SequenceGenerator(name = "static_reports", sequenceName = "reports_seq", allocationSize = 1)
    @Column(name = "treatmentDetailsId")
    public int treatmentDetailsId;

    @Column(name = "bcBayArrivalTime")
    public LocalDateTime bcBayArrivalTime;

    @Column(name = "dataTypeEntry")
    public String dataTypeEntry;

    @Column(name = "impellerRefractSupplier")
    public String impellerRefractSupplier;

    @Column(name = "reTreatment")
    public String reTreatment;

    @Column(name = "remarks")
    public String remarks;

    @Column(name = "treatCounter")
    public long treatCounter;


}