package com.df4j.v2.base.util;

import com.df4j.v2.base.constant.DfBizErrorCode;
import com.df4j.v2.base.rpc.MultiResult;
import com.df4j.v2.base.rpc.PageResult;
import com.df4j.v2.base.rpc.Result;
import com.df4j.v2.base.rpc.SingleResult;
import com.github.pagehelper.Page;
import java.util.List;

/**
 * 构造返回结果的工具类
 */
public class ResultUtils {

    /**
     * 构建结果对象
     * @param errorNo
     * @param errorInfo
     * @param pageNo
     * @param pageSize
     * @param total
     * @param result
     * @return
     */
    public static Result build(Integer errorNo, String errorInfo, Integer pageNo, Integer pageSize, Integer total, Object result){
        Result returnResult = null;
        if(result instanceof List){
            List list = (List)result;
            if(ValidatorUtils.notNull(pageNo)){
                if (list instanceof Page) {
                    total = new Long(((Page) list).getTotal()).intValue();
                }
                returnResult = new PageResult(pageNo, pageSize, total, list);
            }else{
                returnResult = new MultiResult(list);
            }
        }else{
            returnResult = new SingleResult<Object>(result);
        }
        returnResult.setErrorNo(errorNo);
        returnResult.setErrorInfo(errorInfo);
        return returnResult;
    }


    /**
     * 成功返回
     * @param pageNo
     * @param pageSize
     * @param total
     * @param result
     * @return
     */
    public static Result success(Integer pageNo, Integer pageSize, Integer total, Object result){
        return build(DfBizErrorCode.SUCCESS, "调用成功", pageNo, pageSize, total, result);
    }


    /**
     * 成功返回
     * @param result
     * @return
     */
    public static Result success(Object result){
        return success(null, null, null, result);
    }


    /**
     * 错误返回
     * @param errorNo
     * @param errorInfo
     * @param result
     * @return
     */
    public static Result error(int errorNo, String errorInfo, Object result){
        return build(errorNo, errorInfo, null, null, null, result);
    }

    /**
     * 错误返回
     * @param errorNo
     * @param errorInfo
     * @return
     */
    public static Result error(int errorNo, String errorInfo){
        return error(errorNo, errorInfo, null);
    }

}
