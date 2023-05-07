package TankGame04;

import java.util.Vector;

/**
 * @author 陈淇淇
 * @version 1.8
 */
public class Hero extends Tank {
    Shot shot = null;
//    boolean isLive = true;
    //可以发射多颗子弹
    Vector<Shot> shots = new Vector<>();
    public Hero(int x, int y) {
        super(x, y);
    }


    public void shotEnemyTank(){

        //假设最多只能发5颗子弹
        if(shots.size() == 5){
            return;
        }
        //创建Shot对象，根据当前Hero对象的位置和方向来创建Shot
        switch (getDirect()){
            case 0://上
                shot = new Shot(getX() + 20,getY(),0);
                break;
            case 1://右
                shot = new Shot(getX()+60,getY()+20,1);
                break;
            case 2://下
                shot = new Shot(getX()+20,getY()+60,2);
                break;
            case 3://左
                shot = new Shot(getX(),getY()+20,3);
                break;
        }
        //把新创建的shot放入到shots
        shots.add(shot);
        new Thread(shot).start();
    }
}
