package com.payne.study.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @program: spring-cloud-study
 * @description:
 * @author: Huizhe Yu
 * @create: 2018-09-28 20:53
 */
@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "hiError")
    public String hiService(String name) {
        return restTemplate.getForObject("http://eureka-client/hello",String.class);
    }
    //Fall Back method
    public String hiError(String name) {
        return "hi,"+name+",sorry,error!";
    }
}
