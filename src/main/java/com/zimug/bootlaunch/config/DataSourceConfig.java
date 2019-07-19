package com.zimug.bootlaunch.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean(initMethod="init", destroyMethod="close", name="primaryDataSource")
    @Primary
    @ConfigurationProperties(prefix = "primarydb")
    public DataSource primaryDataSource() {
        return new AtomikosDataSourceBean();
    }

    //jta数据源1
    @Bean(initMethod="init", destroyMethod="close", name="secondaryDataSource")
    @ConfigurationProperties(prefix = "secondarydb")
    public DataSource secondaryDataSource()  {
        return new AtomikosDataSourceBean();
    }

    @Bean
    public JdbcTemplate primaryJdbcTemplate(@Qualifier("primaryDataSource") DataSource primaryDataSource) {
        return new JdbcTemplate(primaryDataSource);
    }

    @Bean
    public JdbcTemplate secondaryJdbcTemplate(@Qualifier("secondaryDataSource") DataSource secondaryDataSource) {
        return new JdbcTemplate(secondaryDataSource);
    }
}