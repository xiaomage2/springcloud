package com.xmg.feignconsumer.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("provider1")//@FeignClient 的参数和服务提供者的名字是一致的
public interface ProviderFeign {
    @RequestMapping("/hello")
    String  hello();
}
