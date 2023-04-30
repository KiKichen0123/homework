import javax.swing.*;
import java.awt.*;

/**
 * @author 陈淇淇
 * @version 1.8
 */
public class DrawCircle extends JFrame {      //例如一个画框
    private MyPanel mp = null;  //一个面板

    public static void main(String[] args){
        new DrawCircle();
    }

    public DrawCircle(){
        mp = new MyPanel(); //初始化面板
        this.add(mp);   //把面板放入到窗口
        this.setSize(400,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //当点击窗口的小X，程序完全退出
        this.setVisible(true);  //显示

    }
}

class MyPanel extends JPanel{   //继承Jpanel，画图形

    //Graphics g 把g 理解成一支画笔,Graphics 提供了很多绘图的方法
    public void paint(Graphics g){//绘画方法
        super.paint(g);
        g.drawOval(10,10,100,100); //圆形
        g.drawLine(10,10,100,100);  //直线
        g.drawRect(10,10,100,100);//矩形边框

        g.setColor(Color.blue); //画笔颜色
        g.fillRect(10,10,100,100);//填充矩形

        g.setColor(Color.red);
        g.fillOval(10,10,100,100);//填充椭圆

        //画图片
        Image image = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/泛型.png"));
        g.drawImage(image,300,300,500,500,this);

        //画字符串
        //画笔颜色
        g.setColor(Color.red);
        //画笔字体
        g.setFont(new Font("黑体",Font.BOLD,50));
        g.drawString("hello,world",100,50);


    }
}