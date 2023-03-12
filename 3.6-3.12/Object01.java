import java.util.Scanner;
public class Object01 {
    public static void main(String[] args){


        //实例化一个只猫
        //1.new Cat () 创建一只猫
        //2.cat1 代表了新创建的猫
        Cat cat1 = new Cat();
        cat1.name = "小白";
        cat1.age = 3;
        cat1.color = "白色";


        //创建第二只猫，赋给cat2
        Cat cat2 = new Cat();
        cat2.name = "桢桢";
        cat2.age = 22;
        cat2.color = "黄色";

        //访问对象的属性
        System.out.println("第一只猫信息，名字叫" + cat1.name
                + " 年龄："+ cat1.age + " 颜色是"+ cat1.color);

        System.out.println("第二只猫信息，名字叫" + cat2.name
                + " 年龄："+ cat2.age + " 颜色是"+ cat2.color);

        int n;
        Scanner in = new Scanner(System.in);
        System.out.println("请输入要猫猫计算的要累加和的值：");
        n = in.nextInt();
        cat1.cal(n);
    }
}

class Cat{  //定义一个猫类 Cat  —> 自定义的数据类型
    //属性
    String name;
    int age;
    String color;

    /*1.public 表示方法是公开
      2.void 表示方法没有返回值
      3.speak() speak是方法名，()是形参列表
      4.{} 方法体，写要执行的代码
     */
    public void speak(){
        System.out.println("喵喵喵");
    }

    //会计算的猫猫
    //1.(int n)形参列表，表示当前有一个形参n，可以接收用户输入
    public void cal(int n){
        int res = 0;
        for(int i = 0;i <= n;i++){
            res += i;
        }
        System.out.println("猫猫计算出的值为"+ res);
    }
}
