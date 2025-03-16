package com.esprit.microservice.ms_job_board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class MsJobBoardApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsJobBoardApplication.class, args);
	}
	@Autowired
	private JobRepository jobRepository;
	@Bean
	ApplicationRunner init() {
		return (args) -> {
			// save
			jobRepository.save(new Job("Service Financier", true));
			jobRepository.save(new Job("Service Info", false));
			jobRepository.save(new Job("Service RH", false));
			// fetch
			jobRepository.findAll().forEach(System.out::println);
		};
	}
}
