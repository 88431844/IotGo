package com.iotlife.dto;

public class DevDto {
    private Integer id;

    private String devName;

    private Integer devType;

    private String devTypeName;

    private String devDes;

    private String devTopic;

    private String userId;
    /**
     * 0 下线
     * 1 上线
     * 2 未知
     * 默认0
     */
    private Integer devStatus;

    @Override
    public String toString() {
        return "DevDto{" +
                "id=" + id +
                ", devName='" + devName + '\'' +
                ", devType=" + devType +
                ", devTypeName='" + devTypeName + '\'' +
                ", devDes='" + devDes + '\'' +
                ", devTopic='" + devTopic + '\'' +
                ", userId='" + userId + '\'' +
                ", devStatus=" + devStatus +
                '}';
    }

    public Integer getDevStatus() {
        return devStatus;
    }

    public void setDevStatus(Integer devStatus) {
        this.devStatus = devStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDevName() {
        return devName;
    }

    public void setDevName(String devName) {
        this.devName = devName;
    }

    public Integer getDevType() {
        return devType;
    }

    public void setDevType(Integer devType) {
        this.devType = devType;
    }

    public String getDevTypeName() {
        return devTypeName;
    }

    public void setDevTypeName(String devTypeName) {
        this.devTypeName = devTypeName;
    }

    public String getDevDes() {
        return devDes;
    }

    public void setDevDes(String devDes) {
        this.devDes = devDes;
    }

    public String getDevTopic() {
        return devTopic;
    }

    public void setDevTopic(String devTopic) {
        this.devTopic = devTopic;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
