package com.entity;

import java.io.Serializable;

public class Video implements Serializable {
    private Integer vid;

    private Integer cuid;

    private String vname;

    private Integer vtime;

    private String vurl;

    public Integer getVid() {
        return vid;
    }

    public void setVid(Integer vid) {
        this.vid = vid;
    }

    public Integer getCuid() {
        return cuid;
    }

    public void setCuid(Integer cuid) {
        this.cuid = cuid;
    }

    public String getVname() {
        return vname;
    }

    public void setVname(String vname) {
        this.vname = vname == null ? null : vname.trim();
    }

    public Integer getVtime() {
        return vtime;
    }

    public void setVtime(Integer vtime) {
        this.vtime = vtime;
    }

    public String getVurl() {
        return vurl;
    }

    public void setVurl(String vurl) {
        this.vurl = vurl == null ? null : vurl.trim();
    }

    public Video(Integer vid, Integer cuid, String vname, Integer vtime, String vurl) {
        this.vid = vid;
        this.cuid = cuid;
        this.vname = vname;
        this.vtime = vtime;
        this.vurl = vurl;
    }

    public Video() {

    }

    @Override
    public String toString() {
        return "Video{" +
                "vid=" + vid +
                ", cuid=" + cuid +
                ", vname='" + vname + '\'' +
                ", vtime=" + vtime +
                ", vurl='" + vurl + '\'' +
                '}';
    }
}