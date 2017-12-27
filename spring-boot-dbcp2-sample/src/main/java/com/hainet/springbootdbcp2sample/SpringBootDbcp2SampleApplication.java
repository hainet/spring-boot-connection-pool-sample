package com.hainet.springbootdbcp2sample;

import com.hainet.springbootdbcp2sample.domain.dao.SessionDao;
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
public class SpringBootDbcp2SampleApplication implements CommandLineRunner {

    public static void main(final String[] args) {
        SpringApplication.run(SpringBootDbcp2SampleApplication.class, args);
    }

    private final DataSource dataSource;
    private final SessionDao dao;

    @Override
    public void run(final String... args) {
        System.out.println(dataSource);
    }

    @Scheduled(fixedDelay = 3_000)
    public void dbcp2() {
        System.out.println(dao.findAll());
    }
}
