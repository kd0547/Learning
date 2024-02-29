package org.example.batch.job;


import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.job.builder.SimpleJobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionManager;

import javax.sql.DataSource;
import java.util.Date;

@Configuration
public class SimpleJobConfig {


    @Bean
    public Job CreateJob(JobRepository jobRepository,PlatformTransactionManager platformTransactionManager)
    {
        JobBuilder jobBuilder =  new JobBuilder("test",jobRepository);

        return jobBuilder
                .start(step1(jobRepository,platformTransactionManager))
                .build();
    }

    @Bean
    public Step step1(JobRepository jobRepository, PlatformTransactionManager platformTransactionManager) {
        StepBuilder stepBuilder = new StepBuilder("step1",jobRepository);
        return stepBuilder.tasklet(new Tasklet() {
            @Override
            public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
                return RepeatStatus.FINISHED;
            }
        },platformTransactionManager).build();
    }




}
