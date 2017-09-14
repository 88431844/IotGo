package com.iotlife.service;

import com.iotlife.dao.UserMapper;
import com.iotlife.dto.UserDto;
import com.iotlife.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserMapper userMapper;

    /**
     * 添加用户
     *
     * @param userDto
     * @throws Exception
     */
    public void addUser(UserDto userDto) throws Exception {
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        userMapper.insertSelective(user);
    }

    /**
     * 删除用户
     *
     * @param userDto
     * @throws Exception
     */
    public void delUser(UserDto userDto) throws Exception {
        userMapper.deleteByPrimaryKey(Integer.parseInt(userDto.getId()));
    }

    /**
     * 修改用户
     *
     * @param userDto
     * @throws Exception
     */
    public void updateUser(UserDto userDto) throws Exception {
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        userMapper.updateByPrimaryKey(user);
    }

    /**
     * 通过用户id查询用户信息
     *
     * @param userDto
     * @return
     * @throws Exception
     */
    public UserDto selectUserById(UserDto userDto) throws Exception {
        UserDto dto = new UserDto();
        User user = userMapper.selectByPrimaryKey(Integer.parseInt(userDto.getId()));
        BeanUtils.copyProperties(user, dto);
        return dto;
    }

}

