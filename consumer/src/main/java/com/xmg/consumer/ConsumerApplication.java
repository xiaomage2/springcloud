package com.xmg.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableEurekaClient
@SpringBootApplication
public class ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

    /**
     * RestTemplate 是spring-web 这个jar里面的东西，它封装了http请求
     * @return
     */
    @LoadBalanced//开启负载均衡
    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
