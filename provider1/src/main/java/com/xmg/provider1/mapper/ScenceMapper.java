package com.xmg.provider1.mapper;

import com.xmg.commons.entity.ScenceEntity;
import com.xmg.provider1.base.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@org.apache.ibatis.annotations.Mapper
public interface ScenceMapper extends Mapper<ScenceEntity> {
    List<ScenceEntity> queryScence(@Param("clientid") String clientid, @Param("paramKey") String paramKey);
   int  add(ScenceEntity scenceEntity);
/*
    int  deleteById(Long id);

    int  update(ScenceEntity scenceEntity);

    ScenceEntity getById(Long id);*/

    List<ScenceEntity> getAll();
}
