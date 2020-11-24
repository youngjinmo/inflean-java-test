package com;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class) // underscore -> blank
class StudyTest {

    @Test
    @DisplayName("테스트1")
    void create(){

        // Study 클래스에서 입력한 IllegalArgumentException 을 테스트
        assertThrows(IllegalArgumentException.class, ()-> new Study(20));

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