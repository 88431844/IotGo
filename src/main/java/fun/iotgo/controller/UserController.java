package fun.iotgo.controller;

import fun.iotgo.dto.CommonResponseDto;
import fun.iotgo.dto.UserDto;
import fun.iotgo.service.UserService;
import fun.iotgo.util.myconst;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 *用户controller
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Resource
    private UserService userService;

    /**
     * 添加用户
     *
     * @param userDto
     * @return
     */
    @RequestMapping("/addUser")
    @ResponseBody
    public CommonResponseDto addUser(@RequestBody @Validated UserDto userDto) {
        CommonResponseDto ret = new CommonResponseDto();
        try {
            userService.addUser(userDto);
            ret.setCode(myconst.SUCCESS);
        } catch (Exception e) {
            log.error("UserController addUser error");
            ret.setCode(myconst.EXCEPTION);
            e.printStackTrace();
        }
        return ret;
    }

    /**
     * 删除用户
     * @param userDto
     * @return
     */
    @RequestMapping("/delUser")
    @ResponseBody
    public CommonResponseDto delUser(@RequestBody @Validated UserDto userDto) {
        CommonResponseDto ret = new CommonResponseDto();
        try {
            userService.delUser(userDto);
            ret.setCode(myconst.SUCCESS);
        } catch (Exception e) {
            log.error("UserController delUser error");
            ret.setCode(myconst.EXCEPTION);
            e.printStackTrace();
        }
        return ret;
    }

    /**
     * 修改用户
     * @param userDto
     * @return
     */
    @RequestMapping("/updateUser")
    @ResponseBody
    public CommonResponseDto updateUser(@RequestBody @Validated UserDto userDto) {
        CommonResponseDto ret = new CommonResponseDto();
        try {
            userService.updateUser(userDto);
            ret.setCode(myconst.SUCCESS);
        } catch (Exception e) {
            log.error("UserController updateUser error");
            ret.setCode(myconst.EXCEPTION);
            e.printStackTrace();
        }
        return ret;
    }

    /**
     * 查询用户通过用户id
     *
     * @param userDto
     * @return
     */
    @RequestMapping("/selectUserById")
    @ResponseBody
    public CommonResponseDto selectUserById(@RequestBody @Validated UserDto userDto) {
        CommonResponseDto ret = new CommonResponseDto();
        try {
            ret.setData(userService.selectUserById(userDto));
            ret.setCode(myconst.SUCCESS);
        } catch (Exception e) {
            log.error("UserController selectUserById error");
            ret.setCode(myconst.EXCEPTION);
            e.printStackTrace();
        }
        return ret;
    }

    /**
     * 查询所有用户列表
     *
     * @return
     */
    @RequestMapping("/selectAllUser")
    @ResponseBody
    public CommonResponseDto selectAllUser() {
        CommonResponseDto ret = new CommonResponseDto();
        List<UserDto> uList = new ArrayList<>();
        try {
            uList = userService.selectAllUser();
            if (null != uList && uList.size() > 0) {
                ret.setData(uList);
            } else {
                ret.setCode(myconst.EMPTY_LIST);
            }
        } catch (Exception e) {
            log.error("UserController selectAllUser error");
            ret.setCode(myconst.EXCEPTION);
            e.printStackTrace();
        }
        return ret;
    }

}
