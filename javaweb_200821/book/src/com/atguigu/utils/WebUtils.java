package com.atguigu.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class WebUtils {
    /**
     * 将参数列表中的数据封装到bean中
     *
     * @param bean
     * @param param
     * @param <T>
     * @return 一个带有属性的bean
     */
    public static <T> T copyParamToBean(T bean, Map param) {
        try {
            BeanUtils.populate(bean, param);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return bean;
    }

    /**
     * 将字符串转成integer类型，且带有默认值
     *
     * @param value        需要转化的字符串
     * @param defaultValue 默认值
     * @return
     */
    public static Integer parseInt(String value, Integer defaultValue) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            //此异常信息可忽略
        }
        return defaultValue;
    }
}
