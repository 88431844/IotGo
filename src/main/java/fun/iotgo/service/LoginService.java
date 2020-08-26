package fun.iotgo.service;

import fun.iotgo.dao.AdminMapper;
import fun.iotgo.dao.UserMapper;
import fun.iotgo.dto.AdminDto;
import fun.iotgo.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class LoginService {
    @Resource
    private AdminMapper adminMapper;
    @Resource
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
