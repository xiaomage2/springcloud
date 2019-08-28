package com.xmg.consumer.controller;

import com.xmg.commons.entity.ScenceEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ConsumerController  {

    @Autowired
    private RestTemplate restTemplate;
    @RequestMapping("/hello")
    public String  hello()
    {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://provider1/hello", String.class);
        return responseEntity.getBody();
    }


    @RequestMapping("/getAll")
    public List<Map> getAll()
    {

//        ResponseEntity<List> responseEntity = restTemplate.getForEntity("http://provider1/getAll", List.class);
        List<Map> list = new ArrayList<>();
        list=  restTemplate.getForObject("http://provider1/getAll", List.class);
        return list;
    }

    @RequestMapping("/getJson")
    public List<Map> getJson()
    {

        List<Map> list = new ArrayList<>();
        Map map = null;
        for(int  i=0;i<10;i++){
            map= new HashMap();
            map.put("id",i);
            list.add(map);
        }
        return list;
    }
}
