package Homework;

/**
 * @author 陈淇淇
 * @version 1.8
 */
public class Hero extends Tank {
    Shot shot = null;

    public Hero(int x, int y) {
        super(x, y);
    }


    public void shotEnemyTank(){
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
        new Thread(shot).start();
    }
}
