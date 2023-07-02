package com.reflection.question;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 该程序的说明如下：
 */
public class ReflectionQuestion {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        //使用Properties类，可以读写配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\re.properties"));
        String classfullpath = properties.get("classfullpath").toString();
        String methodName = properties.get("method").toString();
        System.out.println("classfullpath=" + classfullpath);
        System.out.println("method=" + methodName);

        //使用反射机制解决
        //加载类，返回class类型的对象cls
        Class<?> cls = Class.forName(classfullpath);
        //通过cls得到加载的类 Cat 的对象实例
        Object o = cls.newInstance();
        //通过 cls 得到加载的类 Cat 的 methodName"hi"  的方法对象
        //    即：在反射中，可以把方法视为对象（万物皆对象）
        Method method = cls.getMethod(methodName);
        //通过method1 调用方法: 即通过方法对象来实现调用方法
        method.invoke(o);
    }
}
