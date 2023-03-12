import java.util.Scanner;
//设计一个表示分数的类Fraction。这个类用两个int类型的变量分别表示分子和分母。
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Fraction a = new Fraction(in.nextInt(), in.nextInt());
        Fraction b = new Fraction(in.nextInt(), in.nextInt());
        a.print();
        b.print();
        a.plus(b).print();
        a.multiply(b).plus(new Fraction(5, 6)).print();
        a.print();
        b.print();
        in.close();
    }
}

    class Fraction{
        int n1; //成员变量，分子
        int n2; //分母
        Fraction(int n1, int n2) {
            this.n1 = n1;
            this.n2 = n2;
        }

        double toDouble(){  //转换为double类型
            return (double)n1/n2;
        }

        Fraction plus(Fraction r){  //分数相加
            Fraction s = new Fraction(0,1); //创建对象s
            s.n1 = n1*r.n2+r.n1*n2;
            s.n2 = n2 * r.n2;
            return s;
        }

        Fraction multiply(Fraction r){  //分数相乘
            Fraction s = new Fraction(0,1);
            s.n1 = n1 * r.n1;
            s.n2 = n2 * r.n2;
            return s;
        }

        void print(){
            int r,x = n1,y=n2;
            while(x != 0){
                r = y % x;
                y = x;
                x = r;
            }
            n1 /= y;
            n2 /= y;
            if(n1 == n2){
                System.out.println(1);
            }else{
             System.out.println(n1 + "/" + n2);
            }
            return;
        }

    }

