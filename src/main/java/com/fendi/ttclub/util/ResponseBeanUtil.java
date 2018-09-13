package com.fendi.ttclub.util;

import com.fendi.ttclub.bean.ResponseBean;
import org.springframework.web.bind.annotation.ResponseBody;

public class ResponseBeanUtil {

    private static final String SUCCESS = "0000";
    private static final String FAIL = "0001";

    private static final String SUCCESS_DEFAULT_MSG = "操作成功";

    public static ResponseBean success(String message){
        return getResponseBean(SUCCESS, message, null);
    }

    public static ResponseBean success(Object object){
        return getResponseBean(SUCCESS, SUCCESS_DEFAULT_MSG, object);
    }

    public static ResponseBean success(String message, Object object){
        return getResponseBean(SUCCESS, message, object);
    }

    public static ResponseBean fail(String message){
        return getResponseBean(FAIL, message, null);
    }

    public static ResponseBean fail(String message, Object object){
        return getResponseBean(FAIL, message, object);
    }

    public static ResponseBean getResponseBean(String code, String message, Object object){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setCode(code);
        responseBean.setMessage(message);
        responseBean.setObject(object);
        return responseBean;
    }
}
