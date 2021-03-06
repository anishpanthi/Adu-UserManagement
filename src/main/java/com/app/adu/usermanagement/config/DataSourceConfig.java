package com.app.adu.usermanagement.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Anish Panthi
 * <p>
 * 10/8/2017
 */
@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.app.adu.usermanagement.domain"})
@EnableJpaRepositories(basePackages = { "com.app.adu.usermanagement.repository" })
@EnableTransactionManagement
public class DataSourceConfig {
}
