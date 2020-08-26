package com.iotlife.service;

import com.iotlife.dao.AdminMapper;
import com.iotlife.dao.UserMapper;
import com.iotlife.dto.AdminDto;
import com.iotlife.dto.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private UserMapper userMapper;

    /**
     * 管理员登录
     *
     * @param adminDto
     * @return
     */
    public AdminDto adminLogin(AdminDto adminDto) throws Exception {
        return adminMapper.selectByLoginNameAndPass(adminDto);
    }

    /**
     * 用户登录
     *
     * @param userDto
     * @return
     */
    public UserDto userLogin(UserDto userDto) throws Exception {
        return userMapper.selectByLoginNameAndPass(userDto);
    }
}
