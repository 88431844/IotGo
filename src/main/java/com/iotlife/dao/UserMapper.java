package com.iotlife.dao;

import com.iotlife.dto.UserDto;
import com.iotlife.entity.User;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * 通过账号密码查询用户信息
     *
     * @param userDto
     * @return
     */
    UserDto selectByLoginNameAndPass(UserDto userDto);

    /**
     * 查询全部用户信息
     *
     * @return
     */
    List<UserDto> selectAllUser();
}