package com.jasper_reports;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class StaticReportsApplication {

	public static void main(String[] args) {
		SpringApplication.run(StaticReportsApplication.class, args);
	}

}
