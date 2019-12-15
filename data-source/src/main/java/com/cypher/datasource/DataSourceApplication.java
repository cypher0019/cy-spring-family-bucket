package com.cypher.datasource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class, JdbcTemplateAutoConfiguration.class})
@Slf4j
public class DataSourceApplication implements CommandLineRunner {

    @Resource(name = "fooDataSource")
    private DataSource fooDatasource;

    public static void main(String[] args) {
        SpringApplication.run(DataSourceApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        showConnection();
    }

    private void showConnection() {
        try {
            log.info(fooDatasource.toString());
            Connection conn = fooDatasource.getConnection();
            log.info(conn.toString());
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
