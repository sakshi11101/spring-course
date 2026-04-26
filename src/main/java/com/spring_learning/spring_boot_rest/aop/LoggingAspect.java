package com.spring_learning.spring_boot_rest.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    public void loggingMethod() {
        LOGGER.info("Logging Method called");
    }
}
