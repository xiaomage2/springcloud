package com.xmg.feignconsumer.controller;

import com.xmg.feignconsumer.feign.ProviderFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feignConsumerHello")
public class FeignConsumerHelloController {


    @Autowired
    private ProviderFeign providerFeign;

    @RequestMapping("/hello")
    public String hello()
    {
        return providerFeign.hello();
    }
}
