package com.fendi.ttclub.bean;

public class ResponseBean {
    /**
     * 成功标识，成功0000 失败0001 其它
     */
    private String code;
    /**
     * 描述
     */
    private String message;
    /**
     * 成功返回信息
     */
    private Object object;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
