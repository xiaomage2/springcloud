package com.xmg.provider1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/hello",produces = "text/html")
    public String hello(){
        //根据服务名称互殴服务
        List<ServiceInstance> provider1 = discoveryClient.getInstances("provider1");
        StringBuffer stringBuffer = null;
        for(ServiceInstance serviceInstance:provider1)
        {
            stringBuffer =new StringBuffer();
            System.out.println("serviceInstance.getHost()>>>"+serviceInstance.getHost());
            System.out.println("serviceInstance.getPort()>>>"+serviceInstance.getPort());
            System.out.println("serviceInstance.getUri()>>>"+serviceInstance.getUri());
            System.out.println("serviceInstance.getServiceId()>>>"+serviceInstance.getServiceId());
            System.out.println("serviceInstance.getMetadata()>>>"+serviceInstance.getMetadata());
        }
        return null;
    }
}
