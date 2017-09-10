package com.iotlife.dao;

import com.iotlife.entity.UserDevRelation;

public interface UserDevRelationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserDevRelation record);

    int insertSelective(UserDevRelation record);

    UserDevRelation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserDevRelation record);

    int updateByPrimaryKey(UserDevRelation record);
}