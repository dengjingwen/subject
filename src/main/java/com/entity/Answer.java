package com.entity;

import java.io.Serializable;

public class Answer implements Serializable {
    private Integer anid;

    private Integer askid;

    private Integer userid;

    private String content;

    private Integer evaluate;

    private User user;

    private ConstsClassify constsclassify;

    public Integer getAnid() {
        return anid;
    }

    public void setAnid(Integer anid) {
        this.anid = anid;
    }

    public Integer getAskid() {
        return askid;
    }

    public void setAskid(Integer askid) {
        this.askid = askid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(Integer evaluate) {
        this.evaluate = evaluate;
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

    public Answer(Integer anid, Integer askid, Integer userid, String content, Integer evaluate, User user, ConstsClassify constsclassify) {
        this.anid = anid;
        this.askid = askid;
        this.userid = userid;
        this.content = content;
        this.evaluate = evaluate;
        this.user = user;
        this.constsclassify = constsclassify;
    }

    public Answer() {

    }

    @Override
    public String toString() {
        return "Answer{" +
                "anid=" + anid +
                ", askid=" + askid +
                ", userid=" + userid +
                ", content='" + content + '\'' +
                ", evaluate=" + evaluate +
                ", user=" + user +
                ", constsclassify=" + constsclassify +
                '}';
    }
}