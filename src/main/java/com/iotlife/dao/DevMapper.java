package com.iotlife.dao;

import com.iotlife.entity.Dev;

public interface DevMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Dev record);

    int insertSelective(Dev record);

    Dev selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Dev record);

    int updateByPrimaryKey(Dev record);
}