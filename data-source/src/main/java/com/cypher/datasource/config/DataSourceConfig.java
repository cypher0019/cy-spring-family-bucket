package com.cypher.datasource.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Configuration
@Slf4j
public class DataSourceConfig {

    @Bean
    @ConfigurationProperties(value = "foo.datasource")
    public DataSourceProperties fooDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name = "fooDataSource")
    public DataSource fooDataSource() {
        DataSourceProperties fooDataSourceProperties = fooDataSourceProperties();
        log.info(fooDataSourceProperties.getDataUsername());
        return fooDataSourceProperties.initializeDataSourceBuilder().build();
    }

    @Bean
    @Resource
    public PlatformTransactionManager fooDataSourceTransactionManager(DataSource fooDataSource) {
        return new DataSourceTransactionManager(fooDataSource);
    }


    @Bean
    @ConfigurationProperties(value = "bar.datasource")
    public DataSourceProperties barDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name = "barDataSource")
    public DataSource barDataSource() {
        DataSourceProperties fooDataSourceProperties = barDataSourceProperties();
        log.info(fooDataSourceProperties.getDataUsername());
        return fooDataSourceProperties.initializeDataSourceBuilder().build();
    }

    @Bean
    @Resource
    public PlatformTransactionManager barDataSourceTransactionManager(DataSource barDataSource) {
        return new DataSourceTransactionManager(barDataSource);
    }

}
