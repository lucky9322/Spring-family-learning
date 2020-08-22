package com.lucky.spring.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by zhangdd on 2020/8/22
 */
@Aspect
@Component
@Slf4j
public class DaoOpsAspect {


    @Pointcut("execution(* com.lucky.spring.dao..*(..))")
    private void repositoryOps() {
    }

    @Around("repositoryOps()")
    public Object logPerformance(ProceedingJoinPoint pjp) throws Throwable {
        long startTime = System.currentTimeMillis();
        String name = "-";
        String result = "Y";
        try {
            name = pjp.getSignature().toShortString();
            return pjp.proceed();
        } catch (Throwable throwable) {
            result = "N";
            throw throwable;
        } finally {
            long endTime = System.currentTimeMillis();
            log.info("{},{},{}ms", name, result, endTime - startTime);
        }
    }

}
