package com.fendi.ttclub.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Right implements Comparable<Right>{
    private Integer trId;

    private Integer parentTrId;

    private String rightName;

    private String url;

    private String description;

    private Integer showOrder;

    private Date genTime;

    private List<Right> children = new ArrayList<Right>();

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

    public String getRightName() {
        return rightName;
    }

    public void setRightName(String rightName) {
        this.rightName = rightName == null ? null : rightName.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getShowOrder() {
        return showOrder;
    }

    public void setShowOrder(Integer showOrder) {
        this.showOrder = showOrder;
    }

    public Date getGenTime() {
        return genTime;
    }

    public void setGenTime(Date genTime) {
        this.genTime = genTime;
    }

    public List<Right> getChildren() {
        return children;
    }

    public void setChildren(List<Right> children) {
        this.children = children;
    }

    @Override
    public int compareTo(Right o) {
        return this.getTrId()-o.getTrId();
    }

    /**
     * 角色ID
     */
    private Integer roleId;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * 传给子查询的角色id
     */
    private Integer roId;

    public Integer getRoId() {
        return roId;
    }

    public void setRoId(Integer roId) {
        this.roId = roId;
    }

    private Integer userId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Right{" +
                "trId=" + trId +
                ", parentTrId=" + parentTrId +
                ", rightName='" + rightName + '\'' +
                ", url='" + url + '\'' +
                ", description='" + description + '\'' +
                ", showOrder=" + showOrder +
                ", genTime=" + genTime +
                ", children=" + children +
                ", roleId=" + roleId +
                ", roId=" + roId +
                ", userId=" + userId +
                '}';
    }
}