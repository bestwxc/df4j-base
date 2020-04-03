package com.df4j.v2.base.exception;

import com.df4j.v2.base.util.TextUtils;
import com.df4j.v2.base.util.ValidatorUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BizExceptionFactory {
    /**
     * 用于保存自定义的异常类型，初始化后不允许改动
     */
    private static Map<Integer,String> errorInfos = new ConcurrentHashMap<>();

    public synchronized void addConfigMessage(Integer errorNo, String message){
        errorInfos.put(errorNo, message);
    }

    public synchronized void addConfigMessages(Map<Integer,String> errors){
        errorInfos.putAll(errors);
    }

    /**
     * build BizException
     * @param errorNo
     * @param message
     * @return
     */
    public static BizException build(Integer errorNo, String message){
        return build(errorNo, message, null);
    }

    /**
     * build BizException
     * @param errorNo
     * @param message
     * @param replacement
     * @return
     */
    public static BizException build(Integer errorNo, String message, Map replacement){
        return build(errorNo, message, replacement, null);
    }

    /**
     * build BizException
     * @param errorNo
     * @param throwable
     * @return
     */
    public static BizException build(Integer errorNo, Throwable throwable){
        return build(errorNo, null, null, throwable);
    }

    /**
     * build BizException
     * @param errorNo
     * @param message
     * @param replacement
     * @param throwable
     * @return
     */
    public static BizException build(Integer errorNo, String message, Map replacement, Throwable throwable){
        String temp = errorInfos.get(errorNo);
        if(ValidatorUtils.isEmpty(temp)){
            temp = message;
        }
        if(ValidatorUtils.isEmpty(temp)){
            temp = "业务错误号[" + errorNo + "]";
        }
        if(ValidatorUtils.notEmpty(replacement)){
            temp = TextUtils.replace(temp, replacement);
        }
        return new BizException(errorNo, temp, throwable);
    }

}
