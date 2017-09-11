package com.iotlife.dao;

import com.iotlife.dto.UserDto;
import com.iotlife.entity.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    UserDto selectByLoginNameAndPass(UserDto userDto);
}