package com.fendi.ttclub.entity;

public class RoleRight {
    private Integer trrId;

    private Integer roleId;

    private Integer rightId;

    private String rightType = "0";

    public Integer getTrrId() {
        return trrId;
    }

    public void setTrrId(Integer trrId) {
        this.trrId = trrId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getRightId() {
        return rightId;
    }

    public void setRightId(Integer rightId) {
        this.rightId = rightId;
    }

    public String getRightType() {
        return rightType;
    }

    public void setRightType(String rightType) {
        this.rightType = rightType == null ? null : rightType.trim();
    }

    private Integer count;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}