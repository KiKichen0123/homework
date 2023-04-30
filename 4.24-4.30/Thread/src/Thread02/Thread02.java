package Thread02;

/**
 * 该程序的说明如下：
 * 实现Runnable接口
 */
public class Thread02 {
    public static void main(String[] args) {

        Dog dog = new Dog();
        Thread thread = new Thread(dog);
        thread.start();

        Tiger tiger = new Tiger();
        ThreadProxy threadProxy = new ThreadProxy(tiger);
        threadProxy.start();
    }
}

