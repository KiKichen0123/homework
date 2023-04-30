package Thread02;

/**
 * 该程序的说明如下：
 */
public class ThreadProxy implements Runnable{
    private Runnable target = null;

    @Override
    public void run() {
        target.run();
    }

    public ThreadProxy(Runnable target) {
        this.target = target;
    }

    public void start(){
        start0();
    }

    public void start0(){
        run();
    }
}
