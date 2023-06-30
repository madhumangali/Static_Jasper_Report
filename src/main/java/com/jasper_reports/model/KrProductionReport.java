package com.jasper_reports.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "KrProductionReport", schema = "kr_production_report")
public class KrProductionReport
{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "static_reports")
    @SequenceGenerator(name = "static_reports", sequenceName = "reports_seq", allocationSize = 1)
    @Column(name = "krProductionReportId")
    private int krProductionReportId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bdsDetailsId")
    private BdsDetails bdsDetails;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "crewDetailsId")
    private CrewDetails crewDetails;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "otherId")
    private Other other;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "postKrDetailsId")
    private PostKrDetails postKrDetails;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pouringDetailsId")
    private PouringDetails pouringDetails;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "processTimeDetailsId")
    private ProcessTimeDetails processTimeDetails;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "processDetailsId")
    private ProcessDetails processDetails;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "treatmentDetailsId")
    private TreatmentDetails treatmentDetails;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "trsDetailsId")
    private TrsDetails trsDetails;



}