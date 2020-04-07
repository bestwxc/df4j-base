package com.df4j.v2.base.rpc;

public interface Response {
    void setErrorNo(int errorNo);
    void setErrorInfo(String errorInfo);
    void setResult(Object result);
}
