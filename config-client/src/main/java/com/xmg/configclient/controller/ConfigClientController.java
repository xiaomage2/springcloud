package com.xmg.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/configClient")
public class ConfigClientController {
    @Value("${profile}")
    private String  profile;
    @RequestMapping("/profile")
    public String getProfile()
    {
        return profile;
    }
}
