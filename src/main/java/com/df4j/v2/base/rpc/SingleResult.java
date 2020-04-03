package com.df4j.v2.base.rpc;

import com.df4j.v2.base.constant.ResultType;

/**
 * 单结果集
 * @param <T>
 */
public class SingleResult<T> extends Result<T>{
    public SingleResult(){
        super(ResultType.OBJECT);
    }

    public SingleResult(Object result){
        this();
        this.setResult((T)result);
    }
}
