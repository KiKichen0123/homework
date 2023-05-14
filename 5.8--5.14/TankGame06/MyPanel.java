package TankGame06;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.Vector;


/**
 * @author 陈淇淇
 * @version 1.8
 * 坦克大战的绘图区域
 */
//为了监听 键盘事件， 实现KeyListener
//为了让Panel 不停的重绘子弹，需要将 MyPanel 实现Runnable ,当做一个线程使用
public class MyPanel extends JPanel implements KeyListener,Runnable{
    Hero hero = null;   //my tank
    Vector<EnemyTank> enemyTanks = new Vector<>();
    //定义一个存放Node对象的Vector,用于恢复敌人坦克的坐标和方向
    Vector<Node> nodes = new Vector<>();
    //定义一个Vector，用于存放炸弹
    //说明，当子弹击中坦克时，加入一个Bomb对象到bombs
    Vector<Bomb> bombs = new Vector<>();
    int enemyTankSize = 3;

    //定义三张炸弹图片，用于显示爆炸效果
    Image image1 = null;
    Image image2 = null;
    Image image3 = null;

    //在游戏启动的时候，让用户传入一个值，由此来判断是否要接着上局游戏
    public MyPanel(String key){
        //先判断记录的文件是否存在
        //如果存在，就正常执行，如果文件不存在，提示，只能开启新游戏，key="1"
        File file = new File(Recorder.getRecordFile());
        if(file.exists()){
            nodes = Recorder.getNodesAndEnemyTankRec();
        }else{
            System.out.println("文件不存在，只能开启新的游戏");
            key = "1";
        }

        //将Mypanel对象的 enemyTanks 设置给 Recorder 的 enemyTanks
        Recorder.setEnemyTank(enemyTanks);
        //初始化自己坦克
        hero = new Hero(500,100);

        switch (key){
            case "1":
                Recorder.setAllEnemyTankNum(0);
                //初始化敌人坦克
                for(int i = 0;i<enemyTankSize;i++){
                    EnemyTank enemyTank = new EnemyTank((100*(i+1)),0); //相隔距离
                    //将enemyTanks 设置给 enemyTank
                    enemyTank.setEnemyTanks(enemyTanks);
                    enemyTank.setDirect(2);
                    new Thread(enemyTank).start();
                    //给该enemyTank 加入一颗子弹
                    Shot shot = new Shot(enemyTank.getX()+20,enemyTank.getY()+60,enemyTank.getDirect());
                    //加入enemyTank的Vector 成员
                    enemyTank.shots.add(shot);
                    //启动shot对象
                    new Thread(shot).start();
                    //加入
                    enemyTanks.add(enemyTank);
                }
                break;
            case "2":   //继续上局游戏

                //初始化敌人坦克
                for(int i = 0;i<nodes.size();i++){
                    Node node = nodes.get(i);
                    EnemyTank enemyTank = new EnemyTank(node.getX(),node.getY()); //相隔距离
                    //将enemyTanks 设置给 enemyTank
                    enemyTank.setEnemyTanks(enemyTanks);
                    enemyTank.setDirect(node.getDirect());
                    new Thread(enemyTank).start();
                    //给该enemyTank 加入一颗子弹
                    Shot shot = new Shot(enemyTank.getX()+20,enemyTank.getY()+60,enemyTank.getDirect());
                    //加入enemyTank的Vector 成员
                    enemyTank.shots.add(shot);
                    //启动shot对象
                    new Thread(shot).start();
                    //加入
                    enemyTanks.add(enemyTank);
                }
                break;
            default:
                System.out.println("你的输入有误....");
        }



        //初始化图片对象
        image1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_1.gif"));
        image2 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_2.gif"));
        image3 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_3.gif"));

        //这里，播放指定的音乐
        new AePlayWave("src\\111.wav").start();
    }





