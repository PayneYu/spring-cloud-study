package com.payne.study.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @program: spring-cloud-study
 * @description:
 * @author: Huizhe Yu
 * @create: 2018-09-28 22:04
 */
@FeignClient(value = "eureka-client",fallback = FallBackHelloService.class)
public interface HelloService {

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hiService();

}
