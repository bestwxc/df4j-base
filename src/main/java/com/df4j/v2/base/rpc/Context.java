package com.df4j.v2.base.rpc;

public interface Context {
    /**
     * 获取请求参数
     * @return
     */
    Request getRequest();

    /**
     * 获取响应
     * @return
     */
    Response getResponse();
}
