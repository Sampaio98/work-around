package com.study.workaround;

import com.study.workaround.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class WorkAroundApplication {

    @Autowired
    private CityService cityService;

    public static void main(String[] args) {
        SpringApplication.run(WorkAroundApplication.class, args);
    }
}
