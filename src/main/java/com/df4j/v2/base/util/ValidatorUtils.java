package com.df4j.v2.base.util;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * 常用校验工具类
 */
public class ValidatorUtils {
    public static boolean isEmpty(String value){
        return isNull(value) || value.trim().length() == 0;
    }

    public static boolean notEmpty(String value){
        return !isEmpty(value);
    }

    public static boolean notEmpty(List<?> list){
        return list != null && list.size() > 0;
    }

    public static boolean isEmpty(List<?> list){
        return !notEmpty(list);
    }

    public static boolean notEmpty(Map map){
        return map != null && !map.isEmpty();
    }

    public static boolean isEmpty(Map map){
        return !notEmpty(map);
    }

    public static boolean notNull(Object object){
        return !isNull(object);
    }

    public static boolean isNull(Object object){
        return object == null;
    }

    /**
     * 检验字符串是否满足匹配
     * @param content
     * @param regex
     * @return
     */
    public static boolean match(CharSequence content, String regex){
        return Pattern.matches(regex, content);
    }
}
