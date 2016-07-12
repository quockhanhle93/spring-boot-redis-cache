package com.example;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

/**
 * Created by taveek on 7/11/2016 AD.
 */
@Service
public class HelloService {

    @CachePut(value = "greeting", key = "#person.firstname")
    public String greeting(Person person) {
        System.out.println("greeting to: " + person.getFullname());
        return "Hello, " + person.getFullname();
    }

    @CacheEvict(value = "greeting", key = "#person.firstname")
    public String goodbye(Person person) {
        System.out.println("goodbye to: " + person.getFullname());
        return "Goodbye, " + person.getFullname();
    }
}
