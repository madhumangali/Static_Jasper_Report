package com.jasper_reports.thread;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;

public class MultiThread implements Runnable{

    public static Job job;

    public static JobLauncher jobLauncher;

    public static long max;

    public static long min;

    @Override
    public void run() {

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



    }


}
