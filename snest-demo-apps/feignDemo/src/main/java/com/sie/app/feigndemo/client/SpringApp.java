package com.sie.app.feigndemo.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author chun
 */
@SpringBootApplication
@EnableFeignClients
public class SpringApp {

    private final static Logger logger = LoggerFactory.getLogger(SpringApp.class);

    private static ConfigurableApplicationContext context;

    private static SpringApp springApp;

    @Autowired
    private StoreClient storeClient;

    public static synchronized void start(String[] args, ClassLoader classLoader) {
        if (context != null) {
            return;
        }

        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        Thread.currentThread().setContextClassLoader(classLoader);
        try {
            context = SpringApplication.run(SpringApp.class, args == null ? new String[0] : args);

            springApp = context.getBean(SpringApp.class);
        } catch (Throwable e) {
            logger.error(e.getMessage(), e);
        } finally {
            Thread.currentThread().setContextClassLoader(contextClassLoader);
        }
    }

    public static synchronized void stop() {
        if (context == null) {
            return;
        }

        try {
            context.stop();
        } catch (Throwable e) {
            logger.error(e.getMessage(), e);
        } finally {
            context = null;
            springApp = null;
        }
    }

    public static SpringApp getSpringApp() {
        return springApp;
    }

    public StoreClient getStoreClient() {
        return storeClient;
    }
}
