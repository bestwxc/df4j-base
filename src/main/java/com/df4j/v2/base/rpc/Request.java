package com.df4j.v2.base.rpc;

import java.util.Map;

public interface Request {
    String getGroupId();
    String getFuncNo();
    Map getRequestMap();
}
