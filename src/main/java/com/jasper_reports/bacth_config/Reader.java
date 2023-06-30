//package com.jasper_reports.bacth_config;
//
//import com.jasper_reports.dto.KprDto;
//import org.springframework.batch.item.*;
//import org.springframework.batch.item.database.JdbcCursorItemReader;
//import org.springframework.context.annotation.Bean;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//
//import javax.sql.DataSource;
//import java.lang.reflect.Array;
//import java.util.*;
//
//public class Reader  implements ItemReader<List<KprDto>> {
//
//    private String[] messages = { "javainuse.com",
//            "Welcome to Spring Batch Example",
//            "We use H2 Database for this example" };
//
//     public  int min;
//
//    public  int max;
//
//    public static int incrementor=0;
//
//    public static List minList=new ArrayList();
//
//    public static List maxList=new ArrayList();
//
//    static  boolean read =false;
//
//    @Bean
//    public DataSource dataSource() {
//        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("org.postgresql.Driver");
//        dataSource.setUrl("jdbc:postgresql://localhost:5432/JasperReport");
//        dataSource.setUsername("postgres");
//        dataSource.setPassword("0367");
//
//        return dataSource;
//    }
//
//    @Override
////    @StepScope
//    public  List<KprDto> read() throws Exception, UnexpectedInputException,
//            ParseException, NonTransientResourceException {
//
//
//        if(read){
//            return null;
//        }
//
//        for(int i=0;i<SpringBatchConfig.maxValuesList.size();i++){
//            System.out.println(SpringBatchConfig.minValuesList.get(i)+","+SpringBatchConfig.maxValuesList.get(i));
////            minList.add(SpringBatchConfig.minValuesList[i]);
////            maxList.add(SpringBatchConfig.maxValuesList[i]);
//        }
////        minList.addAll(Arrays.asList(SpringBatchConfig.minValuesList));
////        maxList.addAll(Arrays.asList(SpringBatchConfig.maxValuesList));
//
////        System.out.println(minList);
////        System.out.println(maxList);
////
//        System.out.println("-----------------------");
////
//
//        Object min=SpringBatchConfig.minValuesList.get(incrementor);
//        Object max=SpringBatchConfig.maxValuesList.get(incrementor);
//        System.out.println(min);
//        System.out.println(max);
////        System.out.println(incrementor);
//
//        JdbcTemplate template = new JdbcTemplate();
//        template.setDataSource(dataSource());
//        List<KprDto> list = template.query("SELECT kr_production_report_id,bds_details.*,crew_details.*,other.*,post_kr_details.*,pouring_details.*,\n" +
//                "process_details.*,process_time_details.*,treatment_details.*,trs_details.*  FROM kr_production_report.kr_production_report As master\n" +
//                "LEFT JOIN kr_production_report.bds_details as bds_details ON bds_details.bds_details_id = master.bds_details_id \n" +
//                "LEFT JOIN kr_production_report.crew_details as crew_details ON crew_details.crew_details_id = master.crew_details_id\n" +
//                "LEFT JOIN kr_production_report.other as other ON other.other_id = master.other_id\n" +
//                "LEFT JOIN kr_production_report.post_kr_details as post_kr_details ON post_kr_details.post_kr_details_id = master.post_kr_details_id\n" +
//                "LEFT JOIN kr_production_report.pouring_details as pouring_details ON pouring_details.pouring_details_id = master.pouring_details_id\n" +
//                "LEFT JOIN kr_production_report.process_details as process_details ON process_details.process_details_id = master.process_details_id\n" +
//                "LEFT JOIN kr_production_report.process_time_details as process_time_details ON process_time_details.process_time_details_id = master.process_time_details_id\n" +
//                "LEFT JOIN kr_production_report.treatment_details as treatment_details ON treatment_details.treatment_details_id = master.treatment_details_id\n" +
//                "LEFT JOIN kr_production_report.trs_details as trs_details ON trs_details.trs_details_id = master.trs_details_id where kr_production_report_id >= "+min+" and kr_production_report_id <= "+max, new KprRowMapper());
//
//
////        if(!list.isEmpty()) {
////            System.out.println(list.size());
////            System.out.println(list.get(0).getSrNo());
////            System.out.println(list.get(list.size()-1).getSrNo());
////        }
//
//
//
////        JdbcCursorItemReader<KprDto> reader = new JdbcCursorItemReader<>();
////        reader.setDataSource(dataSource());
////        reader.setSql("SELECT * FROM kr_production_report.kr_production_report where kr_production_report_id <=20");
////        reader.setRowMapper(new KprRowMapper());
////        reader.open(new ExecutionContext());
//
//
////       List<KrProductionReport> krProductionReportList=kprRepository.findAll();
////      krProductionReportList= krProductionReportList.stream().filter(krProductionReport -> krProductionReport.getKrProductionReportId()>=100).collect(Collectors.toList());
//
////        System.out.println(Array.getLength(SpringBatchConfig.minValuesList));
//
////       long count= Arrays.stream(SpringBatchConfig.minValuesList.toArray()).filter(val-> val>0).count() ;
////
////       System.out.println(count);
////
//
//        Processor.list.addAll(list);
//
//        if(SpringBatchConfig.partitionSize-1 == incrementor) {
//            System.out.println("returning true");
//            read = true;
//        }
//
//        incrementor=incrementor+1;
//
////        return list;
//
//        return new ArrayList<>();
//    }
//
//}