package fun.iotgo.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class AdminDto {
    private String id;
    @NotNull(message = "管理员账号不能为null")
    @NotEmpty(message = "管理员账号不能为空白")
    private String adminLoginName;
    @NotNull(message = "管理员密码不能为null")
    @NotEmpty(message = "管理员密码不能为空白")
    private String adminPassword;
    private String adminName;
}
