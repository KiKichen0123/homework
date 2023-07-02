package com.reflection.class_;

import com.Car;

/**
 * 该程序的说明如下：
 */
public class GetClass_ {
    public static void main(String[] args) throws ClassNotFoundException {
        //Class.forName
        String classAllPath = "com.Car";
        Class<?> cls = Class.forName(classAllPath);
        System.out.println(cls);

        //类名.class , 应用场景: 用于参数传递
        Class<Car> cls2 = Car.class;
        System.out.println(cls2);

        //对象.getClass(), 应用场景，有对象实例
        Car car = new Car();
        Class<? extends Car> cls3 = car.getClass();
        System.out.println(cls3);

        //通过类加载器【4种】来获取到类的Class对象
        //(1)先得到类加载器 car
        ClassLoader classLoader = car.getClass().getClassLoader();
        //(2)通过类加载器得到Class对象
        Class<?> cls4 = classLoader.loadClass(classAllPath);

        //cls , cls2 , cls3 , cls4 是同一个对象
        System.out.println(cls.hashCode());
        System.out.println(cls2.hashCode());
        System.out.println(cls3.hashCode());
        System.out.println(cls4.hashCode());

        Class<Integer> integerClass = int.class;
        System.out.println(integerClass);

        Class<Character> type2 = Character.TYPE;
        System.out.println(type2);

        System.out.println(integerClass.hashCode());
        System.out.println(type2.hashCode());

    }
}
