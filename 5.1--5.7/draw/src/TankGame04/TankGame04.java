package TankGame04;

import javax.swing.*;

/**
 * @author 陈淇淇
 * @version 1.8
 */
public class TankGame04 extends JFrame {
    MyPanel mp = null;

    public static void main(String[] args){
        TankGame04 tankGame04 = new TankGame04();
    }

    public TankGame04(){
        mp = new MyPanel();
        Thread thread = new Thread(mp);
        thread.start();
        this.add(mp);
        this.setSize(1200,950);
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

}
