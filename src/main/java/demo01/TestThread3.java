package demo01;

/**
 * @Author WangFuKun
 * @create 2020/10/25 9:12
 */
//创建线程方式2：实现runnable接口，重写run方法，执行线程需要丢入接口实现，调用start方法
public class TestThread3 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 2000; i++) {
            System.out.println("我在看代码");
        }
    }

    public static void main(String[] args) {
        TestThread3 testThread3 = new TestThread3();
        new Thread(testThread3).start();
        for (int i = 0; i < 2000; i++) {
            System.out.println("我在学习多线程" + i);
        }
    }
}