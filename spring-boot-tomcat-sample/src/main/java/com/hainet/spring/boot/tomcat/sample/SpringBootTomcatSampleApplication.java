package com.hainet.spring.boot.tomcat.sample;

import com.hainet.spring.boot.tomcat.sample.domain.dao.SessionDao;
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
public class SpringBootTomcatSampleApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootTomcatSampleApplication.class, args);
    }

    private final DataSource dataSource;
    private final SessionDao dao;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(dataSource);
    }

    @Scheduled(fixedDelay = 3_000)
    public void tomcat() {
        System.out.println(dao.findAll());
    }
}
