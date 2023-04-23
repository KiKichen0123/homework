package List;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author 陈淇淇
 * @version 1.8
 */
/*
添加 10 个以上的元素(比如 String "hello" )，在 2 号位插入一个元素"韩顺平教育"，
获得第 5 个元素，删除第 6 个元素，修改第 7 个元素，在使用迭代器遍历集合，
要求:使用 List 的实现类 ArrayList 完成
 */
public class ListExercise01 {
    public static void main(String[] args) {
        List list = new ArrayList();
        for(int i = 0;i<=10;i++){
            list.add("hello");
        }
        list.add(1,"hello,world");
        System.out.println(list);
        System.out.println(list.get(4));
        list.remove(5);
        list.set(6,"cqq");

        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object next =  iterator.next();
            System.out.println("List=" + next);
        }
    }
}
