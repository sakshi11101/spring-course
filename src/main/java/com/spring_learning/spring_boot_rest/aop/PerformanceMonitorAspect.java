package com.spring_learning.spring_boot_rest.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceMonitorAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(PerformanceMonitorAspect.class);

    /* This @Around advice is basically doing like taken note of time before getJob method of JobService is executed,
     go around and executes that method via jp.proceed (like saying go continue your job) and then noting time as when
     the execution is completed and monitoring the same. */

    @Around("execution(* com.spring_learning.spring_boot_rest.service.JobService.getJob(..))")
    public Object performanceAspect(ProceedingJoinPoint jp) throws Throwable {
        long start = System.currentTimeMillis();
        Object obj = jp.proceed();
        long end  = System.currentTimeMillis();
        LOGGER.info("Time taken is : " + (end - start) + " ms");
        return obj;
    }
}
