package com.jasper_reports.service_impl;

import com.jasper_reports.dto.KprDto;
import com.jasper_reports.repository.CommonRepository;
import com.jasper_reports.service.StaticReportService;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StaticReportServiceImpl implements StaticReportService {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job job;

    @Autowired
    private CommonRepository commonRepository;

    @Override
    public String getBatchReport(long min, long max) {

        try {

            JobParameters jobParameters =  new JobParametersBuilder()
                    .addLong("time",System.currentTimeMillis())
                    .addString("read","false")
                    .addLong("min", min, true)
                    .addLong("max", max, true).toJobParameters();

            JobExecution execution = jobLauncher.run(job, jobParameters);
            System.out.println("Exit Status : " + execution.getStatus());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "Report Generated Successfully";
    }

    @Override
    public String getNormalReport(List<KprDto> list) throws JRException, SQLException {

//        String pdfName =null;
//
//        if(list.get(0) != null){
//            pdfName = list.get(0).toString();
//            list.remove(0);
//        }

        JRBeanCollectionDataSource jrBeanCollectionDataSource =new JRBeanCollectionDataSource( new ArrayList<>( list ),false);
        Map<String,Object> hashMap=new HashMap<>();
        hashMap.put("DataSourceCollection",jrBeanCollectionDataSource);

        JasperReport jasperReport= JasperCompileManager.compileReport("src/main/resources/Jpa_Report.jrxml");

        JasperPrint jasperPrint= JasperFillManager.fillReport(jasperReport,hashMap,new JREmptyDataSource());


            JasperExportManager.exportReportToPdfFile(jasperPrint,"D://StaticReports//Jsw_Normal_Report.pdf");
//        if(pdfName.equals(null))
//        else
//            JasperExportManager.exportReportToPdfFile(jasperPrint,"D://New//"+pdfName+".pdf");

        return "Report Generated Successfully";
    }

}
