package com;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;

import java.time.Duration;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class) // underscore -> blank
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudyTest {

    @Test
    @DisplayName("Tag 기능 테스트")
    @Tag("qa")
    void create_tag_test(){
        System.out.println("Tag Test");
    }

    @Test
    @DisplayName("조건 테스트")
    @DisabledOnOs(OS.WINDOWS)
    void create_conditional_test(){
        String test_env = System.getenv("TEST_ENV");
        System.out.println(System.getenv("TEST_ENV"));

        assumeTrue("LOCAL".equalsIgnoreCase(test_env));

        assumingThat("LOCAL".equalsIgnoreCase(test_env), ()->{
            System.out.println("local");
            Study actual = new Study(15);
        });
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
    @DisplayName("테스트1")
    @Order(1)
    void create(){

        // Study 클래스에서 입력한 IllegalArgumentException 을 테스트
        assertThrows(IllegalArgumentException.class, ()-> new Study(-10));

        Study study = new Study(-10);

        assertAll(
                ()-> assertNotNull(study),
                ()-> assertEquals(StudyStatus.DRAFT,study.getStatus(),
                        ()->"study 객체 처음 만들면, "+StudyStatus.DRAFT+" 상태여야한다."),
                ()-> assertTrue(study.getLimit()>0,"limit은 0보다 커야한다.")
        );
    }

    @Test
    @DisplayName("테스트2")
    @Order(2)
    void create1(){
        System.out.println("create1");
    }

    @BeforeAll
    static void beforeAll(){
        System.out.println("통합 테스트 시작 전");
    }

    @AfterAll
    static void afterAll(){
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