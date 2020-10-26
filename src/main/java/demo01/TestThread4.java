package demo01;

/**
 * @Author WangFuKun
 * @create 2020/10/25 9:12
 */
//多个线程同时操作同一个对象
//买火车票的例子
public class TestThread4 implements Runnable {
    private int ticketNumbers = 10;
    @Override
    public void run() {
       while(true){
           if (ticketNumbers<=0){
               break;
           }
           try {
               Thread.sleep(200);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           System.out.println(Thread.currentThread().getName()+"-->拿到了第"+ticketNumbers+"--票");
           ticketNumbers--;
       }
    }

    public static void main(String[] args) {
        TestThread4 testThread3 = new TestThread4();
        new Thread(testThread3,"小明").start();
        new Thread(testThread3,"老师").start();
        new Thread(testThread3,"黄牛党").start();

    }
}