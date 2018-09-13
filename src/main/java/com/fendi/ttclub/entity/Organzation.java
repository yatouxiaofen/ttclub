package com.fendi.ttclub.entity;

import java.util.Date;

public class Organzation {
    private String toId;

    private String parentToId;

    private String orgName;

    private String orgDescription;

    private Date genTime;

    public String getToId() {
        return toId;
    }

    public void setToId(String toId) {
        this.toId = toId == null ? null : toId.trim();
    }

    public String getParentToId() {
        return parentToId;
    }

    public void setParentToId(String parentToId) {
        this.parentToId = parentToId == null ? null : parentToId.trim();
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName == null ? null : orgName.trim();
    }

    public String getOrgDescription() {
        return orgDescription;
    }

    public void setOrgDescription(String orgDescription) {
        this.orgDescription = orgDescription == null ? null : orgDescription.trim();
    }

    public Date getGenTime() {
        return genTime;
    }

    public void setGenTime(Date genTime) {
        this.genTime = genTime;
    }
}