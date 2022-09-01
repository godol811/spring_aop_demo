package com.godol.aopdemo.dao;


import com.godol.aopdemo.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {

    private String name;
    private String service;

    public List<Account> findAccounts(boolean tripWire){
        // 가짜 exception 만들기
        if (tripWire){
            throw new RuntimeException("No soup for you!!!");
        }

        List<Account> myAccounts = new ArrayList<Account>();

        Account temp1 = new Account("John", "silver");
        Account temp2 = new Account("godol", "diamone");
        Account temp3 = new Account("noob", "bronze");

        myAccounts.add(temp1);
        myAccounts.add(temp2);
        myAccounts.add(temp3);

        return myAccounts;
    }


    public String getName() {
        System.out.println(getClass() + " : getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + " : setName()");
        this.name = name;
    }
    public String getService() {
        System.out.println(getClass() + " : getService()");
        return service;
    }

    public void setService(String service) {
        System.out.println(getClass() + " : setService()");
        this.service = service;
    }


    public void addAccount(Account theAccount, boolean vipFlag){
        System.out.println(getClass()+ " : 데이터베이스 일해요 : 계정을 추가하는중");
    }
    public boolean doWork(){
        System.out.println(getClass() + " : 일해라 닝겐아 메서드");
        return true;
    }

}
