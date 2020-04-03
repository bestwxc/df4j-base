package com.df4j.v2.base.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 日志管理类
 */
public class LoggerManage {
    // 默认sys Logger 名称
    public static String DEFAULT_SYS_LOGGER_NAME = "dfSysLogger";
    // 默认biz Logger 名称
    public static String DEFAULT_BIZ_LOGGER_NAME = "dfBizLogger";

    // 获取SysLogger
    public static Logger getSysLogger(){
        return LoggerFactory.getLogger(DEFAULT_SYS_LOGGER_NAME);
    }

    // 获取BizLogger
    public static Logger getBizLogger(){
        return LoggerFactory.getLogger(DEFAULT_BIZ_LOGGER_NAME);
    }
}
