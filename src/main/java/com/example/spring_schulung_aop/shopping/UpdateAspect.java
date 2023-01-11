package com.example.spring_schulung_aop.shopping;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UpdateAspect {
    @Pointcut("within(ShoppingCart)")
    public void shoppingCartMethodsPointcut(){
    }

    @After("shoppingCartMethodsPointcut()")
    public void update(JoinPoint joinPoint) {
        ShoppingCart shoppingCart = (ShoppingCart) joinPoint.getTarget();
        shoppingCart.updateItemCount();
        shoppingCart.updatePrice();
    }
}
