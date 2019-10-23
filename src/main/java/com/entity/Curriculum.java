package com.entity;

import java.io.Serializable;

public class Curriculum implements Serializable {
    private Integer cuid;

    private String cname;

    private String cdirection;

    private String category;

    private String briefIntroduction;

    private String cpicture;

    private String difficulty;

    public Integer getCuid() {
        return cuid;
    }

    public void setCuid(Integer cuid) {
        this.cuid = cuid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
    }

    public String getCdirection() {
        return cdirection;
    }

    public void setCdirection(String cdirection) {
        this.cdirection = cdirection == null ? null : cdirection.trim();
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    public String getBriefIntroduction() {
        return briefIntroduction;
    }

    public void setBriefIntroduction(String briefIntroduction) {
        this.briefIntroduction = briefIntroduction == null ? null : briefIntroduction.trim();
    }

    public String getCpicture() {
        return cpicture;
    }

    public void setCpicture(String cpicture) {
        this.cpicture = cpicture == null ? null : cpicture.trim();
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty == null ? null : difficulty.trim();
    }

    public Curriculum(Integer cuid, String cname, String cdirection, String category, String briefIntroduction, String cpicture, String difficulty) {
        this.cuid = cuid;
        this.cname = cname;
        this.cdirection = cdirection;
        this.category = category;
        this.briefIntroduction = briefIntroduction;
        this.cpicture = cpicture;
        this.difficulty = difficulty;
    }

    public Curriculum() {

    }

    @Override
    public String toString() {
        return "Curriculum{" +
                "cuid=" + cuid +
                ", cname='" + cname + '\'' +
                ", cdirection='" + cdirection + '\'' +
                ", category='" + category + '\'' +
                ", briefIntroduction='" + briefIntroduction + '\'' +
                ", cpicture='" + cpicture + '\'' +
                ", difficulty='" + difficulty + '\'' +
                '}';
    }
}