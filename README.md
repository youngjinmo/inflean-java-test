- **[Junit5](https://junit.org/junit5/docs/current/user-guide/#writing-tests-annotations)**
- `@Test`
   - 테스트 대상 메서드 어노테이션
  
 - `@BeforeAll`
     - 전체 테스트가 실행되기 전 실행되는 메서드
    - `static` 키워드 또는 `@TestInstance`가 필요하다.
  
 - `@AfterAll`
     - 전체 테스트가 실행된 후 실행되는 메서드
    - `static` 키워드 또는 `@TestInstance`가 필요하다.
  
 - `@BeforeEach`
     - 단위 테스트 전 실행 메서드
  
 - `@AfterEach`
     - 단위 테스트 후 실행 메서드
  
 - `@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)`
     - underscore를 빈칸으로 변환해주는 어노테이션
     - 테스트 클래스 위에 한 번만 작성한다.
  
 - `@DisplayName`
   - 테스트 메서드의 이름을 콘솔에서 출력할때 사용하는 이름
  
- **[Junit Assertions](https://junit.org/junit5/docs/current/user-guide/#writing-tests-assertions)**

  - `import static org.junit.jupiter.api.Assertions.*`
   - Assert에서 에러 발생하면, 다음 Assertion으로 넘아가지 않음.

   - Assertions 관련 서드파티 라이브러리

      - [AssertJ](https://assertj.github.io/doc/)

   - `assertNotNull()`
     - 값이 null이 아닌지 확인

   - `assertEquals()`

     - 실제 값이 기대한 값과 같은지 확인

![assertEquals](\src\main\resources\static\img\assertEquals.JPG)

![lambda식으로 메세지 작성한 모습](\src\main\resources\static\img\lambda-message.JPG)

- `assertTrue()`
   - 조건이 True인지 확인
- `assertAll()` 
   - Assertions 테스트 코드는 **assertAll()** 안에 넣어서 한 번에 테스트 가능. 

![AssertAll](\src\main\resources\static\img\assertAll.JPG)

- `assertThrows(expectedType, executable)`  	
   - 특정 시간안에 실행이 완료되는지 확인

- `assertTimeout(duration, executable)` 
  - 특정 시간안에 실행이 완료되는지 확인
- `assertTimeoutPreemtively()` 
  - 테스트가 타임아웃이 발생하면 바로 종료하는 테스트 메서드
  - `assertTimeoutPreemtively()` 는 ThreadLocal을 사용하므로 예상하지 못한 상황이 발생할 수 있음. 유의해서 사용 필요.

![Timeout](\src\main\resources\static\img\timeout.JPG)



- **[조건에 따라 테스트 실행하는 어노테이션](https://junit.org/junit5/docs/current/user-guide/#writing-tests-conditional-execution)**

  - 운영체제
     - `@DisabledOnOs(OS.WINDOWS) `
       - 테스트 환경이 Window일 경우에는 disabled.
      - `@EnabledOnOs({OS.LINUX, OS.MAC})` 
        - 테스트 환경이 리눅스, Mac이면 enabled.

   - JRE

     - `@EnabledOnJre({JRE.JAVA_8, JRE.JAVA_9})` 
       - JAVA 8, JAVA 9에서만 테스트 실행

      - `@DisabledOnJre({JRE.JAVA_14})`
        - JAVA 14에서는 테스트 미실행

   - 환경변수

     - `@EnabledIfEnvironmentVariable(named="TEST_ENV", matches = "LOCAL") `
     - 로컬 환경변수의 TEST_ENV 가 LOCAL일 때 실행.



- **[Tag를 이용한 Filtering](https://junit.org/junit5/docs/current/user-guide/#writing-tests-tagging-and-filtering)**
- `@Tag` 
     - IDE에서 configuration를 수정하여 태그 어노테이션으로 실행할 테스트 메서드 지정 가능

![](\src\main\resources\static\img\tag.JPG)



- **[테스트 실행 순서 정의](https://junit.org/junit5/docs/current/user-guide/#writing-tests-test-execution-order)**
- `@TestMethodOrder(MethodOrderer.OrderAnnotation.class)`
     - 테스트 클래스 상단에 어노테이션 맵핑을 한다.
     - Method에 Order 어노테이션을 추가하여 테스트 메서드를 순서정의하겠다는 어노테이션.
   - `@Order()` 
     - 숫자를 넣어서 실행될 테스트 메서드 순서를 결정할 수 있다.

![order](\src\main\resources\static\img\order.JPG)



- **[Test Instance](https://junit.org/junit5/docs/current/user-guide/#writing-tests-test-instance-lifecycle)**
   - 라이프 사이클의 단위(class/method)를 설정할 수 있다.
   - `@TestInstance(TestInstance.Lifecycle.PER_CLASS)`
      - `PER_CLASS` : 클래스 단위로 인스턴스 생성
   - `@TestInstance(TestInstance.Lifecycle.PER_METHOD)`
      - `PER_METHOD` : 메서드 단위로 인스턴스 생성
   - `@BeforeAll`, `@AfterAll` 과 같이 `static` 키워드가 필요한 메서드들도 `static` 키워드가 필요없게 된다.



- Junit Platform Properties
   - 경로(`src\test\resources`)에 Junit 설정파일을 만들 수 있다.
   - IDE에서 이를 JUnit Resource로 인식하도록 인텔리J에서 설정이 필요하다.
      - [File] - [Project Structure] - [Modules] - [Test Resources]

![junit-platform](\src\main\resources\static\img\junit-platform.JPG)