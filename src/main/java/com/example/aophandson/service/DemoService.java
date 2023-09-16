package com.example.aophandson.service;

import com.example.aophandson.aspect.annotations.SecureMethod;
import org.springframework.stereotype.Service;

@Service
public class DemoService {


    @SecureMethod(secure = true )
    public void securedMethod() {
        System.out.println("Secured Method");
    }

    @SecureMethod(secure = false)
    public void notSecuredMethod() {
        System.out.println("Not Secured Method");
    }
}
