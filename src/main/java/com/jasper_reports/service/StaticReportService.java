package com.jasper_reports.service;

import com.jasper_reports.dto.KprDto;
import net.sf.jasperreports.engine.JRException;

import java.sql.SQLException;
import java.util.List;

public interface StaticReportService {

    public String getBatchReport(long min,long max);

    public String getNormalReport(List<KprDto> list) throws JRException, SQLException;
}
