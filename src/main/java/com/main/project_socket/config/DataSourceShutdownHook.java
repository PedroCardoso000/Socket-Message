package com.main.project_socket.config;

import com.zaxxer.hikari.HikariDataSource;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class DataSourceShutdownHook {

    @Autowired
    private DataSource dataSource;

    @PreDestroy
    public void closeDataSource() {
        if (dataSource instanceof HikariDataSource hikariDataSource) {
            System.out.println("Fechando pool de conexões Hikari...");
            hikariDataSource.close();
            System.out.println("Pool de conexões fechado com sucesso.");
        }
    }
}