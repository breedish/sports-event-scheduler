package com.breedish.ses.config.db;

import com.zaxxer.hikari.HikariDataSource;
import net.ttddyy.dsproxy.support.ProxyDataSourceBuilder;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.concurrent.TimeUnit;

@Configuration
@EnableConfigurationProperties(DataSourceProperties.class)
public class DbConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    public DataSource dataSource(DataSourceProperties properties) {
        return ProxyDataSourceBuilder
            .create(properties.initializeDataSourceBuilder().type(HikariDataSource.class).build())
            .name("dataSource")
            .logQueryToSysOut()
            .logQueryBySlf4j()
            .logSlowQueryBySlf4j(1, TimeUnit.MINUTES)
            .asJson()
            .countQuery()
            .build();
    }
}
