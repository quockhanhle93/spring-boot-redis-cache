package com.example;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

/**
 * Created by taveek on 7/11/2016 AD.
 */
@Service
public class HelloService {

    @CachePut(value = "greeting", key = "#name")
    public String greeting(String name) {
        System.out.println("greeting to: " + name);
        return "Hello, " + name;
    }

    @CacheEvict(value = "greeting", key = "#name")
    public String goodbye(String name) {
        System.out.println("goodbye to: " + name);
        return "Goodbye, " + name;
    }
}
