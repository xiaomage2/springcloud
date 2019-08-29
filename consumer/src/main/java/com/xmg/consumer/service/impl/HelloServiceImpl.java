package com.xmg.consumer.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.xmg.consumer.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloServiceImpl implements HelloService {
    @Autowired
    private RestTemplate restTemplate;

    /**
     * 在HystrixCommand注解配置失败时候回调的方法参数名
     * @return
     */
    @Override
    @HystrixCommand(fallbackMethod = "error")
    public String hello() {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://provider1/hello", String.class);
        return responseEntity.getBody();
    }


    //Throwable 异常（可以不加的）
    //服务降级
    @HystrixCommand(fallbackMethod = "error2")
    public String error(Throwable throwable)
    {
        return "hello,这是本地预设的一个数据！";
    }
}
