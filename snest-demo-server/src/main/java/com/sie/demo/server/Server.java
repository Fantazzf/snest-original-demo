package com.sie.demo.server;

import com.sie.snest.engine.container.Engine;
import com.sie.snest.engine.loader.BaseLoader;
import com.sie.snest.engine.model.Loader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@ComponentScan(basePackages = "com.sie.snest")
public class Server {
    public static void main(String[] args) {
        // 启动引擎
        Loader.setLoader(new BaseLoader());
        Engine.start();

        // 启动SpringBoot
        SpringApplication.run(Server.class, args);
    }
}
