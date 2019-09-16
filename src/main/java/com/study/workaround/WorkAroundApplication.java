package com.study.workaround;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class WorkAroundApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkAroundApplication.class, args);
	}

}
