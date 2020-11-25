# JUnit5

## <a name="annotations"></a>[Annotations](https://junit.org/junit5/docs/current/user-guide/#writing-tests-annotations)

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


<br>

## <a name="assertions"></a>[JUnit Assertions](https://junit.org/junit5/docs/current/user-guide/#writing-tests-assertions)

- `import static org.junit.jupiter.api.Assertions.*`
 - Assert에서 에러 발생하면, 다음 Assertion으로 넘아가지 않음.

 - Assertions 관련 서드파티 라이브러리

    - [AssertJ](https://assertj.github.io/doc/)

 - `assertNotNull()`
   - 값이 null이 아닌지 확인

 - `assertEquals()`
- 실제 값이 기대한 값과 같은지 확인

![assertEquals](https://github.com/youngjinmo/inflean-java-test/blob/main/src/main/resources/static/img/assertEquals.JPG?raw=true)

![lambda식으로 메세지 작성한 모습](https://github.com/youngjinmo/inflean-java-test/blob/main/src/main/resources/static/img/lambda-message.JPG?raw=true)

- `assertTrue()`
   - 조건이 True인지 확인
- `assertAll()` 
   - Assertions 테스트 코드는 **assertAll()** 안에 넣어서 한 번에 테스트 가능. 

![AssertAll](https://github.com/youngjinmo/inflean-java-test/blob/main/src/main/resources/static/img/assertAll.JPG?raw=true)

- `assertThrows(expectedType, executable)`  	
   - 특정 시간안에 실행이 완료되는지 확인

- `assertTimeout(duration, executable)` 
  - 특정 시간안에 실행이 완료되는지 확인
- `assertTimeoutPreemtively()` 
  - 테스트가 타임아웃이 발생하면 바로 종료하는 테스트 메서드
  - `assertTimeoutPreemtively()` 는 ThreadLocal을 사용하므로 예상하지 못한 상황이 발생할 수 있음. 유의해서 사용 필요.

![Timeout](https://github.com/youngjinmo/inflean-java-test/blob/main/src/main/resources/static/img/timeout.JPG?raw=true)

<br>

## <a name="conditional-test"></a>[조건에 따라 테스트 실행하기](https://junit.org/junit5/docs/current/user-guide/#writing-tests-conditional-execution)

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

<br>

## <a name="tag"></a>[Tag 이용한 필터링](https://junit.org/junit5/docs/current/user-guide/#writing-tests-tagging-and-filtering)

- `@Tag` 
     - IDE에서 configuration를 수정하여 태그 어노테이션으로 실행할 테스트 메서드 지정 가능

![](https://github.com/youngjinmo/inflean-java-test/blob/main/src/main/resources/static/img/tag.JPG?raw=true)

<br>

## <a name="order"></a>[Order 이용한 순서정의](https://junit.org/junit5/docs/current/user-guide/#writing-tests-test-execution-order)

- `@TestMethodOrder(MethodOrderer.OrderAnnotation.class)`
     - 테스트 클래스 상단에 어노테이션 맵핑을 한다.
     - Method에 Order 어노테이션을 추가하여 테스트 메서드를 순서정의하겠다는 어노테이션.
   - `@Order()` 
     - 숫자를 넣어서 실행될 테스트 메서드 순서를 결정할 수 있다.

![order](https://github.com/youngjinmo/inflean-java-test/blob/main/src/main/resources/static/img/order.JPG?raw=true\src\main\resources\static\img\order.JPG)

<br>

## <a name="test-instance"></a>[Test Instance](https://junit.org/junit5/docs/current/user-guide/#writing-tests-test-instance-lifecycle)

- 라이프 사이클의 단위(class/method)를 설정할 수 있다.
- `@TestInstance(TestInstance.Lifecycle.PER_CLASS)`
   - `PER_CLASS` : 클래스 단위로 인스턴스 생성
- `@TestInstance(TestInstance.Lifecycle.PER_METHOD)`
   - `PER_METHOD` : 메서드 단위로 인스턴스 생성
- `@BeforeAll`, `@AfterAll` 과 같이 `static` 키워드가 필요한 메서드들도 `static` 키워드가 필요없게 된다.

<br>

## <a name="junit-properties"></a>[JUnit Properties]()

- 경로(`src\test\resources`)에 Junit 설정파일을 만들 수 있다.
- IDE에서 이를 JUnit Resource로 인식하도록 인텔리J에서 설정이 필요하다.
   - [File] - [Project Structure] - [Modules] - [Test Resources]

![junit-platform](https://github.com/youngjinmo/inflean-java-test/blob/main/src/main/resources/static/img/junit-platform.JPG?raw=true)

<br>

## <a name="custom-tag"></a>Custom Tag

[태그](#tag)를 할 수도 있지만, 자동완성기능을 이용한 어노테이션으로 커스텀 태그를 만들어서 사용할 수도 있다. 이렇게 하면 테스트 코드를 작성하는 과정에서 오타를 내서 실수를 할 일을 없앨 수 있다.

먼저 테스트 클래스와 같은 디렉토리에 인터페이스를 만든다.

**FastTest.java**

~~~java
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Test
@Tag("fast")
public @interface FastTest {
}
~~~

위의 인터페이스는 `FastTest` 라는 이름의 커스텀 태그를 만들어낼 수 있다. 또 기존에 사용하던 `fast` 라는 이름의 Tag를 대신하는 커스텀 태그이다.

![](https://user-images.githubusercontent.com/33862991/100174622-1f893500-2f10-11eb-81d0-34ddb2240373.JPG)

테스트 클래스로 돌아가서 방금 만든 인터페이스의 커스텀태그를 사용할 수 있게되었다.

![](https://user-images.githubusercontent.com/33862991/100174849-9c1c1380-2f10-11eb-9c63-32e93f50c2d8.JPG)

<br>

## <a name="repeated-test"></a>[Repeated Test](https://junit.org/junit5/docs/current/user-guide/#writing-tests-repeated-tests)

테스트를 반복할 때 사용하는 어노테이션이다.

~~~java
@RepeatedTest(10)
void repeatTest(RepetitionInfo repetitionInfo){
   System.out.println("test : "+repetitionInfo.getCurrentRepetition()+" of "
         +repetitionInfo.getTotalRepetitions());
}
~~~

`@RepeatedTest()` 에 인자값으로 숫자를 넣으면 해당 숫자만큼 테스트가 반복된다. 테스트가 진행되는동안 반복횟수를 콘솔에 띄워서 확인하고 싶다면, `RepetitionInfo` 객체의 인스턴스를 테스트 메서드의 인자값으로 받아서 띄워보면 된다.

`getTotalRepetition()` : 전체 횟수를 의미한다. `@RepeatedTest()` 에 넣은 인자값이 여기에서 출력된다.

`getCurrentRepetitions()` : 전체 반복 횟수중 현재 몇번째 loop인지를 알려준다.

아래는 반복 테스트 결과이다.

![](https://user-images.githubusercontent.com/33862991/100176279-5280f800-2f13-11eb-8470-51bf09c50937.JPG)

<br>

반복횟수를 보여주는 다른 방법도 있다.

`@RepeatedTest` 안에 속성으로 테스트의 이름과 반복횟수 등을 출력할 수도 있다.

```java
@DisplayName("Hello Test")
@RepeatedTest(value = 10, name = "{displayName}, {currentRepetition}/{totalRepetitions}")
void repeatTest(RepetitionInfo repetitionInfo){
   System.out.println("test : "+repetitionInfo.getCurrentRepetition()+" of "
         +repetitionInfo.getTotalRepetitions());
}
```

테스트 결과이다. 이게 더 깔끔해보인다.

![](https://user-images.githubusercontent.com/33862991/100177612-befcf680-2f15-11eb-9cb4-39fdd540420e.JPG)

<br>

## <a name="parameterized-test"></a>Parameterized Test

테스트를 반복할 때마다 파라미터를 바꿔주는 어노테이션이다.

