package com.fendi.ttclub.bean;

import java.util.ArrayList;
import java.util.List;

public class EasyUITree {
    public static String STATE_OPEN = "open";
    public static String STATE_CLOSED = "closed";
    private Integer id;
    private String text;
    private boolean checked;
    /**
     * 当他为open时、说明这个节点是个文件夹、会以文件夹的形式显示，当他是closed的时候、说明这个节点是一个具体的文件节点、不会以文件夹的形式显示。
     */
    private String state = STATE_OPEN;
    private String attributes;
    private List<EasyUITree> children;

    public EasyUITree() {
        this(null, null, STATE_OPEN);
    }

    public EasyUITree(Integer id, String text) {
        this(id, text, STATE_OPEN);
    }

    public EasyUITree(Integer id, String text, String state) {
        this.id = id;
        this.text = text;
        this.state = state;
        this.children = new ArrayList<EasyUITree>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAttributes() {
        return attributes;
    }

    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }

    public List<EasyUITree> getChildren() {
        return children;
    }

    public void setChildren(List<EasyUITree> children) {
        this.children = children;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
