package Thread02;

/**
 * 该程序的说明如下：
 */
public class Dog implements Runnable{

    int count = 0;
    @Override
    public void run() {
        while(true){
            System.out.println("小狗汪汪叫..hi" + (++count)+Thread.currentThread().getName());

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if(count == 10){
                break;
            }
        }
    }
}
