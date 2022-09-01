package com.godol.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoveAopExpressions {

    @Pointcut("execution(* com.godol.aopdemo.dao.*.*(..))")
    public void forDaoPackage(){}
    @Pointcut("execution(* com.godol.aopdemo.dao.*.get*(..))")
    public void getter(){}
    @Pointcut("execution(* com.godol.aopdemo.dao.*.set*(..))")
    public void setter(){}
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter(){}
}
