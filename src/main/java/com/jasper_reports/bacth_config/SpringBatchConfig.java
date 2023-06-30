//package com.jasper_reports.bacth_config;
//
//
//
//import com.jasper_reports.dto.KprDto;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import lombok.extern.log4j.Log4j2;
//import net.sf.jasperreports.engine.*;
//import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
//import org.hibernate.Transaction;
//import org.springframework.batch.core.*;
//import org.springframework.batch.core.annotation.BeforeStep;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepScope;
//import org.springframework.batch.core.launch.support.RunIdIncrementer;
//import org.springframework.batch.core.partition.PartitionHandler;
//import org.springframework.batch.core.partition.support.TaskExecutorPartitionHandler;
//import org.springframework.batch.item.*;
//import org.springframework.batch.item.file.FlatFileItemReader;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.task.TaskExecutor;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
//
//import javax.sql.DataSource;
//import java.util.*;
//
//@Configuration
//@AllArgsConstructor
//@NoArgsConstructor
//@Data
//@Log4j2
////@EnableBatchProcessing
//public class SpringBatchConfig {
//
//
//    @Autowired
//    public JobBuilderFactory jobBuilderFactory;
//
//    @Autowired
//    public StepBuilderFactory stepBuilderFactory;
//
//    public static  List minValuesList=new ArrayList();
//
//    public static  List maxValuesList=new ArrayList();
//
//    public static int partitionSize=2;
//
////    @Bean
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
//    @Bean
//    public Job processJob() throws Exception {
//        return jobBuilderFactory.get("processJob")
//                .incrementer(new RunIdIncrementer())
//                .listener(new JobCompletionListener())
//                .start(masterStep())
////                .flow(masterStep())
////                .on("FINISHED")
////                .end()
//                .build();
//    }
//
//    @Bean
//    public CustomizedPartitioner partitioner() {
//        return new CustomizedPartitioner();
//    }
//
//    @Bean
//    public PartitionHandler partitionHandler() {
//        TaskExecutorPartitionHandler taskExecutorPartitionHandler = new TaskExecutorPartitionHandler();
//        taskExecutorPartitionHandler.setStep(slaveStep());
//        taskExecutorPartitionHandler.setGridSize(partitionSize);
//        taskExecutorPartitionHandler.setTaskExecutor(taskExecutor());
//
//        return taskExecutorPartitionHandler;
//    }
//
//
//    @Bean
//    public Step masterStep() {
//        return stepBuilderFactory.get("masterSTep")
////                         .partitioner(slaveStep())
//                         . partitioner(slaveStep().getName(), partitioner())
//                         .step(slaveStep())
//                         .partitionHandler(partitionHandler())
//                         .taskExecutor(taskExecutor())
//                         .build();
//    }
//
//    @Bean
//    public TaskExecutor taskExecutor() {
////          SimpleAsyncTaskExecutor taskExecutor=new SimpleAsyncTaskExecutor();
////          taskExecutor.setConcurrencyLimit(10);
//
//
//        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
//        taskExecutor.setMaxPoolSize(1);
//        taskExecutor.afterPropertiesSet();
//        taskExecutor.setCorePoolSize(1);
////        taskExecutor.setQueueCapacity(10);
////        taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
////        taskExecutor.setThreadNamePrefix("MultiThreaded-");
////        taskExecutor.setAllowCoreThreadTimeOut(true);
//        return taskExecutor;
//    }
//
//
//    @Bean
//    public Step slaveStep() {
//
//        return stepBuilderFactory.get("slaveStep").<List<KprDto>,List<KprDto>>chunk(5000)
//                .reader( itemReader(0,0))
//                . processor( itemProcessor())
//                .writer(itemWriter())
////                .listener(new JobCompletionListener())
//                .build();
//    }
//
//    @Bean
//    @StepScope
//    public ItemReader<List<KprDto>> itemReader(@Value("#{stepExecutionContext['minValue']}") int min,@Value("#{stepExecutionContext['maxValue']}") int max) {
//        List<Integer> remainingData = new ArrayList<>();
//        return new ItemReader<List<KprDto>>() {
//            @Override
//            public List<KprDto> read() {
//
//                log.info(min+","+max);
//                JdbcTemplate template = new JdbcTemplate();
//                template.setDataSource(dataSource());
//                List<KprDto> list = template.query("SELECT kr_production_report_id,bds_details.*,crew_details.*,other.*,post_kr_details.*,pouring_details.*,\n" +
//                        "process_details.*,process_time_details.*,treatment_details.*,trs_details.*  FROM kr_production_report.kr_production_report As master\n" +
//                        "LEFT JOIN kr_production_report.bds_details as bds_details ON bds_details.bds_details_id = master.bds_details_id \n" +
//                        "LEFT JOIN kr_production_report.crew_details as crew_details ON crew_details.crew_details_id = master.crew_details_id\n" +
//                        "LEFT JOIN kr_production_report.other as other ON other.other_id = master.other_id\n" +
//                        "LEFT JOIN kr_production_report.post_kr_details as post_kr_details ON post_kr_details.post_kr_details_id = master.post_kr_details_id\n" +
//                        "LEFT JOIN kr_production_report.pouring_details as pouring_details ON pouring_details.pouring_details_id = master.pouring_details_id\n" +
//                        "LEFT JOIN kr_production_report.process_details as process_details ON process_details.process_details_id = master.process_details_id\n" +
//                        "LEFT JOIN kr_production_report.process_time_details as process_time_details ON process_time_details.process_time_details_id = master.process_time_details_id\n" +
//                        "LEFT JOIN kr_production_report.treatment_details as treatment_details ON treatment_details.treatment_details_id = master.treatment_details_id\n" +
//                        "LEFT JOIN kr_production_report.trs_details as trs_details ON trs_details.trs_details_id = master.trs_details_id where kr_production_report_id >= "+min+" and kr_production_report_id <= "+max, new KprRowMapper());
//
//                if (list.size() > 0) {
//                    return list;
//                }
//
//                return null;
//            }
//        };
//    }
//
//    @Bean
//    public ItemWriter<List<KprDto>> itemWriter() {
//        return new ItemWriter<List<KprDto>>() {
//            @Override
//            public void write(List<? extends List<KprDto>> list) throws Exception {
//                Random random=new Random();
//                System.out.println(random.nextInt());
//                long name = random.nextLong();
//
//                JRBeanCollectionDataSource jrBeanCollectionDataSource =new JRBeanCollectionDataSource( new ArrayList<>( list.get(0) ),false);
//                Map<String,Object> hashMap=new HashMap<>();
//                hashMap.put("DataSourceCollection",jrBeanCollectionDataSource);
//                JasperReport jasperReport= JasperCompileManager.compileReport("src/main/resources/Jpa_Report.jrxml");
//                JasperPrint jasperPrint= JasperFillManager.fillReport(jasperReport,hashMap,new JREmptyDataSource());
//                JasperExportManager.exportReportToPdfFile(jasperPrint,"D://Reports//"+name+".pdf");
//                System.out.println("Writer");
//            }
//        };
//    }
//
//
//    @Bean
//    public ItemProcessor<List<KprDto>, List<KprDto>> itemProcessor() {
//        return new ItemProcessor<List<KprDto>,List<KprDto>>() {
//            @Override
//            public List<KprDto> process(List<KprDto> item) {
//                return item;
//            }
//        };
//    }
//
//
//}
//
//
//
//
//
//
//
//
//
