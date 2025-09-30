package com.example.mentor_mentee;

import com.example.mentor_mentee.global.config.AppConfig;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Getter
public class App {

    private final String appName;

    @Autowired
    public App(String appName) {
        this.appName = appName;
    }

    public static void main(String[] args) {
        // 스프링 컨테이너를 불러오는데, AppConfig와 App 클래스에 대해 등록하는 컨테이너 불러오기
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class, App.class);

        App app = ac.getBean(App.class);
        System.out.println(app.getAppName());
        
        // String type 으로 등록된 모든 Bean 조회
        Map<String, String> beansOfType = ac.getBeansOfType(String.class);
        for (String key : beansOfType.keySet()) {
            System.out.println("key = " + key + ", bean = " +beansOfType.get(key));
        }

    }
}
