package com.payne.study.controller;

import com.payne.study.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: spring-cloud-study
 * @description:
 * @author: Huizhe Yu
 * @create: 2018-09-28 20:54
 */
@RestController
public class HelloController {

    @Autowired
    HelloService helloService;

    @GetMapping(value = "/hi")
    public String hi() {
        return helloService.hiService();
    }
}
