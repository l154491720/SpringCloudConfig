package com.cloudtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.cloudtest.service.HelloService;

@RestController
public class HelloController {

    @Autowired
    HelloService helloService;

    @RequestMapping("hi")
    public String home(@RequestParam String name){
        return helloService.hiService(name);
    }

    @RequestMapping("hello")
    public String hello(@RequestParam String name){
        return "123";
    }
}