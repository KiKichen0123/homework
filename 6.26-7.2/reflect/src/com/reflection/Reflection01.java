package com.reflection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 该程序的说明如下：
 */
public class Reflection01 {
    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, InstantiationException, ClassNotFoundException, IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\re.properties"));
        String classfullpath = properties.get("classfullpath").toString();
        String methodName = properties.get("method").toString();

        Class<?> cls = Class.forName(classfullpath);
        Object o = cls.newInstance();

        Method method = cls.getMethod(methodName);
        method.invoke(o);

        Field nameFiled = cls.getField("age");
        System.out.println(nameFiled.get(o));

        Constructor<?> constructor = cls.getConstructor();
        System.out.println(constructor);

        Constructor<?> constructor1 = cls.getConstructor(String.class);
        System.out.println(constructor1);
    }
}
