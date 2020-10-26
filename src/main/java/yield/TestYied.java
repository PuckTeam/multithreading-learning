package yield;

/**
 * @Author WangFuKun
 * @create 2020/10/26 15:02
 */
//测试礼让线程
//礼让不一定成功，主要看cpu心情
public class TestYied {
    public static void main(String[] args) {
        MyYueld myYueld = new MyYueld();
        new Thread(myYueld,"a").start();
        new Thread(myYueld,"b").start();

    }
}
class MyYueld implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"线程开始执行");
        Thread.yield();
        System.out.println(Thread.currentThread().getName()+"线程开始执行");
    }
}