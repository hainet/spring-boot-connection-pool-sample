package com.hainet.spring.boot.manual.datasource.sample.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataSourceConfigTest {

    @Autowired
    @Qualifier("primary")
    private DataSource primary;

    @Autowired
    @Qualifier("secondary")
    private DataSource secondary;

    @Test
    public void primaryTest() {
        assertThat(primary.toString(), is(containsString("maxActive=1")));
    }

    @Test
    public void secondaryTest() {
        assertThat(secondary.toString(), is(containsString("maxActive=2")));
    }
}
