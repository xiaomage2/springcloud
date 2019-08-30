package com.xmg.provider1.service;

import com.xmg.commons.entity.ScenceEntity;

import java.util.List;

public interface ScenceService {

    List<ScenceEntity> getAll();
    int addScence(ScenceEntity scenceEntity);
}
