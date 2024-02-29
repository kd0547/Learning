### Job이란? 
배치 계층 구조에서 가장 상위에 있는 개념으로 하나의 배치 작업 자체를 의미합니다. 
예를 들어 "서버의 접속 로그를 백업 서버로 옮기는 작업"이 하나의 Job입니다.

Job의 종류로는 `SimpleJob`, `FlowJob`이 있고, 특징은 다음과 같습니다.
- SimpleJob
  - 순차적으로 Step을 실행
- FlowJob
  - 특정 조건과 흐름에 따라 Step을 실행 
  - Flow 객체를 실행시켜 작업을 진행



#### Job 생성
Job을 생성하는 클래스는 `JobBuilder` 입니다. `JobBuilderFactory는` 5.0.0 부터는 사용하지 않습니다. 
````java

/** @deprecated */
@Deprecated(
since = "5.0.0",
forRemoval = true
)
public class JobBuilderFactory {
    ...
}
````
<br>

##### job을 생성하는 JobBuilder
Job을 구성하는 설정 조건에 따라 두 개의 하위 빌더 클래스를 생성하고 실제 Job 생성을 위임합니다. 
`JobBuilder` 의 하위 클래스는 `SimpleJobBuilder`와 `FlowJobBuilder`가 있습니다.

````java
    public JobBuilder(String name, JobRepository jobRepository) {
        super(name, jobRepository);
    }
````

#### Job을 실행시키는 JobLauncher