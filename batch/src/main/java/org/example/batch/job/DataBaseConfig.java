package org.example.batch.job;

import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
public class DataBaseConfig {

    private static final String URL = "jdbc:mysql://localhost:3306/chess";
    private static final String USER = "study";
    private static final String PASSWORD = "1234";

    @Bean
    public void create()
    {
        JobRepositoryFactoryBean jobBuilderFactory = new JobRepositoryFactoryBean();
    }

}
