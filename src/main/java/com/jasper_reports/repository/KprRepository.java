package com.jasper_reports.repository;

import com.jasper_reports.model.KrProductionReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface KprRepository extends JpaRepository<KrProductionReport,Integer> {

    @Query(value = "SELECT count(*) FROM kr_production_report.kr_production_report",nativeQuery = true)
    public long count();
}
