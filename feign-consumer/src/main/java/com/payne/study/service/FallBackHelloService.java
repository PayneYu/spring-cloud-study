package com.payne.study.service;

import org.springframework.stereotype.Component;

/**
 * @program: spring-cloud-study
 * @description:
 * @author: Huizhe Yu
 * @create: 2018-10-02 19:09
 */
@Component
public class FallBackHelloService implements HelloService{

    @Override
    public String hiService() {
        return "Sorry,this is fall back method";
    }
}