    //编写方法，显示我方击毁敌方坦克的信息
    public void showInfo(Graphics g){
        //画出玩家的总成绩
        g.setColor(Color.BLACK);
        Font font = new Font("宋体",Font.BOLD,25);
        g.setFont(font);

        g.drawString("您累积击毁敌方坦克",1020,30);
        drawTank(1020,60,g,0,0);
        g.setColor(Color.BLACK);
        g.drawString(Recorder.getAllEnemyTankNum() + "",1080,100);
    }

    public void paint(Graphics g){
        super.paint(g);
        g.fillRect(0,0,1000,750);
        showInfo(g);
        if(hero != null && hero.isLive) {
            drawTank(hero.getX(), hero.getY(), g, hero.getDirect(), 1);
        }
        //画出射击子弹
        if(hero.shot !=null && hero.shot.isLive == true){
            g.drawRect(hero.shot.x,hero.shot.y,1,1);
        }
        //将hero的子弹集合 shots ,遍历取出绘制
//        for(int i = 0;i<hero.shots.size();i++){
//            Shot shot = hero.shots.get(i);
//            if(shot != null && shot.isLive){
//                g.drawRect(shot.x,shot.y,1,1);
//            }else{
//                hero.shots.remove(shot);
//            }
//        }

        //如果bombs集合中有对象，就画出
        for(int i = 0;i<bombs.size();i++){
            //取出炸弹
            Bomb bomb = bombs.get(i);
            //根据当前这个bomb对象的life值去画出对应的图片
            if(bomb.life>6) {
                g.drawImage(image1, bomb.x, bomb.y, 60,60,this);
            }else if(bomb.life > 3){
                g.drawImage(image2, bomb.x, bomb.y,60,60,this);
            }else{
                g.drawImage(image3, bomb.x, bomb.y,60,60, this);
            }
            //让生命值减少
            bomb.lifeDown();
            //如果bomb life为0，就从bombs的集合中删除
            if(bomb.life == 0){
                bombs.remove(bomb);
            }
        }

        //画出敌人的坦克，遍历vector
        for(int i = 0;i<enemyTanks.size();i++){
            EnemyTank enemyTank = enemyTanks.get(i);
            if(enemyTank.isLive) {
                drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirect(), 0);

                //画出enemyTank所有子弹
                for (int j = 0; j < enemyTank.shots.size(); j++) {
                    //取出子弹
                    Shot shot = enemyTank.shots.get(j);
                    //绘制
                    if (shot.isLive) {
                        g.draw3DRect(shot.x, shot.y, 1, 1, false);
                    } else {
                        enemyTank.shots.remove(shot);
                    }
                }
            }
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

    //如果我们的坦克可以发射多个子弹
    //在判断我方子弹是否击中敌人坦克时，就需要把我们的子弹集合中
    //所有的子弹，都取出和敌人的所有坦克，进行判断

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyCode());
        if(e.getKeyCode() == KeyEvent.VK_W){
            hero.setDirect(0);
            if(hero.getY() > 0) {
                hero.moveUp();
            }
        }else if(e.getKeyCode() == KeyEvent.VK_D){
            hero.setDirect(1);
            if(hero.getX() + 60 < 1000) {
                hero.moveRight();
            }
        }else if(e.getKeyCode() == KeyEvent.VK_S){
            hero.setDirect(2);
            if(hero.getY() + 60 < 750) {
                hero.moveDown();
            }
        }else if(e.getKeyCode() == KeyEvent.VK_A){
            hero.setDirect(3);
            if(hero.getX() > 0) {
                hero.moveLeft();
            }
        }

        if(e.getKeyCode() == KeyEvent.VK_J){
            //判断hero的子弹是否销毁,发射一颗子弹
//            if(hero.shot == null || !hero.shot.isLive){
//                hero.shotEnemyTank();
//            }
            //发射多颗子弹
            hero.shotEnemyTank();

        }
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
    //问题：在打出多个子弹的时候，有些子弹打到了敌方坦克，但是没有爆炸
    //解决：

