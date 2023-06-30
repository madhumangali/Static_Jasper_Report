package com.jasper_reports.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jasper_reports.bacth_config.KprRowMapper;
//import com.jasper_reports.bacth_config.Reader;
//import com.jasper_reports.bacth_config.SpringBatchConfig;
import com.jasper_reports.batch_config_org.BatchConfig;
import com.jasper_reports.dto.KprDto;
import com.jasper_reports.repository.CommonRepository;
import com.jasper_reports.repository.KprRepository;
import com.jasper_reports.service.StaticReportService;
import com.jasper_reports.thread.MultiThread;
import com.lowagie.text.pdf.PdfDocument;
import lombok.extern.log4j.Log4j2;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yaml.snakeyaml.util.ArrayUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.util.*;

@RestController
@RequestMapping("/static")
@Log4j2
public class StaticReportController {

    @Autowired
    private KprRepository kprRepository;

    @Autowired
    private StaticReportService staticReportService;

    @Autowired
    private CommonRepository commonRepository;

    @GetMapping(value = "/batch/report")
    @JsonIgnore
    public ResponseEntity<String> getBatchReport() throws Exception {

        long count=kprRepository.count();
        long min=1;
        long max=1000;

        ResponseEntity<String> response = new ResponseEntity<>(staticReportService.getBatchReport(min,max), HttpStatus.OK);

        PDFMergerUtility pdfMergerUtility=new PDFMergerUtility();

        File folder = new File("D:/BatchReports/");
        File[] listOfFiles = folder.listFiles();

        for (File file : listOfFiles) {
            if (file.isFile()) {

                pdfMergerUtility.addSource(file);
                log.info(file.getName());
            }
        }


        pdfMergerUtility.setDestinationFileName("D://StaticReports//Jsw_Batch_Report.pdf");
        pdfMergerUtility.mergeDocuments();

        log.info("Report Generated Succesfully");

        return response;

//        long iteration = count%10000==0 ? count/10000 : (count/10000)+(count%10000);
//        for(int i=0;i<iteration;i++){
//            log.info(min);
//            log.info(max);
//            min=max+1;
//            max=max+10000;

//        }

//

    }

    @GetMapping(value = "/report")
    @JsonIgnore
    public ResponseEntity<?> getNormalReport() throws Exception {


        long count=kprRepository.count();
        long min=1;
        long max=1000;

        List<KprDto> list=commonRepository.getData(1,1000,null);

        ResponseEntity<String> response = new ResponseEntity<>(staticReportService.getNormalReport(list), HttpStatus.OK);
        log.info("Report Generated Succesfully");

        return response;

    }

}
