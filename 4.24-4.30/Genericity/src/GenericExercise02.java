import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author 陈淇淇
 * @version 1.8
 */
public class GenericExercise02 {
    public static void main(String[] args) {
        ArrayList<Employee> list = new ArrayList<Employee>();
        list.add(new Employee("丽丽",20000,new MyDate(2001,1,11)));
        list.add(new Employee("mary",12000,new MyDate(2000,12,12)));
        list.add(new Employee("jack",20000,new MyDate(1999,2,28)));

        System.out.println(list);

        list.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee emp1, Employee emp2) {
                //先按name排序
                if(!(emp1 instanceof  Employee && emp2 instanceof Employee)){
                    System.out.println("类型不准确");
                    return 0;
                }
                int i = emp1.getName().compareTo(emp2.getName());
                if(i != 0){
                    return i;
                }
                return emp1.getBirthday().compareTo(emp2.getBirthday());
            }
        });

        System.out.println("------------排序后------------");
        System.out.println(list);

    }
}

class Employee{
    private String name;
    private double sal;
    private MyDate birthday;

    public Employee(String name, double sal, MyDate birthday) {
        this.name = name;
        this.sal = sal;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "\nEmployee{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", birthday=" + birthday +
                '}';
    }
}

class MyDate implements Comparable<MyDate>{
    private int month;
    private int day;
    private int year;

    public MyDate(int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "month=" + month +
                ", day=" + day +
                ", year=" + year +
                '}';
    }

    @Override
    public int compareTo(MyDate o) {
        int yearMinus = year - o.getYear();
        if(yearMinus !=0){
            return yearMinus;
        }

        int monthMinus = month -o.getMonth();
        if(monthMinus != 0){
            return monthMinus;
        }

        return day - o.getDay();
    }
}
