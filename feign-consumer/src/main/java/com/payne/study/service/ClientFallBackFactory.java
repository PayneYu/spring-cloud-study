package com.payne.study.service;

import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @program: spring-cloud-study
 * @description:
 * @author: Huizhe Yu
 * @create: 2018-10-02 20:00
 */
@Component
public class ClientFallBackFactory implements FallbackFactory<HelloService>{

    private static Logger LOGGER = LoggerFactory.getLogger(ClientFallBackFactory.class);
    @Override
    public HelloService create(Throwable throwable) {
        LOGGER.error("Fall Back Error,"+throwable.getMessage(),throwable);
        return new HelloService(){

            @Override
            public String hiService() {
                return "Sorry,this fall back from FallBackFactory";
            }
        };
    }
}