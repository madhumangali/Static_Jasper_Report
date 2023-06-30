//package com.jasper_reports.bacth_config;
//
//import com.jasper_reports.dto.KprDto;
//import com.jasper_reports.model.KrProductionReport;
//import org.springframework.batch.item.ExecutionContext;
//import org.springframework.batch.item.ItemProcessor;
//import org.springframework.batch.item.ItemStream;
//import org.springframework.batch.item.ItemStreamException;
//import org.springframework.batch.item.database.JdbcCursorItemReader;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
//public class Processor implements ItemProcessor<List<KprDto>, List<KprDto>> {
//
//    public static List<KprDto> list=new ArrayList<>();
//
//    @Override
//    public List<KprDto> process(List<KprDto> data) throws Exception {
//        data.addAll(list);
//        list.clear();
//        System.out.println("PROCESSOR");
//        return data;
//    }
//
//}