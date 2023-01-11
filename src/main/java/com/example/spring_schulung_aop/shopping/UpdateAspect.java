package com.example.spring_schulung_aop.shopping;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UpdateAspect {
    @Pointcut("execution(* com.example.spring_schulung_aop.shopping.ShoppingCart.*(..))")
    public void shoppingCartMethodsPointcut(){
    }

    @After("shoppingCartMethodsPointcut()")
    public void update() {
        System.out.println("Hier wird der Aspekt ausgeführt.");
    }
}
