package Sleep;



/**
 * @Author WangFuKun
 * @create 2020/10/26 11:34
 */
//模拟网络延时
//多个线程同时操作同一个对象
//买火车票的例子
public class TestSleep implements Runnable {

    private int ticketNumbers = 10;

    @Override
    public void run() {
        while (true) {
            if (ticketNumbers <= 0) {
                break;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "-->拿到了第" + ticketNumbers + "--票");
            ticketNumbers--;
        }
    }

    public static void main(String[] args) {
        TestSleep sleep = new TestSleep();
        new Thread(sleep, "1").start();
        new Thread(sleep, "2").start();
        new Thread(sleep, "3").start();
    }
}