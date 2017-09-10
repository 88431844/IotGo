package com.iotlife.controller;

import com.iotlife.dto.AdminDto;
import com.iotlife.dto.CommonDto;
import com.iotlife.dto.UserDto;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @RequestMapping("/adminLogin")
    @ResponseBody
    public CommonDto adminLogin(@RequestBody @Validated AdminDto adminDto) {
        CommonDto dto = new CommonDto();
        return dto;
    }

    @RequestMapping("/userLogin")
    @ResponseBody
    public CommonDto userLogin(@RequestBody @Validated UserDto userDto) {
        CommonDto dto = new CommonDto();
        return dto;
    }
}
