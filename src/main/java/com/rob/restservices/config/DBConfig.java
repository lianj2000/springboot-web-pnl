package com.rob.restservices.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DBConfig {

	@Bean
	@ConfigurationProperties("app.datasource.oracle")
	public HikariDataSource oracleDataSource() {
	    return (HikariDataSource) DataSourceBuilder.create()
	            .type(HikariDataSource.class).build();
	}
	
	@Autowired
	@Bean 
	public JdbcTemplate oracleTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
}
