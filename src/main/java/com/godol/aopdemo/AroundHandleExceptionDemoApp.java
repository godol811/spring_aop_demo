package com.godol.aopdemo;

import com.godol.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class AroundHandleExceptionDemoApp {
    private static Logger myLogger = Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());

    public static void main(String[] args) {
        // 스프링 설정 클래스를 읽어 오기
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        // Bean으로 부터 스프링 컨테이너 가져오기
        TrafficFortuneService theTrafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

        myLogger.info("\nMain Program: 어라운드 데모앱 ");
        myLogger.info("포츈 가져오기");

        boolean tripWire = true;

        String data = theTrafficFortuneService.getFortune(tripWire);

        myLogger.info("\n내 운세는 : " + data);

        myLogger.info("종료");


        // 컨텍스트 닫기
        context.close();
    }
}
