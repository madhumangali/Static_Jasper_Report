package com.jasper_reports.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jasper_reports.model.*;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class KprDto {

//    TreatmentDetails

    private String bcBayArrivalTime;

    private String dataTypeEntry;

    private String impellerRefractSupplier;

    private String reTreatment;

    private long treatCounter;

    private String remarks;

    //    ProcessTimeDetails

    private double krCycleTime;

    private String krEndTime;

    private String krStartTime;

    private String ladleDespatchTime;

    private String postRakingEndTime;

    private String postRakingStartTime;

    private String pouringEndTime;

    private String pouringStartTime;

    private String preRakingEndTime;

    private String preRakingStartTime;

    private String tarpedoInTime;

    private String tarpedoOutTime;

    private String treatmentEndTime;

    private String treatmentStartTime;

//    TrsDetails

    private String src;

    private long castNo;

    private long temp;

    private long trpdGrssWgt;

    private long trpdNetWgt;

    private long trpdNo;

    private long trpdTareWgt;

    private double trsC;

    private double trsMn;

    private double trsP;

    private double trsS;

    private double trsSi;

    private double trsTi;


    //    BdsDetails
    private double bdsC;

    private double bdsMn;

    private double bdsS;

    private String bdsSampleNo;

    private String bdsSamplingTime;

    private double bdsP;

    private double bdsSi;

    private double bdsTi;

    private long krInitialTemp;

    private String preRaking;

    private long preRakingWt;

//    CrewDetails

    private String krOperator;

    private String rankingOperator;

    private String shiftManager;

//    Other

    private String desStation;

    private String pouringStationNo;

    private String productionDate;

    private String shift;

    private long srNo;

    private String treatNo;

//    PostKrDetails

    private String adsSampleNo;

    private String adsSamplingTime;

    private long krFinalTemp;

    private double pkrC;

    private double pkrMn;

    private double pkrP;

    private double pkrS;

    private double pkrSi;

    private double pkrTi;

    private String postRaking;

    private long postRakingWg;

    private String stagRakingQty;

//    PouringDetails

    private long ldlGrsWgt;

    private long ldlTareWgt;

    private String aimGrade;

    private String finalGrade;

    private String heatNo;

    private long hmQty;

    private long hmlLife;

    private long hmlNo;

    private long pourTemp;

    private long scrap;

//   ProcessDetails

    private long aiDross;

    private double aimS;

    private long deSkulling;

    private long flourSpar;

    private long impStirrTime;

    private double impellerDepth;

    private long impellerLife;

    private long impellerNo;

    private long ldlFreeBoard;

    private long lime;

    private long sinter;

    public String getBcBayArrivalTime() {
        return bcBayArrivalTime;
    }

    public void setBcBayArrivalTime(String bcBayArrivalTime) {
        this.bcBayArrivalTime = bcBayArrivalTime;
    }
}
