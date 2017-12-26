package com.hainet.spring.boot.hikaricp.sample;

import com.hainet.spring.boot.hikaricp.sample.domain.dao.SessionDao;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
@RequiredArgsConstructor
public class SpringBootHikaricpSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootHikaricpSampleApplication.class, args);
    }

    private final SessionDao dao;

    @Scheduled(fixedDelay = 5_000)
    public void test() {
        System.out.println(dao.findAll());
    }
}
