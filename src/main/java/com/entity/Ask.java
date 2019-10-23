package com.entity;

import java.io.Serializable;

public class Ask implements Serializable {
    private Integer askid;

    private Integer cuid;

    private String asubject;

    private User user;

    private ConstsClassify constsclassify;

    public Integer getAskid() {
        return askid;
    }

    public void setAskid(Integer askid) {
        this.askid = askid;
    }

    public Integer getCuid() {
        return cuid;
    }

    public void setCuid(Integer cuid) {
        this.cuid = cuid;
    }

    public String getAsubject() {
        return asubject;
    }

    public void setAsubject(String asubject) {
        this.asubject = asubject;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ConstsClassify getConstsclassify() {
        return constsclassify;
    }

    public void setConstsclassify(ConstsClassify constsclassify) {
        this.constsclassify = constsclassify;
    }

    public Ask(Integer askid, Integer cuid, String asubject, User user, ConstsClassify constsclassify) {
        this.askid = askid;
        this.cuid = cuid;
        this.asubject = asubject;
        this.user = user;
        this.constsclassify = constsclassify;
    }

    public Ask() {

    }

    @Override
    public String toString() {
        return "Ask{" +
                "askid=" + askid +
                ", cuid=" + cuid +
                ", asubject='" + asubject + '\'' +
                ", user=" + user +
                ", constsclassify=" + constsclassify +
                '}';
    }
}