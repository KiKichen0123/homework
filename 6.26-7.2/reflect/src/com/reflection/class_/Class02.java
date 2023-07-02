package com.reflection.class_;

import com.Car;

import java.lang.reflect.Field;

/**
 * 该程序的说明如下：
 */
public class Class02 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        String classAllPath = "com.Car";

        Class<?> cls = Class.forName(classAllPath);
        //输出cls
        //哪个类的对象
        System.out.println(cls);
        //cls运行类型
        System.out.println(cls.getClass());

        //包名
        System.out.println(cls.getPackage().getClass());

        //全类名
        System.out.println(cls.getName());

        Car car = (Car)cls.newInstance();
        System.out.println(car);

        Field brand = cls.getField("brand");
        System.out.println(brand.get(car));

        //通过反射给属性赋值
        brand.set(car,"奔驰");
        System.out.println(brand.get(car));
        //得到所有的属性
        System.out.println("=======所有的字段属性=======");
        Field[] fields = cls.getFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }

    }
}
