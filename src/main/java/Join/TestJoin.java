package Join;

/**
 * @Author WangFuKun
 * @create 2020/10/26 15:15
 */
//测试join方法，想象为插队
public class TestJoin implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i <1000 ; i++) {
            System.out.println("线程Vip来了"+i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //启动我们的线程
        TestJoin testJoin = new TestJoin();
        Thread thread = new Thread(testJoin);
        thread.start();
        for (int i = 0; i <500 ; i++) {
            if (i==200){
                thread.join();
            }
            System.out.println("main"+i);
        }
    }
}