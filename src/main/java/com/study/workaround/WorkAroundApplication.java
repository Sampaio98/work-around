package com.study.workaround;

import com.study.workaround.domain.model.Person;
import com.study.workaround.domain.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

@SpringBootApplication
@EnableFeignClients
public class WorkAroundApplication implements CommandLineRunner {

    @Autowired
    private PersonRepository personRepository;

    public static void main(String[] args) {
        SpringApplication.run(WorkAroundApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Person p = Person.builder()
                .name("Brian")
                .email("brianoconner@gmail.com")
                .cellphone(new HashSet<>(Collections.singletonList("43 9999-9999")))
                .build();

        Person p2 = Person.builder()
                .name("Brian")
                .email("brianspilner@gmail.com")
                .cellphone(new HashSet<>(Collections.singletonList("43 7777-7777")))
                .build();

        Person p3 = Person.builder()
                .name("Paulo Walter")
                .email("paulowalter@gmail.com")
                .cellphone(new HashSet<>(Collections.singletonList("43 8888-8888")))
                .build();

        personRepository.saveAll(Arrays.asList(p, p2, p3));

    }
}
