package com.xmg.provider1.controller;

import com.xmg.commons.entity.ScenceEntity;
import com.xmg.provider1.service.ScenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ScenceController {
    @Autowired
    private ScenceService scenceService;

    @RequestMapping("/getAll")
    public List<ScenceEntity> getAll()
    {
        return scenceService.getAll();
    }

}
