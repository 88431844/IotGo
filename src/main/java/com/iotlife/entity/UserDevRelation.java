package com.iotlife.entity;

public class UserDevRelation {
    private Integer id;

    private Integer userid;

    private Integer devid;

    public UserDevRelation(Integer id, Integer userid, Integer devid) {
        this.id = id;
        this.userid = userid;
        this.devid = devid;
    }

    public UserDevRelation() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getDevid() {
        return devid;
    }

    public void setDevid(Integer devid) {
        this.devid = devid;
    }
}