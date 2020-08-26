package fun.iotgo.controller;

import fun.iotgo.dto.AdminDto;
import fun.iotgo.dto.CommonResponseDto;
import fun.iotgo.dto.UserDto;
import fun.iotgo.service.LoginService;
import fun.iotgo.util.myconst;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 登录controller
 */
@RestController
@RequestMapping("/login")
@Slf4j
public class LoginController {
    @Resource
    private LoginService loginService;

    /**
     * 管理员登录
     *
     * @param adminDto
     * @return
     */
    @RequestMapping("/adminLogin")
    @ResponseBody
    public CommonResponseDto adminLogin(@RequestBody @Validated AdminDto adminDto) {
        CommonResponseDto ret = new CommonResponseDto();
        try {
            AdminDto data = loginService.adminLogin(adminDto);
            if (null != data && null != data.getId()) {
                //如果查询出来结果不等于null，并且id不为null，则说明登录成功
                ret.setCode(myconst.SUCCESS);
                ret.setData(data);
            } else {
                ret.setCode(myconst.FAIL);
            }
        } catch (Exception e) {
            log.error("LoginController adminLogin error");
            ret.setCode(myconst.EXCEPTION);
            e.printStackTrace();
        }
        return ret;
    }

    /**
     * 用户登录
     * @param userDto
     * @return
     */
    @RequestMapping("/userLogin")
    @ResponseBody
    public CommonResponseDto userLogin(@RequestBody @Validated UserDto userDto) {
        CommonResponseDto ret = new CommonResponseDto();
        try {
            UserDto data = loginService.userLogin(userDto);
            if (null != data && null != data.getId()) {
                //如果查询出来结果不等于null，并且id不为null，则说明登录成功
                ret.setCode(myconst.SUCCESS);
                ret.setData(data);
            } else {
                ret.setCode(myconst.FAIL);
            }
        } catch (Exception e) {
            log.error("LoginController userLogin error");
            ret.setCode(myconst.EXCEPTION);
            e.printStackTrace();
        }
        return ret;
    }

}
