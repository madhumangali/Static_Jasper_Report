package com.jasper_reports.model;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ProcessDetails", schema = "kr_production_report")
public class ProcessDetails
{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "static_reports")
    @SequenceGenerator(name = "static_reports", sequenceName = "reports_seq", allocationSize = 1)
    @Column(name = "processDetailsId")
    public int processDetailsId;

    @Column(name = "aiDross")
    public long aiDross;

    @Column(name = "aims")
    public double aims;

    @Column(name = "deSkulling")
    public long deSkulling;

    @Column(name = "flourSpar")
    public long flourSpar;

    @Column(name = "impStirrTime")
    public long impStirrTime;

    @Column(name = "impellerDepth")
    public double impellerDepth;

    @Column(name = "impellerLife")
    public long impellerLife;

    @Column(name = "impellerNo")
    public long impellerNo;

    @Column(name = "ldlFreeBoard")
    public long ldlFreeBoard;

    @Column(name = "lime")
    public long lime;

    @Column(name = "sinter")
    public long sinter;
}