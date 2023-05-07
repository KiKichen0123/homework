package Homework;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

/**
 * @author 陈淇淇
 * @version 1.8
 */
public class MyPanel extends JPanel implements KeyListener,Runnable{
    Hero hero = null;   //my tank
    Shot shot = null;
    Vector<EnemyTank> enemyTanks = new Vector<>();
    int enemyTankSize = 3;

    public MyPanel(){
        hero = new Hero(100,100);


        for(int i = 0;i<enemyTankSize;i++){
            EnemyTank enemyTank = new EnemyTank((100*(i+1)),0); //相隔距离
            enemyTank.setDirect(2);
            enemyTanks.add(enemyTank);
        }
    }

    public void paint(Graphics g){
        super.paint(g);
        g.fillRect(0,0,1000,750);

        drawTank(hero.getX(),hero.getY(),g,hero.getDirect(),1);

        //画出射击子弹
        if(hero.shot !=null && hero.shot.isLive == true){
//            g.fill3DRect(hero.shot.x,hero.shot.y,5,5,false);
            g.drawRect(hero.shot.x,hero.shot.y,1,1);
        }

//        drawShot(shot.getX(),shot.getY(),g,shot.getDirect());

        for(int i = 0;i<enemyTanks.size();i++){
            EnemyTank enemyTank = enemyTanks.get(i);
            drawTank(enemyTank.getX(),enemyTank.getY(),g,enemyTank.getDirect(),0);
        }
    }

    /**
     *
     * @param x   坦克的左上角x坐标
     * @param y   坦克的左上角y坐标
     * @param g     画笔
     * @param direct    坦克方向（上下左右）
     * @param type  坦克类型
     */
    public void drawTank(int x,int y,Graphics g,int direct,int type){

        //根据不同类型坦克，设置不同颜色
        switch (type){
            case 0:
                g.setColor(Color.cyan);
                break;
            case 1:
                g.setColor(Color.yellow);
                break;
        }

        switch (direct){
            //向上
            case 0:
                g.fill3DRect(x,y,10,60,false);  //左边轮子
                g.fill3DRect(x+30,y,10,60,false);   //右边轮子
                g.fill3DRect(x+10,y+10,20,40,false);    //中间盖子
                g.fillOval(x+10,y+20,20,20);    //圆形盖子
                g.drawLine(x+20,y+30,x+20,y);   //炮筒
//                g.fillOval(x+20,y+30,10,10);
                break;
                //向右
            case 1:
                g.fill3DRect(x,y,60,10,false);
                g.fill3DRect(x,y+30,60,10,false);
                g.fill3DRect(x+10,y+10,40,20,false);
                g.fillOval(x+20,y+10,20,20);
                g.drawLine(x+30,y+20,x+60,y+20);
                break;
                //向下
            case 2:
                g.fill3DRect(x,y,10,60,false);  //左边轮子
                g.fill3DRect(x+30,y,10,60,false);   //右边轮子
                g.fill3DRect(x+10,y+10,20,40,false);    //中间盖子
                g.fillOval(x+10,y+20,20,20);    //圆形盖子
                g.drawLine(x+20,y+30,x+20,y+60);   //炮筒
                break;
            case 3:
                g.fill3DRect(x,y,60,10,false);
                g.fill3DRect(x,y+30,60,10,false);
                g.fill3DRect(x+10,y+10,40,20,false);
                g.fillOval(x+20,y+10,20,20);
                g.drawLine(x+30,y+20,x,y+20);
                break;
            default:
                System.out.println("暂时没有处理");
        }
    }

//    public void drawShot(int x,int y,Graphics g,int direct){
//        switch (direct){
//            case 0://上
//                g.fillOval(x+20,y+30,10,10);
//                break;
//            case 1://右
//                g.fillOval(x+30,y+20,10,10);
//                break;
//            case 2://下
//                g.fillOval(x+20,y+30,10,10);
//                break;
//            case 3://左
//                g.fillOval(x+20,y+30,10,10);
//                break;
//        }
//    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyCode());
        if(e.getKeyCode() == KeyEvent.VK_W){
            hero.setDirect(0);
            hero.moveUp();
        }else if(e.getKeyCode() == KeyEvent.VK_D){
            hero.setDirect(1);
            hero.moveRight();
        }else if(e.getKeyCode() == KeyEvent.VK_S){
            hero.setDirect(2);
            hero.moveDown();
        }else if(e.getKeyCode() == KeyEvent.VK_A){
            hero.setDirect(3);
            hero.moveLeft();
        }

        if(e.getKeyCode() == KeyEvent.VK_J){
            hero.shotEnemyTank();
        }
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() { //每隔100毫秒，重绘区域,不停刷新绘图区域，子弹移动
        while(true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.repaint();
        }
    }
}
