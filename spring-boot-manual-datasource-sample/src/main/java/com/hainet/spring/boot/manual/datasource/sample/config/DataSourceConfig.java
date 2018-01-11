package com.hainet.spring.boot.manual.datasource.sample.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean
    @Primary
    @ConfigurationProperties("datasource.primary")
    public DataSource primary() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties("datasource.secondary")
    public DataSource secondary() {
        return DataSourceBuilder.create().build();
    }
}
