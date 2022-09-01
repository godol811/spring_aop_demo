package com.godol.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyApiAnalyticsAspect {
    @Before("com.godol.aopdemo.aspect.LoveAopExpressions.forDaoPackageNoGetterSetter()")
    public void performApiAnalytics(){
        System.out.println("\n=========>> API 애널 작동중");
    }

}
