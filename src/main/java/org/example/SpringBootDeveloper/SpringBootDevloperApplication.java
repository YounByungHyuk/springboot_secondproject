package org.example.SpringBootDeveloper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// 스프링부트 설정 파일을 빈으로 등록하고 자둥구성을 활성화
public class SpringBootDevloperApplication {
    //자바의 메인메서드 개념
    public static void main(String[] args) {
        SpringApplication.run(SpringBootDevloperApplication.class,args);
        // 스프링 어플리케이션을 실행하는 코드
    }

}
