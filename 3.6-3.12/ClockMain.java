import java.util.Scanner;
//有秒计时的数字时钟
public class ClockMain {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Clock clock = new Clock(in.nextInt(),in.nextInt(),in.nextInt());
        clock.tick();
        System.out.println(clock);
        in.close();
    }
}

class Display{
    private int value = 0;
    private int limit = 0;

    public Display(int limit){  //构造函数，一开始就输入限定值
        this.limit = limit;
    }

    public void toValue(int value){ //自定义方法，为了给对象的value赋值，因为是private的
        this.value = value;
    }

    public void increase(){ //时间增长
        value++;
        if(value == limit){
            value = 0;
        }
    }

    public int getvalue(){  //获取当前时间的值
        return value;
    }
}

class Clock {
    //定义初始变量
    private Display hour = new Display(24);
    private Display minute = new Display(60);
    private Display second = new Display(60);

    //定义构造函数
    public Clock(int hour,int minute,int second){
        this.hour.toValue(hour);
        this.minute.toValue(minute);
        this.second.toValue(second);
    }

    //滴答以下，加一秒，还要判断是否到达了限制
    public void tick(){
        second.increase();
        if(second.getvalue()==0){
            minute.increase();
            if(minute.getvalue()==0){
                hour.increase();
            }
        }
    }

    public String toString(){   //把int型数据转换成String型
        String time = new String();
        time = String.format("%2d:%2d:%2d\n",hour.getvalue(),minute.getvalue(),second.getvalue());
        return time;
    }

}
