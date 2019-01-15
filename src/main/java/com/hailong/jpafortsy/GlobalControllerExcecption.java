package com.hailong.jpafortsy;

import com.alibaba.fastjson.JSONObject;
import jodd.util.StringUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 错误信息返回
 * 错误信息保存
 */
@ControllerAdvice
public class GlobalControllerExcecption{

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public JSONObject execptionHandler(Exception ex){

        JSONObject errorJson = new JSONObject();
        String message = ex.getMessage();
        if (StringUtil.isEmpty(message)){
            message = ex.getClass().getName();
        }
        errorJson.put("message",message);
        errorJson.put("code",0);

        return errorJson;
    }
}