    public void hitEnemyTank(){
        //遍历子弹
//        for(int j = 0;j < hero.shots.size();j++){
//            Shot shot = hero.shots.get(j);
//            if(shot != null && shot.isLive){
//                //遍历敌人坦克
//                for(int i = 0;i<enemyTanks.size();i++){
//                    EnemyTank enemyTank = enemyTanks.get(i);
//                    hitTank(shot,enemyTank);
//                }
//            }
//        }
        //判断是否击中了敌人坦克
        //每颗子弹去判断
        if(hero.shot !=null && hero.shot.isLive){
            for(int i = 0;i<enemyTanks.size();i++){
                EnemyTank enemyTank = enemyTanks.get(i);
                hitTank(hero.shot,enemyTank);
            }
        }
    }

    //编写方法，判断敌人坦克是否击中我的坦克
   public void hitHero(){
     //遍历所有的敌人坦克
     for(int i = 0;i < enemyTanks.size();i++){
         EnemyTank enemyTank = enemyTanks.get(i);
         for(int j = 0;j < enemyTank.shots.size();j++){
             //取出子弹
             Shot shot = enemyTank.shots.get(j);
             //判断 shot 是否击中我的坦克
             if(hero.isLive && shot.isLive){
                 hitTank(shot,hero);
             }
         }
     }
   }

    //编写方法，判断我方的子弹是否击中敌人坦克
    //什么时候判断：在run方法中不停重绘时候判断
    public void hitTank(Shot s, Tank enemyTank){
        //判断s击中坦克
        switch (enemyTank.getDirect()){
            case 0: //向上
            case 2: //向下
                if(s.x > enemyTank.getX() && s.x < enemyTank.getX() + 40
                && s.y > enemyTank.getY() && s.y < enemyTank.getY() + 60){
                    s.isLive = false;
                    enemyTank.isLive = false;
                    //当我的子弹击中敌人坦克后，将enemyTank 从Vector拿掉
                    enemyTanks.remove(enemyTank);
                    //当我方击毁一个敌人坦克时，就对数据allEnemyTankNum++
                    //因为enemyTank可以是Hero也可以是EnemyTank，所以要加个判断
                    if(enemyTank instanceof EnemyTank){
                        Recorder.addAllEnemyTankNum();
                    }
                    //创建Bomb对象，加入到bombs集合
                   Bomb bomb = new Bomb(enemyTank.getX(), enemyTank.getY());
                   bombs.add(bomb);
                }
                break;
            case 1:   //向右
            case 3:   //向左
                if(s.x > enemyTank.getX() && s.x < enemyTank.getX() + 60
                && s.y > enemyTank.getY() && s.y < enemyTank.getY() + 40){
                    s.isLive = false;
                    enemyTank.isLive = false;
                    enemyTanks.remove(enemyTank);
                    if(enemyTank instanceof EnemyTank){
                        Recorder.addAllEnemyTankNum();
                    }
                    //创建Bomb对象，加入到bombs集合
                    Bomb bomb = new Bomb(enemyTank.getX(), enemyTank.getY());
                    bombs.add(bomb);
                }
                break;
        }
    }

    public void tankMove() {
        for (int i = 0; i < enemyTanks.size(); i++) {
            EnemyTank enemyTank = enemyTanks.get(i);
            for(int j = i + 1;j<enemyTanks.size();j++){
                EnemyTank enemyTank1 = enemyTanks.get(i);
                if(enemyTank.getX() == enemyTank1.getX() && enemyTank.getY() == enemyTank1.getY()){
                    //调用停止方法
                }
            }
            }
        }



    @Override
    public void run() { //每隔100毫秒，重绘区域,不停刷新绘图区域，子弹移动
        while(true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            hitHero();
            hitEnemyTank();
            this.repaint();
        }
    }
}
