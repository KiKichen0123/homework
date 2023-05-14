package TankGame06;


import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;

/**
 * 该程序的说明如下：
 */
public class TankGame06 extends JFrame{
    MyPanel mp = null;
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        TankGame06 tankGame05 = new TankGame06();
    }

    public TankGame06() {
        System.out.println("请输入选择 1：新游戏 2：继续上局");
        String key = in.next();
        mp = new MyPanel(key);
        Thread thread = new Thread(mp);
        thread.start();
        this.add(mp);
        this.setSize(1300,950);
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        //在JFrame中增加相应关闭窗口的处理
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Recorder.keepRecord();  //在监听到窗口关闭的时候，将信息保存到recordFile
                System.exit(0);
            }
        });
    }
}
