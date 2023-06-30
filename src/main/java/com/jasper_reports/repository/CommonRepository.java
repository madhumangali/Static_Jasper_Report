package com.jasper_reports.repository;

import com.google.common.base.CharMatcher;
import com.jasper_reports.bacth_config.KprRowMapper;
import com.jasper_reports.dto.KprDto;
import com.jasper_reports.model.Other;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public interface CommonRepository extends JpaRepository<Other,Long> {

    default DataSource dataSource() {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/JasperReport");
        dataSource.setUsername("postgres");
        dataSource.setPassword("0367");

        return dataSource;
    }

    default List getData(long min,long max,String partitionName) throws SQLException {

        List list=new ArrayList<>();

        if(partitionName !=null )
            list.add(CharMatcher.digit().retainFrom(partitionName));

        JdbcTemplate template = new JdbcTemplate();
        template.setDataSource(dataSource());
        List<KprDto> kprDtoList = template.query("SELECT kr_production_report_id,bds_details.*,crew_details.*,other.*,post_kr_details.*,pouring_details.*,\n" +
                "process_details.*,process_time_details.*,treatment_details.*,trs_details.*  FROM kr_production_report.kr_production_report As master\n" +
                "LEFT JOIN kr_production_report.bds_details as bds_details ON bds_details.bds_details_id = master.bds_details_id \n" +
                "LEFT JOIN kr_production_report.crew_details as crew_details ON crew_details.crew_details_id = master.crew_details_id\n" +
                "LEFT JOIN kr_production_report.other as other ON other.other_id = master.other_id\n" +
                "LEFT JOIN kr_production_report.post_kr_details as post_kr_details ON post_kr_details.post_kr_details_id = master.post_kr_details_id\n" +
                "LEFT JOIN kr_production_report.pouring_details as pouring_details ON pouring_details.pouring_details_id = master.pouring_details_id\n" +
                "LEFT JOIN kr_production_report.process_details as process_details ON process_details.process_details_id = master.process_details_id\n" +
                "LEFT JOIN kr_production_report.process_time_details as process_time_details ON process_time_details.process_time_details_id = master.process_time_details_id\n" +
                "LEFT JOIN kr_production_report.treatment_details as treatment_details ON treatment_details.treatment_details_id = master.treatment_details_id\n" +
                "LEFT JOIN kr_production_report.trs_details as trs_details ON trs_details.trs_details_id = master.trs_details_id where kr_production_report_id >= "+min+" and kr_production_report_id <= "+max, new KprRowMapper());
        list.addAll(kprDtoList);

        return list;
    }

}
