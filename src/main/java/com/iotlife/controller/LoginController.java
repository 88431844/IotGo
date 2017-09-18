package com.iotlife.controller;

import com.iotlife.dto.AdminDto;
import com.iotlife.dto.CommonResponseDto;
import com.iotlife.dto.UserDto;
import com.iotlife.service.LoginService;
import com.iotlife.util.myconst;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
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
        CommonResponseDto CommonResponseDto = new CommonResponseDto();
        AdminDto data = loginService.adminLogin(adminDto);

        if (null != data && null != data.getId()) {
            //如果查询出来结果不等于null，并且id不为null，则说明登录成功
            CommonResponseDto.setCode(myconst.SUCCESS);
            CommonResponseDto.setMsg(myconst.LOGIN_SUCCESS);
            CommonResponseDto.setData(data);
        } else {
            CommonResponseDto.setCode(myconst.FAIL);
            CommonResponseDto.setMsg(myconst.LOGIN_FAIL);
        }
        return CommonResponseDto;
    }

    /**
     * 用户登录
     * @param userDto
     * @return
     */
    @RequestMapping("/userLogin")
    @ResponseBody
    public CommonResponseDto userLogin(@RequestBody @Validated UserDto userDto) {
        CommonResponseDto CommonResponseDto = new CommonResponseDto();
        UserDto data = loginService.userLogin(userDto);

        if (null != data && null != data.getId()) {
            //如果查询出来结果不等于null，并且id不为null，则说明登录成功
            CommonResponseDto.setCode(myconst.SUCCESS);
            CommonResponseDto.setMsg(myconst.LOGIN_SUCCESS);
            CommonResponseDto.setData(data);
        } else {
            CommonResponseDto.setCode(myconst.FAIL);
            CommonResponseDto.setMsg(myconst.LOGIN_FAIL);
        }
        return CommonResponseDto;
    }

}
