package com.jasper_reports.batch_config_org;

import com.google.common.base.CharMatcher;
import com.jasper_reports.bacth_config.*;
import com.jasper_reports.dto.KprDto;
import com.jasper_reports.repository.CommonRepository;
import com.jasper_reports.service.StaticReportService;
import lombok.extern.log4j.Log4j2;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.apache.tomcat.util.codec.binary.StringUtils;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.partition.PartitionHandler;
import org.springframework.batch.core.partition.support.TaskExecutorPartitionHandler;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.*;

@Configuration
@Log4j2
public class BatchConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private CommonRepository commonRepository;

//    @Autowired
//    public StaticReportService staticReportService;

    public DataSource dataSource() {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/JasperReport");
        dataSource.setUsername("postgres");
        dataSource.setPassword("0367");

        return dataSource;
    }

    @Bean
    public Job processJob() throws Exception {
        return jobBuilderFactory.get("processJob")
                .incrementer(new RunIdIncrementer())
                .listener(new JobCompletionListener())
                .start(masterStep())
//                .flow(masterStep())
//                .on("FINISHED")
//                .end()
                .build();
    }

    @Bean
    public CustomizedPartitioner partitioner() {
        return new CustomizedPartitioner();
    }

    @Bean
    public PartitionHandler partitionHandler() {
        TaskExecutorPartitionHandler taskExecutorPartitionHandler = new TaskExecutorPartitionHandler();
        taskExecutorPartitionHandler.setStep(slaveStep());
        taskExecutorPartitionHandler.setGridSize(2);
        taskExecutorPartitionHandler.setTaskExecutor(taskExecutor());

        return taskExecutorPartitionHandler;
    }

    @Bean
    public TaskExecutor taskExecutor() {

//        SimpleAsyncTaskExecutor asyncTaskExecutor=new SimpleAsyncTaskExecutor();
//        asyncTaskExecutor.setConcurrencyLimit(8);

        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setMaxPoolSize(2);
        taskExecutor.setCorePoolSize(2);
        taskExecutor.afterPropertiesSet();

        return taskExecutor;
    }

    @Bean
    public Step masterStep() {
        return stepBuilderFactory.get("masterSTep")
                . partitioner(slaveStep().getName(), partitioner())
                .step(slaveStep())
                .partitionHandler(partitionHandler())
//                .taskExecutor(taskExecutor())
                .build();
    }

    @Bean
    public Step slaveStep() {

        return stepBuilderFactory.get("slaveStep").<List,List>chunk(500)
                .reader(itemReader(0,0,""))
                . processor(itemProcessor())
                .writer(itemWriter())
                .build();
    }

    @Bean
    @StepScope
    public ItemReader<List> itemReader(@Value("#{stepExecutionContext['minValue']}") int min,@Value("#{stepExecutionContext['maxValue']}") int max,
                                               @Value("#{stepExecution['stepName']}") String partitionName) {

        return new ItemReader<List>() {

            boolean read=false;

            @Override
            public List<KprDto> read() throws SQLException {

                if(read)
                    return null;

               List<KprDto> list = commonRepository.getData(min,max,partitionName);
//                log.info(min+","+max);
//                list.add(CharMatcher.digit().retainFrom(partitionName));
//                JdbcTemplate template = new JdbcTemplate();
//                template.setDataSource(dataSource());
//                List<KprDto> kprDtoList = template.query("SELECT kr_production_report_id,bds_details.*,crew_details.*,other.*,post_kr_details.*,pouring_details.*,\n" +
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
//                list.addAll(kprDtoList);
                read=true;

                    return list;

            }
        };
    }

    @Bean
    public ItemProcessor<List, List> itemProcessor() {
        return new ItemProcessor<List,List>() {
            @Override
            public List process(List item) {
                return item;
            }
        };
    }

    @Bean
    public ItemWriter<List> itemWriter() {

        return new ItemWriter<List>() {

            @Override
            public void write(List<? extends List> list) throws Exception {

//                staticReportService.getNormalReport(list.get(0));
                String pdfName=list.get(0).get(0).toString();

                list.get(0).remove(0);

                JRBeanCollectionDataSource jrBeanCollectionDataSource =new JRBeanCollectionDataSource( new ArrayList<>( list.get(0) ),false);
                Map<String,Object> hashMap=new HashMap<>();
                hashMap.put("DataSourceCollection",jrBeanCollectionDataSource);
                JasperReport jasperReport= JasperCompileManager.compileReport("src/main/resources/Jpa_Report.jrxml");
                JasperPrint jasperPrint=JasperFillManager.fillReport(jasperReport,hashMap,new JREmptyDataSource());
                JasperExportManager.exportReportToPdfFile(jasperPrint,"D://BatchReports//"+pdfName+".pdf");
                System.out.println("Writer");
            }
        };
    }



}
