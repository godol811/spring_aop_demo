package com.godol.aopdemo;

import com.godol.aopdemo.dao.AccountDAO;
import com.godol.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AroundDemoApp {

    public static void main(String[] args) {
        // 스프링 설정 클래스를 읽어 오기
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        // Bean으로 부터 스프링 컨테이너 가져오기
        TrafficFortuneService theTrafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

        System.out.println("\nMain Program: 어라운드 데모앱 ");
        System.out.println("포츈 가져오기");
        String data = theTrafficFortuneService.getFortune();

        System.out.println("\n내 운세는 : " + data);

        System.out.println("종료");


        // 컨텍스트 닫기
        context.close();
    }
}
