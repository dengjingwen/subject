package com.entity;

import java.io.Serializable;

public class User implements Serializable {
    private Integer usid;

    private String uname;

    private String codeName;

    private String upwd;

    private String headPortrait;

    private String autograph;

    private String uphone;

    private String uposition;

    private String address;

    public Integer getUsid() {
        return usid;
    }

    public void setUsid(Integer usid) {
        this.usid = usid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname == null ? null : uname.trim();
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName == null ? null : codeName.trim();
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd == null ? null : upwd.trim();
    }

    public String getHeadPortrait() {
        return headPortrait;
    }

    public void setHeadPortrait(String headPortrait) {
        this.headPortrait = headPortrait == null ? null : headPortrait.trim();
    }

    public String getAutograph() {
        return autograph;
    }

    public void setAutograph(String autograph) {
        this.autograph = autograph == null ? null : autograph.trim();
    }

    public String getUphone() {
        return uphone;
    }

    public void setUphone(String uphone) {
        this.uphone = uphone == null ? null : uphone.trim();
    }

    public String getUposition() {
        return uposition;
    }

    public void setUposition(String uposition) {
        this.uposition = uposition == null ? null : uposition.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public User(Integer usid, String uname, String codeName, String upwd, String headPortrait, String autograph, String uphone, String uposition, String address) {
        this.usid = usid;
        this.uname = uname;
        this.codeName = codeName;
        this.upwd = upwd;
        this.headPortrait = headPortrait;
        this.autograph = autograph;
        this.uphone = uphone;
        this.uposition = uposition;
        this.address = address;
    }

    public User() {

    }

    @Override
    public String toString() {
        return "User{" +
                "usid=" + usid +
                ", uname='" + uname + '\'' +
                ", codeName='" + codeName + '\'' +
                ", upwd='" + upwd + '\'' +
                ", headPortrait='" + headPortrait + '\'' +
                ", autograph='" + autograph + '\'' +
                ", uphone='" + uphone + '\'' +
                ", uposition='" + uposition + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}