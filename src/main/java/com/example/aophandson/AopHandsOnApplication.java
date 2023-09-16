package com.example.aophandson;

import com.example.aophandson.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class AopHandsOnApplication {

    @Autowired
    private DemoService demoService;

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(AopHandsOnApplication.class, args);
        AopHandsOnApplication app = context.getBean(AopHandsOnApplication.class);

        app.runDemoServiceMethods();

        context.close();
    }

    private void runDemoServiceMethods() {
        demoService.notSecuredMethod();
        demoService.securedMethod();
    }
}
