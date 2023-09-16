package com.example.aophandson.aspect.aspects;

import com.example.aophandson.aspect.annotations.SecureMethod;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SecurityAspect {


    @Around("@annotation(secureMethod)")
    public Object secureMethodCheck(ProceedingJoinPoint joinPoint   ,
                                    SecureMethod secureMethod
    ) throws Throwable {

        if (secureMethod.secure()) {
            throw new SecurityException("Security check failed for this method");
        }
        // If the method is secure or not, proceed with its execution
        return joinPoint.proceed();
    }

}