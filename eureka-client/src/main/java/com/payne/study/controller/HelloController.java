package com.payne.study.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: spring-cloud-study
 * @description:
 * @author: Huizhe Yu
 * @create: 2018-09-27 20:51
 */
@RestController
public class HelloController {

    @Value("${server.port}")
    String port;

    @GetMapping("hello")
    public String hello(){
        return "hi ,i am from port:" + port;
    }
}
