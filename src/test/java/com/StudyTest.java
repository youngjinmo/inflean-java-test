package com;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTimeout;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class) // underscore -> blank
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class StudyTest {

    @FastTest
    @DisplayName("fast custom tag 테스트")
    void custom_tag_test(){
        System.out.println("Fast Custom Tag Test");
    }

    @DisplayName("Hello Repeated Test")
    @RepeatedTest(value = 10, name = "{displayName}, {currentRepetition}/{totalRepetitions}")
    void repeatTest(RepetitionInfo repetitionInfo){
        System.out.println("test : "+repetitionInfo.getCurrentRepetition()+" of "
                        +repetitionInfo.getTotalRepetitions());
    }

    // 테스트 실패 -> 이유모름..
//    @DisplayName("파라미터를 다르게 주는 반복 테스트")
//    @ParameterizedTest(name = "{index}, {displayName}, weather={0}")
//    @ValueSource(strings = {"봄","여름","가을","겨울"})
//    void parameterizedTests(String weather){
//        System.out.println("현 계절은 "+weather+" 입니다.");
//    }

    @Test
    @DisplayName("Tag 기능 테스트")
    @Tag("qa")
    void create_tag_test(){
        System.out.println("Tag Test");
    }

    @Test
    @DisplayName("TimeOut 테스트")
    @DisabledOnOs({OS.LINUX, OS.MAC})
    @EnabledOnJre({JRE.JAVA_8,JRE.JAVA_9,JRE.JAVA_10,JRE.JAVA_11})
    @DisabledOnJre({JRE.JAVA_14})
    void create_timeout_test(){
        // 100 milli 동안 assert, 만약 이를 넘어가면 테스트 실패.
        assertTimeout(Duration.ofMillis(100),() -> {
            new Study(10);
            System.out.println("Timeout 테스트");
            Thread.sleep(60);
        });
    }

    @Test
    @DisplayName("테스트2")
    @Order(2)
    void create2(){
        System.out.println("create2");
    }

    @Test
    @DisplayName("테스트1")
    @Order(1)
    void create1(){
        System.out.println("create1");
    }

    @BeforeAll
    void beforeAll(){
        System.out.println("통합 테스트 시작 전");
    }

    @AfterAll
    void afterAll(){
        System.out.println("통합 테스트 끝");
    }

    @BeforeEach
    void beforeEach(){
        System.out.println("단위 테스트 실행 전");
    }

    @AfterEach
    void afterEach(){
        System.out.println("단위 테스트 실행 후");
    }
}