package com.dxc.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan("com.dxc")
@PropertySource("classpath:database.properties")
public class AppConfig {

	@Autowired
	Environment environment;
	
	private final String URL = "url";
	private final String USER = "dbuser";
	private final String DRIVER = "driver";
	private String PASSWORD = "dbpassword";
	
	@Bean
	DataSource dataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		
		driverManagerDataSource.setUrl(environment.getProperty(URL));
		driverManagerDataSource.setDriverClassName(environment.getProperty(DRIVER));
		driverManagerDataSource.setUsername(environment.getProperty(USER));
		driverManagerDataSource.setPassword(environment.getProperty(PASSWORD));
		
		return driverManagerDataSource;
	}
}
