package TankGame06;

/**
 * @author 陈淇淇
 * @version 1.8
 */
public class Tank {
    private int x;
    private int y;
    private int direct; //坦克方向 0上  1右   2下  3左
    private int speed = 1;
    boolean isLive = true;

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Tank(int x, int y, int direct, int speed) {
        this.x = x;
        this.y = y;
        this.direct = direct;
        this.speed = speed;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void moveUp(){
        y -=speed;
    }

    public void moveDown(){
        y+=speed;
    }

    public void moveLeft(){
        x-=speed;
    }

    public void moveRight(){
        x+=speed;
    }
}
