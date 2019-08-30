package com.xmg.provider1.service.impl;

import com.xmg.commons.entity.ScenceEntity;
import com.xmg.provider1.mapper.ScenceMapper;
import com.xmg.provider1.service.ScenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScenceServiceImpl implements ScenceService {
    @Autowired
    private ScenceMapper scenceMapper;

    @Override
    public List<ScenceEntity> getAll() {
        return scenceMapper.getAll();
    }

    @Override
    public int addScence(ScenceEntity scenceEntity) {
        return scenceMapper.add(scenceEntity);
    }


}
