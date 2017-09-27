package com.iotlife.dao;

import com.iotlife.entity.UserDevRelation;

public interface UserDevRelationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserDevRelation record);

    int insertSelective(UserDevRelation record);

    UserDevRelation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserDevRelation record);

    int updateByPrimaryKey(UserDevRelation record);

    /**
     * 通过用户id和设备id删除用户绑定设备关系
     *
     * @param userDevRelation
     */
    void delByUserIdAndDevId(UserDevRelation userDevRelation);

    /**
     * 解绑用户所有设备
     *
     * @param userId
     */
    void unBindUserAllDev(String userId);
}