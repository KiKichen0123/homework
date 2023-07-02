package com.homework;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 该程序的说明如下：
 */
public class Homework02 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class<?> fileclass = Class.forName(String.valueOf("java.io.File"));
        Constructor<?>[] declaredConstructors = fileclass.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println("File构造器=" + declaredConstructor);
        }

        String filePath = "A:\\mynew.txt";
        Constructor<?> declaredConstructor = fileclass.getDeclaredConstructor(String.class);
        Object file = declaredConstructor.newInstance(filePath);

        Method createNewFile = fileclass.getMethod("createNewFile");
        Object invoke = createNewFile.invoke(file);//创建文件，调用的是 createNewFile
        System.out.println("创建文件成功：" + filePath);
    }
}
