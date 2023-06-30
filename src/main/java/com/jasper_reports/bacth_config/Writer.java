//package com.jasper_reports.bacth_config;
//
//import com.jasper_reports.dto.KprDto;
//import com.jasper_reports.model.KrProductionReport;
//import lombok.extern.log4j.Log4j2;
//import net.sf.jasperreports.data.DataSourceCollection;
//import net.sf.jasperreports.engine.*;
//import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
//import org.springframework.batch.item.ExecutionContext;
//import org.springframework.batch.item.ItemWriter;
//import org.springframework.batch.item.database.JdbcCursorItemReader;
//
//import java.util.*;
//import java.util.stream.Collectors;
//
//@Log4j2
//public class Writer implements ItemWriter<List<KprDto>> {
//
//    static long jobId;
//
//    static int min=1;
//
//    static int max =1000;
//
//
//    @Override
//    public void write(List<? extends List<KprDto>> list) throws Exception {
//
//        Random random=new Random();
//        System.out.println(random.nextInt());
//        long name = random.nextLong()-jobId;
//
//        log.info(list.size());
//
//        JRBeanCollectionDataSource jrBeanCollectionDataSource =new JRBeanCollectionDataSource( new ArrayList<>( list.get(0) ),false);
//        Map<String,Object> hashMap=new HashMap<>();
//        hashMap.put("DataSourceCollection",jrBeanCollectionDataSource);
//        JasperReport jasperReport= JasperCompileManager.compileReport("src/main/resources/Jpa_Report.jrxml");
//        JasperPrint jasperPrint=JasperFillManager.fillReport(jasperReport,hashMap,new JREmptyDataSource());
//        JasperExportManager.exportReportToPdfFile(jasperPrint,"D://Reports//"+name+".pdf");
//        System.out.println("Writer");
//    }
//
//}
