package com.df4j.v2.base.exception;

import com.df4j.v2.base.constant.DfBizErrorCode;

/**
 * 业务异常子类，入参不合法
 */
public class ParamIllegalException extends BizException {

    /**
     * 构造函数
     */
    public ParamIllegalException(){
        super(DfBizErrorCode.VALIDATE_FAIL);
    }

    /**
     * 构造函数
     * @param message
     */
    public ParamIllegalException(String message){
        super(DfBizErrorCode.VALIDATE_FAIL, message);
    }
}
