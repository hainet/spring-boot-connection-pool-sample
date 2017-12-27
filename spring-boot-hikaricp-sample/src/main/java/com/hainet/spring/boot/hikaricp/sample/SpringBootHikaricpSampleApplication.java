package com.hainet.spring.boot.hikaricp.sample;

import com.hainet.spring.boot.hikaricp.sample.domain.dao.SessionDao;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.sql.DataSource;

@SpringBootApplication
@EnableScheduling
@RequiredArgsConstructor
public class SpringBootHikaricpSampleApplication implements CommandLineRunner {

    public static void main(final String[] args) {
        SpringApplication.run(SpringBootHikaricpSampleApplication.class, args);
    }

    private final DataSource dataSource;
    private final SessionDao dao;

    @Override
    public void run(final String... args) {
        System.out.println(dataSource);
    }

    @Scheduled(fixedDelay = 3_000)
    public void hikaricp() {
        System.out.println(dao.findAll());
    }
}
