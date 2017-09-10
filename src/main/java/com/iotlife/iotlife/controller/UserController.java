package com.iotlife.iotlife.controller;

import com.iotlife.iotlife.dto.UserDto;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/addUser")
    @ResponseBody
    public void addUser(@RequestBody @Validated UserDto userDto) {

    }

    public void delUser() {

    }

    public void updateUser() {

    }

    public void selectUser() {

    }
}
