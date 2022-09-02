package com.godol.aopdemo.service;

import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;


@Component
public class TrafficFortuneService {
    public String getFortune(){
        // 딜레이 만들어 보기
        try{
        TimeUnit.SECONDS.sleep(5);

        }catch (InterruptedException e){
            e.printStackTrace();
        }
        // 포츈 가져오기
        return "오늘 아침에 많은 교통체증이 있을 예정입니다.";

    }

    public String getFortune(boolean tripWire) {
        if (tripWire){
            throw new RuntimeException("주요 문제가 발생했습니다. 고속도로가 막혔어요!");
        }
        return getFortune();
    }
}
