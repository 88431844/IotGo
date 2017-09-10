package com.iotlife.controller;

import com.iotlife.dto.CommonDto;
import com.iotlife.dto.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/addUser")
    @ResponseBody
    public CommonDto addUser(@RequestBody @Validated UserDto userDto) {
        CommonDto dto = new CommonDto();
        return dto;
    }

    @RequestMapping("/delUser")
    @ResponseBody
    public CommonDto delUser(@RequestBody @Validated UserDto userDto) {
        CommonDto dto = new CommonDto();
        return dto;
    }

    @RequestMapping("/updateUser")
    @ResponseBody
    public CommonDto updateUser(@RequestBody @Validated UserDto userDto) {
        CommonDto dto = new CommonDto();
        return dto;
    }

    @RequestMapping("/selectUser")
    @ResponseBody
    public List<UserDto> selectUser(@RequestBody @Validated UserDto userDto) {
        List<UserDto> uList = new ArrayList<>();
        return uList;
    }
}
