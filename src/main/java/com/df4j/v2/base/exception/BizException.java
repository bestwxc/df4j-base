package com.df4j.v2.base.exception;

import com.df4j.v2.base.constant.DfBizErrorCode;

public class BizException extends DfException{
    /**
     * 错误号
     */
    private Integer errorNo;

    /**
     * 构造函数
     */
    public BizException(){
        this(DfBizErrorCode.UNCATCH_BUSINESS_EXCEPTION);
    }

    /**
     * 构造函数
     * @param errorNo
     */
    public BizException(Integer errorNo){
        super();
        this.errorNo = errorNo;
    }

    /**
     * 构造函数
     * @param errorNo
     * @param message
     * @param cause
     */
    public BizException(Integer errorNo, String message, Throwable cause){
        super(message, cause);
        this.errorNo = errorNo;
    }

    /**
     * 构造函数
     * @param errorNo
     * @param message
     */
    public BizException(Integer errorNo, String message){
        super(message);
        this.errorNo = errorNo;
    }

    /**
     * 构造函数
     * @param errorNo
     * @param cause
     */
    public BizException(Integer errorNo, Throwable cause){
        super(cause);
        this.errorNo = errorNo;
    }

    /**
     * 获取错误号
     * @return
     */
    public Integer getErrorNo() {
        return errorNo;
    }
}
