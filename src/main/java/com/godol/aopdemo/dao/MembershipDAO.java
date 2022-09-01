package com.godol.aopdemo.dao;


import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

    public boolean addSillyAccount(){
        System.out.println(getClass() + " : 뭔짓을 하는 구만: 멤버쉽 어카운트 추가"); return true;
    }
    public void goToSleep(){
        System.out.println(getClass() + " : 쳐 주무세요");
    }

}
