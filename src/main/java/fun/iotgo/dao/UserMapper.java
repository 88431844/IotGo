package fun.iotgo.dao;

import fun.iotgo.dto.UserDto;
import fun.iotgo.entity.User;

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
     */
    UserDto selectByLoginNameAndPass(UserDto userDto);

    /**
     * 查询全部用户信息
     */
    List<UserDto> selectAllUser();
}