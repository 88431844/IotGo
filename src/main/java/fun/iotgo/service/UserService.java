package fun.iotgo.service;

import fun.iotgo.dto.UserDto;

import java.util.List;

public interface UserService {

    /**
     * 添加用户
     */
    void addUser(UserDto userDto) throws Exception;

    /**
     * 删除用户
     */
    void delUser(UserDto userDto) throws Exception;

    /**
     * 修改用户
     */
    void updateUser(UserDto userDto) throws Exception;

    /**
     * 通过用户id查询用户信息
     */
    UserDto selectUserById(UserDto userDto) throws Exception;

    /**
     * 查询所有用户信息
     */
    List<UserDto> selectAllUser() throws Exception;
}
