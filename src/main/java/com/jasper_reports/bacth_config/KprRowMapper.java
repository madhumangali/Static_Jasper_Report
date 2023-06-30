package com.jasper_reports.bacth_config;

import com.jasper_reports.dto.KprDto;
import com.jasper_reports.model.KrProductionReport;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KprRowMapper implements RowMapper<KprDto> {
    @Override
    public KprDto mapRow(ResultSet rs, int rowNum) throws SQLException {

            KprDto kprDto=new KprDto();

            kprDto.setBdsC(rs.getDouble("bdsc"));
        kprDto.setBdsMn(rs.getDouble("bds_mn"));
        kprDto.setBdsS(rs.getDouble("bdss"));
        kprDto.setBdsSampleNo(rs.getString("bds_sample_no"));
        kprDto.setBdsSamplingTime(rs.getTimestamp("bds_sampling_time").toString());
        kprDto.setBdsSi(rs.getDouble("bds_si"));
        kprDto.setBdsTi(rs.getDouble("bds_ti"));
        kprDto.setKrInitialTemp(rs.getLong("kr_initial_temp"));
        kprDto.setPreRaking(rs.getString("pre_raking"));
        kprDto.setPreRakingWt(rs.getLong("pre_raking_wt"));

        kprDto.setKrOperator(rs.getString("kr_operator"));
        kprDto.setRankingOperator(rs.getString("ranking_operator"));
        kprDto.setShiftManager(rs.getString("shift_manager"));

        kprDto.setDesStation(rs.getString("des_station"));
        kprDto.setPouringStationNo(rs.getString("pouring_station_no"));
        kprDto.setProductionDate(rs.getTimestamp("production_date").toString());
        kprDto.setShift(rs.getString("shift"));
        kprDto.setSrNo(rs.getLong("sr_no"));
        kprDto.setTreatNo(rs.getString("treat_no"));

        kprDto.setAdsSampleNo(rs.getString("ads_sample_no"));
        kprDto.setAdsSamplingTime(rs.getTimestamp("ads_sampling_time").toString());
        kprDto.setKrFinalTemp(rs.getLong("kr_final_temp"));
        kprDto.setPkrC(rs.getDouble("pkrc"));
        kprDto.setPkrMn(rs.getDouble("pkr_mn"));
        kprDto.setPkrP(rs.getDouble("pkrp"));
        kprDto.setPkrS(rs.getDouble("pkrs"));
        kprDto.setPkrSi(rs.getDouble("pkr_si"));
        kprDto.setPkrTi(rs.getDouble("pkr_ti"));
        kprDto.setPostRaking(rs.getString("post_raking"));
        kprDto.setPostRakingWg(rs.getLong("post_raking_wg"));
        kprDto.setStagRakingQty(rs.getString("stag_raking_qty"));

        kprDto.setAimGrade(rs.getString("aim_grade"));
        kprDto.setFinalGrade(rs.getString("final_grade"));
        kprDto.setHeatNo(rs.getString("heat_no"));
        kprDto.setHmQty(rs.getLong("hm_qty"));
        kprDto.setHmlLife(rs.getLong("hml_life"));
        kprDto.setHmlNo(rs.getLong("hml_no"));
        kprDto.setLdlGrsWgt(rs.getLong("ldl_grs_wgt"));
        kprDto.setLdlTareWgt(rs.getLong("ldl_tare_wgt"));
        kprDto.setPourTemp(rs.getLong("pour_temp"));
        kprDto.setScrap(rs.getLong("scrap"));

        kprDto.setAiDross(rs.getLong("ai_dross"));
        kprDto.setAimS(rs.getDouble("aims"));
        kprDto.setDeSkulling(rs.getLong("de_skulling"));
        kprDto.setFlourSpar(rs.getLong("flour_spar"));
        kprDto.setImpStirrTime(rs.getLong("imp_stirr_time"));
        kprDto.setImpellerDepth(rs.getLong("impeller_depth"));
        kprDto.setImpellerLife(rs.getLong("impeller_life"));
        kprDto.setImpellerNo(rs.getLong("impeller_no"));
        kprDto.setLdlFreeBoard(rs.getLong("ldl_free_board"));
        kprDto.setLime(rs.getLong("lime"));
        kprDto.setSinter(rs.getLong("sinter"));

        kprDto.setKrCycleTime(rs.getDouble("kr_cycle_time"));
        kprDto.setKrEndTime(rs.getTimestamp("kr_end_time").toString());
        kprDto.setKrStartTime(rs.getTimestamp("kr_start_time").toString());
        kprDto.setLadleDespatchTime(rs.getTimestamp("ladle_despatch_time").toString());
        kprDto.setPostRakingEndTime(rs.getTimestamp("post_raking_end_time").toString());
        kprDto.setPostRakingStartTime(rs.getTimestamp("post_raking_start_time").toString());
        kprDto.setPouringEndTime(rs.getTimestamp("pouring_end_time").toString());
        kprDto.setPouringStartTime(rs.getTimestamp("pouring_start_time").toString());
        kprDto.setPreRakingEndTime(rs.getTimestamp("pre_raking_end_time").toString());
        kprDto.setPreRakingStartTime(rs.getTimestamp("pre_raking_start_time").toString());
        kprDto.setTarpedoInTime(rs.getTimestamp("tarpedo_in_time").toString());
        kprDto.setTarpedoOutTime(rs.getTimestamp("tarpedo_out_time").toString());
        kprDto.setTreatmentEndTime(rs.getTimestamp("treatment_end_time").toString());
        kprDto.setTreatmentStartTime(rs.getTimestamp("treatment_start_time").toString());

        kprDto.setBcBayArrivalTime(rs.getTimestamp("bc_bay_arrival_time").toString());
        kprDto.setDataTypeEntry(rs.getString("data_type_entry"));
        kprDto.setImpellerRefractSupplier(rs.getString("impeller_refract_supplier"));
        kprDto.setReTreatment(rs.getString("re_treatment"));
        kprDto.setRemarks(rs.getString("remarks"));
        kprDto.setTreatCounter(rs.getLong("treat_counter"));

        kprDto.setCastNo(rs.getLong("cast_no"));
        kprDto.setSrc(rs.getString("src"));
        kprDto.setTemp(rs.getLong("temp"));
        kprDto.setTrpdGrssWgt(rs.getLong("trpd_grss_wgt"));
        kprDto.setTrpdNetWgt(rs.getLong("trpd_net_wgt"));
        kprDto.setTrpdNo(rs.getLong("trpd_no"));
        kprDto.setTrpdTareWgt(rs.getLong("trpd_tare_wgt"));
        kprDto.setTrsC(rs.getDouble("trsc"));
        kprDto.setTrsMn(rs.getDouble("trs_mn"));
        kprDto.setTrsP(rs.getDouble("trsp"));
        kprDto.setTrsS(rs.getDouble("trss"));
        kprDto.setTrsSi(rs.getDouble("trs_si"));
        kprDto.setTrsTi(rs.getDouble("trs_ti"));

//        System.out.println("RowMapper");
//            kprDtos.add(kprDto);
//        }

        return kprDto;
    }
}
