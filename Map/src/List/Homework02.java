package List;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * @author 陈淇淇
 * @version 1.8
 */
public class Homework02 {
    public static void main(String[] args) {
        List list = new ArrayList();
        Car car = new Car("宝马",400000);
        Car car2 = new Car("宾利",5000000);

        list.add(car);
        list.add(car2);
        System.out.println(list);
        list.remove(1);
        System.out.println(list);
        System.out.println(list.contains(car));
        System.out.println(list.size());
        System.out.println(list.isEmpty());
//        list.addAll(new Car("雅迪",20000),new Car("小刀",20000));
        list.addAll(list);
        System.out.println(list);
        list.containsAll(list);
//        list.removeAll(list);

        System.out.println("-----------增强for循环-----------");
        for (Object o :list) {
            System.out.println(o);
        }

        System.out.println("-----------iterator循环-----------");
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object next =  iterator.next();
            System.out.println(next);
        }
    }
}

class Car implements Collection {
    private String name;
    private int price;

    public Car(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }
}