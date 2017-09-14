package com.iotlife.dao;

import com.iotlife.dto.DevDto;
import com.iotlife.entity.Dev;

import java.util.List;

public interface DevMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Dev record);

    int insertSelective(Dev record);

    Dev selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Dev record);

    int updateByPrimaryKey(Dev record);

    /**
     * 通过用户id查询该用户下面绑定设备
     *
     * @param userId
     * @return
     */
    List<DevDto> selectDevByUserId(String userId);
}