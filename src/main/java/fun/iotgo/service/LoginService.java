package fun.iotgo.service;

import fun.iotgo.dto.AdminDto;
import fun.iotgo.dto.UserDto;

public interface LoginService {

    /**
     * 管理员登录
     */
    AdminDto adminLogin(AdminDto adminDto) throws Exception;

    /**
     * 用户登录
     */
    UserDto userLogin(UserDto userDto) throws Exception;
}
