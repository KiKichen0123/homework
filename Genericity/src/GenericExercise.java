import java.util.*;

/**
 * @author 陈淇淇
 * @version 1.8
 */
public class GenericExercise {
    public static void main(String[] args) {
//        Student s1 = new Student("丽丽",20);
//        Student s2 = new Student("小明",21);
//        Student s3 = new Student("小红",22);
        //泛型--hashset
        HashSet<Student> students = new HashSet<>();//后面没写默认是前面的类型Student
        students.add(new Student("丽丽",20));
        students.add(new Student("小明",21));
        students.add(new Student("小红",22));

        for (Student student :students) {
            System.out.println(student);
        }

        //泛型--hashmap
        HashMap<String,Student> hm = new HashMap<>();

        hm.put("丽丽",new Student("丽丽",20));
        hm.put("小明",new Student("小明",21));
        hm.put("小红",new Student("小红",22));

        Set<Map.Entry<String,Student>> entries = hm.entrySet();
        Iterator<Map.Entry<String,Student>> iterator = entries.iterator();

        System.out.println("-----------------");
        while(iterator.hasNext()){
            Map.Entry<String,Student> next = iterator.next();
            System.out.println(next.getKey() + "-" + next.getValue());
        }
    }

}

class Student{
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}