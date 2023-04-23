package Map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author 陈淇淇
 * @version 1.8
 */
public class MapExcercise {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put(1,new Employee("张三",2000));
        map.put(2,new Employee("李四",19000));

        Set keySet = map.keySet();
        System.out.println("=====第一种遍历方式======");
        for (Object key :keySet) {
            Employee emp =(Employee)map.get(key);
            if(emp.getSalary()>18000){
                System.out.println(emp);
            }
        }

        Set entrySet = map.entrySet();
        System.out.println("=======迭代器======");
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            Employee emp = (Employee) entry.getValue();
            if(emp.getSalary() >18000){
                System.out.println(emp);
            }

        }

    }
}

class Employee{
    private String name;
    private static int salary;
    static{
        salary++;
    }

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
