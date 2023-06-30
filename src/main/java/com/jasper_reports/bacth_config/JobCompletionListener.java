package com.jasper_reports.bacth_config;

import com.sun.source.util.TaskListener;
import lombok.extern.log4j.Log4j2;
import org.springframework.batch.core.*;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.batch.core.partition.support.TaskExecutorPartitionHandler;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.task.TaskExecutorCustomizer;
import org.springframework.core.task.TaskDecorator;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@Log4j2
public class JobCompletionListener implements JobExecutionListener,StepExecutionListener {

    static int inc;



    @Override
    public void afterJob(JobExecution jobExecution) {
        jobExecution.setExitStatus(ExitStatus.STOPPED);
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            System.out.println("BATCH JOB COMPLETED SUCCESSFULLY");
        }
//
    }

    @Override
    public void beforeJob(JobExecution jobExecution) {
        String jobName = jobExecution.getJobInstance().getJobName();
//        Reader.min=jobExecution.getJobParameters().getLong("min").intValue();
//        Reader.max=jobExecution.getJobParameters().getLong("max").intValue();
        CustomizedPartitioner.min=jobExecution.getJobParameters().getLong("min").intValue();
        CustomizedPartitioner.max=jobExecution.getJobParameters().getLong("max").intValue();
        ExecutionContext executionContext= jobExecution.getExecutionContext();
//        System.out.println( executionContext.get());
//        Random random=new Random();
//        System.out.println(random.nextInt());
//        Reader.read= Boolean.parseBoolean(jobExecution.getJobParameters().getString("read"));
//        Writer.min=jobExecution.getExecutionContext().getInt("minValue");
//        Writer.max= jobExecution.getExecutionContext().getInt("maxValue");
//        Writer.jobId=  jobExecution.getJobId();
    }


    @Override
    public void beforeStep(StepExecution stepExecution) {

        log.info(stepExecution.getStepName());
//        SpringBatchConfig.minValuesList.add(stepExecution.getExecutionContext().getInt("minValue")) ;
//        SpringBatchConfig.maxValuesList.add( stepExecution.getExecutionContext().getInt("maxValue") );
//        System.out.println(stepExecution.getExecutionContext().getInt("minValue"));
//        System.out.println(stepExecution.getExecutionContext().getInt("maxValue"));
//        System.out.println( SpringBatchConfig.minValuesList[inc]+","+SpringBatchConfig.maxValuesList[inc]);
//        System.out.println(SpringBatchConfig.maxValuesList[inc]);
//        System.out.println("------------->"+inc);
        inc=inc+1;


    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        System.out.println("------------->");
        return null;
    }


}
