package com.iotlife.dto;

public class DevDto {
    private Integer id;

    private String devname;

    private Integer devtype;

    private String devdes;

    private String devtopic;

    private Integer belonguser;

    @Override
    public String toString() {
        return "DevDto{" +
                "id=" + id +
                ", devname='" + devname + '\'' +
                ", devtype=" + devtype +
                ", devdes='" + devdes + '\'' +
                ", devtopic='" + devtopic + '\'' +
                ", belonguser=" + belonguser +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDevname() {
        return devname;
    }

    public void setDevname(String devname) {
        this.devname = devname;
    }

    public Integer getDevtype() {
        return devtype;
    }

    public void setDevtype(Integer devtype) {
        this.devtype = devtype;
    }

    public String getDevdes() {
        return devdes;
    }

    public void setDevdes(String devdes) {
        this.devdes = devdes;
    }

    public String getDevtopic() {
        return devtopic;
    }

    public void setDevtopic(String devtopic) {
        this.devtopic = devtopic;
    }

    public Integer getBelonguser() {
        return belonguser;
    }

    public void setBelonguser(Integer belonguser) {
        this.belonguser = belonguser;
    }
}
