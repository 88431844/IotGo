package fun.iotgo.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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

    @Override
    public String toString() {
        return "UserDto{" +
                "id='" + id + '\'' +
                ", userLoginName='" + userLoginName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userName='" + userName + '\'' +
                ", userTel='" + userTel + '\'' +
                ", userDes='" + userDes + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserLoginName() {
        return userLoginName;
    }

    public void setUserLoginName(String userLoginName) {
        this.userLoginName = userLoginName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public String getUserDes() {
        return userDes;
    }

    public void setUserDes(String userDes) {
        this.userDes = userDes;
    }
}
