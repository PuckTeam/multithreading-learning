package state;

/**
 * @Author WangFuKun
 * @create 2020/10/26 11:02
 */
//测试Stop
    //1.建议线程正常停止，不建议使用死循环
    //2.建议不要使用标志位，设置一个标志位
    //3.不要使用stop或者destory或者jdk不建议使用的方法
public class TestStop implements Runnable {
    private boolean flag = true;
    @Override
    public void run() {
        int i = 0 ;
        while(flag){
            System.out.println("run Thread"+i);
            i++;
        }
    }
    //设置一个公开的方法停止线程，转换标志位
    public void stop(){
        this.flag = false;
    }

    public static void main(String[] args) {
        TestStop stop = new TestStop();
        new Thread(stop).start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("main");
            if (i==900){
                stop.stop();
                System.out.println("该线程停止了");
            }
        }
    }
}