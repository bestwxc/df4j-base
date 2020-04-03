package com.df4j.v2.base.util;

import com.df4j.v2.base.exception.DfException;
import org.springframework.util.ReflectionUtils;
import java.lang.reflect.Field;
import java.util.Map;

/**
 * Bean工具类
 */
public class BeanUtils {
    /**
     * Bean深拷贝
     * @param bean
     * @return
     */
    public static Object cloneBean(Object bean){
        return cloneBean(bean, null);
    }

    /**
     * Bean深拷贝
     * @param bean
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T cloneBean(Object bean, Class<T> clazz){
        if(bean == null){
            return null;
        }
        if(ValidatorUtils.notNull(clazz)){
            if(!clazz.equals(bean.getClass())){
                throw new DfException("bean的类型与传入的clazz不一致，bean.getClass():" + bean.getClass() + ",clazz:" + clazz.getClass());
            }
            clazz = (Class<T>) bean.getClass();
        }
        T newInstance = org.springframework.beans.BeanUtils.instantiateClass(clazz);
        org.springframework.beans.BeanUtils.copyProperties(bean, newInstance);
        return newInstance;
    }

    /**
     * 设置值
     * @param object
     * @param fields
     * @param values
     */
    public static void setValues(Object object, String[] fields, Object[] values){
        setValues(object, fields, values, false);
    }

    /**
     * 设置值
     * @param object
     * @param fields
     * @param values
     * @param overwrite
     */
    public static void setValues(Object object, String[] fields, Object[] values, boolean overwrite){
        for(int i = 0; i < fields.length; i++){
            try {
                if(object instanceof Map){
                    ((Map) object).put(fields[i], values[i]);
                } else {
                    Field field = ReflectionUtils.findField(object.getClass(), fields[i]);
                    field.setAccessible(true);
                    Object value = ReflectionUtils.getField(field, object);
                    if (overwrite || ValidatorUtils.isNull(value)) {
                        ReflectionUtils.setField(field, object, values[i]);
                    }
                }
            }catch (Exception e){
                throw new DfException("设置对应字段出错,field:" + fields[i] + ",value:" + values[i], e);
            }
        }
    }
}
