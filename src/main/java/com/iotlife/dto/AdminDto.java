package com.iotlife.iotlife.dto;

public class AdminDto {
    private String adminLoginName;
    private String adminPassword;
    private String adminName;

    @Override
    public String toString() {
        return "AdminDto{" +
                "adminLoginName='" + adminLoginName + '\'' +
                ", adminPassword='" + adminPassword + '\'' +
                ", adminName='" + adminName + '\'' +
                '}';
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
