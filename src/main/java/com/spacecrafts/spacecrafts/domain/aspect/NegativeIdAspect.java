package com.spacecrafts.spacecrafts.domain.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class NegativeIdAspect {

    @Before("execution( * com.spacecrafts.spacecrafts.controller.controller.SpacecraftController.getSpacecraftById(..)) && args(id)")
    public void checkNegativeId(JoinPoint joinPoint, Long id){
        System.out.println("In Aspect from Args");
        if (id <0 ) {
            System.out.println("el identificador es erróneo");
        }
    }
}

