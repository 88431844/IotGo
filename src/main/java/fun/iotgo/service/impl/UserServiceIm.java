package fun.iotgo.service.impl;

import fun.iotgo.dao.UserMapper;
import fun.iotgo.dto.UserDto;
import fun.iotgo.entity.User;
import fun.iotgo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class UserServiceIm implements UserService {

    @Resource
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

    /**
     * 查询所有用户信息
     *
     * @return
     * @throws Exception
     */
    public List<UserDto> selectAllUser() throws Exception {
        List<UserDto> uList = new ArrayList<>();
        uList = userMapper.selectAllUser();
        return uList;

    }

}

