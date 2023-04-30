package Thread02;

/**
 * 该程序的说明如下：
 */
public class Tiger extends Animal implements Runnable{

    @Override
    public void run() {
        System.out.println("老虎嗷嗷叫...");
    }
}
