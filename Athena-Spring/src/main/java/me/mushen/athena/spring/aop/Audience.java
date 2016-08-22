package me.mushen.athena.spring.aop;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @Desc
 * @Author Remilia
 * @Create 2016-08-08
 */
@Aspect
public class Audience {

    @Before("execution(* me.mushen.athena.spring.aop.Performance.perform(..))")
    public void silenceCellPhones(){
        System.out.println("Silencing cell phones...");
    }

    @Before("execution(* me.mushen.athena.spring.aop.Performance.perform(..))")
    public void takeSeats(){
        System.out.println("Take seats...");
    }

    @AfterReturning("execution(* me.mushen.athena.spring.aop.Performance.perform(..))")
    public void applause(){
        System.out.println("CLAP CLAP CLAP...");
    }

    @AfterThrowing("execution(* me.mushen.athena.spring.aop.Performance.perform(..))")
    public void demandRefund(){
        System.out.println("Demanding a refund...");
    }
}