package com.iotlife.dao;

import com.iotlife.entity.DevType;

public interface DevTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DevType record);

    int insertSelective(DevType record);

    DevType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DevType record);

    int updateByPrimaryKey(DevType record);
}