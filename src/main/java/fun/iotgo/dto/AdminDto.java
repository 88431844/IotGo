package fun.iotgo.dto;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

public class AdminDto {
    private String id;
    @NotNull(message = "管理员账号不能为null")
    @NotBlank(message = "管理员账号不能为空白")
    private String adminLoginName;
    @NotNull(message = "管理员密码不能为null")
    @NotBlank(message = "管理员密码不能为空白")
    private String adminPassword;
    private String adminName;

    @Override
    public String toString() {
        return "AdminDto{" +
                "id='" + id + '\'' +
                ", adminLoginName='" + adminLoginName + '\'' +
                ", adminPassword='" + adminPassword + '\'' +
                ", adminName='" + adminName + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAdminLoginName() {
        return adminLoginName;
    }

    public void setAdminLoginName(String adminLoginName) {
        this.adminLoginName = adminLoginName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }
}
