package com.example.demo.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @company sunyard
 * @projectName pmc
 * @author JiangT
 * @date 2019/6/19 9:49
 * @description: 异常处理切面类
 */
@Aspect
@Component
public aspect ThrowAspect {

    //切入点
    @Pointcut(value = "@annotation(com.example.demo.common.Throw)")
    private void pointCut(){}

    @Pointcut("execution(public * com.example.demo.service.impl.ThrowService.mm(..))")
    private void pointCut2(){}



    @Around("pointCut2()") // 环绕通知
    public void point(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("【Around】method before !! ");
        Object[] args = jp.getArgs();
        Object proceed = jp.proceed(args);
        System.out.println("【Around】method return " + proceed + "!!");
        System.out.println("【Around】method after !! ");
    }

    @Before("pointCut()") //前置通知
    public void point2(ProceedingJoinPoint jp) {
        Signature signature = jp.getSignature();
        String method_name = signature.getName();
        System.out.println("【Before】切入方法名" + method_name);
        System.out.println("【Before】method before !! ");
    }
//
//    @After("pointCut()") //后置通知
//    public void point3(ProceedingJoinPoint jp) {
//        Signature signature = jp.getSignature();
//        String method_name = signature.getName();
//        System.out.println("【After】切入方法名" + method_name);
//        System.out.println("【After】method After !! ");
//    }
//
//    @AfterThrowing("pointCut()") //出现异常通知
//    public void point4(ProceedingJoinPoint jp) {
//        Signature signature = jp.getSignature();
//        String method_name = signature.getName();
//        System.out.println("【Throw】切入方法名" + method_name);
//        System.out.println("【Throw】method has Throwable !! ");
//    }
//
//    @AfterReturning("pointCut()") //方法返回后通知
//    public void point5(ProceedingJoinPoint jp) {
//        Signature signature = jp.getSignature();
//        String method_name = signature.getName();
//        System.out.println("【AfterReturning】切入方法名" + method_name);
//        System.out.println("【AfterReturning】method return complete !! ");
//    }


}
