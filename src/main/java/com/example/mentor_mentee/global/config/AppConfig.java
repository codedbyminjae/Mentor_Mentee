package com.example.mentor_mentee.global.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public String appName() {
        return "MentorMentee";
    }

    @Bean
    public String myName() {
        return "MinJae";
    }

    // 해당 부분은 정수형이기에 출력 x
    @Bean
    public Integer myAge() {
        return 24;
    }
}
