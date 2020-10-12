package fun.iotgo.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class UserDto {

    private String id;
    @NotNull(message = "用户账号不能为null")
    @NotEmpty(message = "用户员账号不能为空白")
    private String userLoginName;
    @NotNull(message = "用户密码不能为null")
    @NotEmpty(message = "用户密码不能为空白")
    private String userPassword;
    private String userName;
    private String userTel;
    private String userDes;//用户介绍

}
