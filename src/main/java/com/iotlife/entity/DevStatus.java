package com.iotlife.entity;

public class DevStatus {
    private Integer id;

    private Integer devid;

    /**
     * 0 下线
     * 1 上线
     * 2 未知
     * 默认0
     */
    private Integer devstatus;

    public DevStatus(Integer id, Integer devid, Integer devstatus) {
        this.id = id;
        this.devid = devid;
        this.devstatus = devstatus;
    }

    public DevStatus() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDevid() {
        return devid;
    }

    public void setDevid(Integer devid) {
        this.devid = devid;
    }

    public Integer getDevstatus() {
        return devstatus;
    }

    public void setDevstatus(Integer devstatus) {
        this.devstatus = devstatus;
    }
}