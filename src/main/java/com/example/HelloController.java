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

    @RequestMapping("/hello/{firstname}/{lastname}")
    public String hello(
            @PathVariable String firstname,
            @PathVariable String lastname
    ) {
        return service.greeting(new Person(firstname, lastname));
    }

    @RequestMapping("/bye/{firstname}/{lastname}")
    public String goodbye(
            @PathVariable String firstname,
            @PathVariable String lastname
    ) {
        return service.goodbye(new Person(firstname, lastname));
    }
}
