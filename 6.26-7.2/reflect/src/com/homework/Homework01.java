package com.homework;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 该程序的说明如下：
 */
public class Homework01 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        String classPath = "com.cqq.homework.PrivateTest";
        Class<?> aClass = Class.forName(classPath);
        Object o = aClass.newInstance();
        Field name = aClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(o,"baby");
        Method method = aClass.getMethod("getName");
        Object invoke = method.invoke(o);
        System.out.println(invoke);
    }
}
