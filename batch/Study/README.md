
#### JopRepository 
스프링 배치는 Job의 상태관리를 위해 `JobRepository`를 통해 **저장&관리**한다. 
보통은 `@EnableBatchProcessing`을 사용하면 스프링이 생성해주지만, **두 개 이상의 DataBase가 있는 경우** 커스터마이징해 사용하게 된다. 

````java
@EnableBatchProcessing //배치 기능 활성화
@SpringBootApplication
public class BatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(BatchApplication.class, args);
	}

}
````



<br>

#### JopRepository생성
`JobRepository`는 `JopRepositoryFactoryBean` 가 생성하는데,
````java
@Bean
public JobRepository jobRepository() throws Exception {
    JobRepositoryFactoryBean factory = new JobRepositoryFactoryBean();
    factory.setDataSource(dataSource);
    factory.setDatabaseType("db2");
    factory.setTransactionManager(transactionManager);
    return factory.getObject();
}
````

