package com.fendi.ttclub.entity;

import java.util.Date;

public class Role {
    private Integer trId;

    private Integer parentTrId;

    private String roleName;

    private Date genTime;

    private String description;

    public Integer getTrId() {
        return trId;
    }

    public void setTrId(Integer trId) {
        this.trId = trId;
    }

    public Integer getParentTrId() {
        return parentTrId;
    }

    public void setParentTrId(Integer parentTrId) {
        this.parentTrId = parentTrId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public Date getGenTime() {
        return genTime;
    }

    public void setGenTime(Date genTime) {
        this.genTime = genTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}