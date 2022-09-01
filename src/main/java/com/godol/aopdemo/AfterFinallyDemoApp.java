package com.godol.aopdemo;

import com.godol.aopdemo.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterFinallyDemoApp {

    public static void main(String[] args) {
        // 스프링 설정 클래스를 읽어 오기
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        // Bean으로 부터 스프링 컨테이너 가져오기
        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
        // 계정 찾는 메서드 불러오기
        List<Account> theAccounts = null;

        try {
            boolean tripWire = true;
            theAccountDAO.findAccounts(tripWire);
        }catch (Exception exc){
            System.out.println("\n\nMain Program ... caught exception : " + exc);
        }

        // 화면에 띄우기
        System.out.println("\n\nMain Program: AfterThrowingDemoApp");
        System.out.println("------");

        System.out.println(theAccounts);
        System.out.println("------");


        // 컨텍스트 닫기
        context.close();
    }
}
