package com.godol.aopdemo.aspect;

import com.godol.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.hibernate.annotations.SelectBeforeUpdate;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
    /** @PointCut 써보기
     1. 재활용을 할 수 있기에 PointCut을 사용해서 @Before에서 받을 수 있게 설정 할 수 있다
     2. Pointcut을 통해 Before이 if 문처럼 사용할 수 있게된다. @Pointcut("forDaoPackage() && !(getter() || setter())")
     3. filter링을 우선적으로 위에서 받아주면 다른 pointcut에서 설정되기 많이 편하다.
     */


    /** @Before 써보기
    @Before("execution(public void updateAccount())") 만약 아다리가 없는 함수라면 그냥 나가리
    1. 같은 함수이름이면 다 먹힌다.
    2. 단순 경로의 클래스의 함수를 지정해주면 그것만 불러와진다.
    3. 그냥 뒤에 *를 찾으면 와일드카드로 검색이 된다.
    4. Return type 아무거나 받고 싶으면 return type을 * 체크해주면됨
    5. 만약 클래스를 설정하고 싶으면 풀 path를 적어낼것 ( @Before("execution(public * add(com.godol.aopdemo.Account))")//)
    6. 만약 클래스를 설정하고 매개변수가 다르면 (..)으로 와일드카드@Before("execution(public * add*(com.godol.aopdemo.Account, ..))")
    7. 클래스 Path 와 *.*를 두고 뒤에 (..) 를 하면 그 함수안에 있는 모든 메서드들이 작동하게 된다.  @Before("execution(* com.godol.aopdemo.dao*.*(..))"
     */

    /** @AfterReturning
     1. 함수가 Return 값을 가지고 실행되고난 값을 받아서 추가로 실행 할 수 있다. 어노테이션 스코프안에 returning 값을 주고 그 값이 함수의 매개변수로 지정하면 실행된다

     */

    /** @AfterThrowing
     1. AfterReturning과 동일하게 함수에서 Exception이 catch가 되면 그 예외 부분을 매개변수로 받아서 응용을 하거나 실행하게 하는 메서드이다.
     */


    /** @After
     1. 함수가 끝나면 try - catch - finally 처럼 finally 부분을 처리하는 느낌을 지닌다 그냥 무조건 끝나면 실행이 되는 것
     */
    @After("execution(* com.godol.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint){
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n========> @After(Finally) 가 작동합니다 : " + method);

    }

    @AfterThrowing(pointcut = "execution(* com.godol.aopdemo.dao.AccountDAO.findAccounts(..))", throwing = "theExc")
    public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExc){
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n========> @AfterThrowing 가 작동합니다 : " + method);

        System.out.println("\n========> 예외 내용은 : " + theExc);
    }


    @AfterReturning(pointcut = "execution(* com.godol.aopdemo.dao.AccountDAO.findAccounts(..))", returning = "results")
    public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> results){
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n========> @AfterReturning 가 작동합니다 : " + method);

        System.out.println("\n========> result is: " + results);

        // 이후 데이터를 조작해보자

        // 계정이름을 대문자로 바꿔보기
        convertAccountNamesToUpperCase(results);
        System.out.println("\n========> Modified result is: " + results);
    }

    private void convertAccountNamesToUpperCase(List<Account> results) {
        for (Account result: results){
            String theUpperName = result.getName().toUpperCase();

            result.setName(theUpperName);
        }
    }

    @Before("com.godol.aopdemo.aspect.LoveAopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint){
        System.out.println("\n=========>> @Before add account 되기전 실행중");
        //  메소드 시그니쳐를 보여주기
        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
        System.out.println("메소드: " + methodSignature);
        //  메소드 아규먼트 보이기

        // 아규 가져오기
        Object[] args = theJoinPoint.getArgs();
        // 아규 루프 돌리기

        for (Object tempArg: args){
            System.out.println(tempArg);
            if (tempArg instanceof Account){
                // downcast해서
                Account theAccount = (Account) tempArg;

                System.out.println("account name " + theAccount.getName());
                System.out.println("account level " + theAccount.getLevel());

            }

        }
    }

}
