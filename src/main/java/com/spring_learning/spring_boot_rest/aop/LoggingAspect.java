package com.spring_learning.spring_boot_rest.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    /*
        @Before is Advice
        expression under inside is "Point Cut".
        JoinPoint gives the hold/signature of the method for which this advice is being called.
     */

    // return type (* for all types of return type), class-name.method-name(args) (* for all classes and * for all methods, but .. for all arguments)
    @Before("execution(* com.spring_learning.spring_boot_rest.service.JobService.*(..))") //execution basically states when do we have to call this method.
    //Now this means that for all return types in class (relative path including package) JobService, upon calling all methods with all types of arguments, loggingMethod should be called.
    public void loggingMethod() {
        LOGGER.info("Logging Method called");
    }

    //Here we are calling this advice only for two particular methods of JobService which is getJob and other is getAllJobs.
    @Before("execution(* com.spring_learning.spring_boot_rest.service.JobService.getJob(..)) || execution(* com.spring_learning.spring_boot_rest.service.JobService.getAllJobs(..))")
    public void loggingMethod_1(JoinPoint jp) {
        LOGGER.info("Method called before - " + jp.getSignature().getName());
    }

    //In @After advice, it means that this loggingMethod_2 is being called after finally block is executed.
    @After("execution(* com.spring_learning.spring_boot_rest.service.JobService.getJob(..)) || execution(* com.spring_learning.spring_boot_rest.service.JobService.getAllJobs(..))")
    public void loggingMethod_2(JoinPoint jp) {
        LOGGER.info("Method executed after - " + jp.getSignature().getName());
    }

    //Here in @AfterThrowing advice, this method will be called only when methods specified throws some errors/exceptions.
    @AfterThrowing("execution(* com.spring_learning.spring_boot_rest.service.JobService.getJob(..)) || execution(* com.spring_learning.spring_boot_rest.service.JobService.getAllJobs(..))")
    public void loggingMethod_3(JoinPoint jp) {
        LOGGER.info("Method has some issues - " + jp.getSignature().getName());
    }

    //Here in @AfterReturning advice, this method will be called only when methods return response successfully.
    @AfterReturning("execution(* com.spring_learning.spring_boot_rest.service.JobService.getJob(..)) || execution(* com.spring_learning.spring_boot_rest.service.JobService.getAllJobs(..))")
    public void loggingMethod_4(JoinPoint jp) {
        LOGGER.info("Method has returned successfully - " + jp.getSignature().getName());
    }
}
