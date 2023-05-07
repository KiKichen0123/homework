package TankGame04;

/**
 * 该程序的说明如下：
 */
public class Shot implements Runnable{
    int x;
    int y;
    int direct = 0;
    int speed = 2;  //移动
    boolean isLive = true;

    public Shot(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
    }

    @Override
    public void run() {
        while(true){

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            switch (direct){
                case 0://上
                    y -= speed;
                    break;
                case 1://右
                    x += speed;
                    break;
                case 2://下
                    y += speed;
                    break;
                case 3://左
                    x -= speed;
                    break;
            }
             //当子弹移动到面板的边界时，就应该销毁（把启动的子弹的线程销毁）
            //当子弹碰到敌人坦克时，也应该结束线程
            if(!(x >= 0 && x <= 1000 && y >= 0 && y <=750 && isLive)){
                isLive = false;
                break;
            }
        }
    }


}
