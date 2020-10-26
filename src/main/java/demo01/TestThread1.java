package demo01;

/**
 * @Author WangFuKun
 * @create 2020/10/25 8:28
 */
public class TestThread1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i <2000 ; i++) {
            System.out.println("我在看代码");
        }
    }

    public static void main(String[] args) {
        TestThread1 testThread1 = new TestThread1();
        testThread1.start();
        for (int i = 0; i < 2000; i++) {
            System.out.println("我在学习多线程"+i);
        }
    }
}