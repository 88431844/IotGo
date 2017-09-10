package com.iotlife.entity;

public class Admin {
    private Integer id;

    private String adminloginname;

    private String adminpassword;

    private String adminname;

    public Admin(Integer id, String adminloginname, String adminpassword, String adminname) {
        this.id = id;
        this.adminloginname = adminloginname;
        this.adminpassword = adminpassword;
        this.adminname = adminname;
    }

    public Admin() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdminloginname() {
        return adminloginname;
    }

    public void setAdminloginname(String adminloginname) {
        this.adminloginname = adminloginname == null ? null : adminloginname.trim();
    }

    public String getAdminpassword() {
        return adminpassword;
    }

    public void setAdminpassword(String adminpassword) {
        this.adminpassword = adminpassword == null ? null : adminpassword.trim();
    }

    public String getAdminname() {
        return adminname;
    }

    public void setAdminname(String adminname) {
        this.adminname = adminname == null ? null : adminname.trim();
    }
}