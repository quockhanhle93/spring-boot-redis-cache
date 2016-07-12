package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by taveek on 7/11/2016 AD.
 */
@RestController
public class HelloController {

    @Autowired
    private HelloService service;

    @RequestMapping("/hello/{name}")
    public String hello(@PathVariable String name) {
        return service.greeting(name);
    }

    @RequestMapping("/bye/{name}")
    public String goodbye(@PathVariable String name) {
        return service.goodbye(name);
    }
}
