package com.godol.aopdemo;

import com.godol.aopdemo.dao.AccountDAO;
import com.godol.aopdemo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {

    public static void main(String[] args) {
        // 스프링 설정 클래스를 읽어 오기
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        // Bean으로 부터 스프링 컨테이너 가져오기
        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
        MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
        // 비즈니스 메소드를 불러오기
        Account myAccount = new Account();
        myAccount.setName("고돌");
        myAccount.setLevel("Diamond");
        theAccountDAO.addAccount(myAccount, true);
        theAccountDAO.doWork();

        // 게터 세터 메소드 불러 오기R
        theAccountDAO.setName("똥바");
        theAccountDAO.setService("은색");
        String name = theAccountDAO.getName();
        String code = theAccountDAO.getService();


        theMembershipDAO.goToSleep();
        theMembershipDAO.addSillyAccount();



        // 컨텍스트 닫기
        context.close();
    }
}
