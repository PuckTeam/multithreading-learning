package demo01;

/**
 * @Author WangFuKun
 * @create 2020/10/25 9:12
 */

//模拟龟兔赛跑
public class Race implements Runnable {
    private String winner;
    @Override
    public void run() {
        for (int i = 0; i <=1000 ; i++) {
            if (Thread.currentThread().getName().equals("兔子")&&i%10==0){
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName()+"-->跑了"+i+"--步数");
            //判断比赛是否结束
            if(gameOver(i)){
                break;

            }

        }
    }
    public boolean gameOver(int steps){
        if(winner!=null){
            return true;
        }{
            if (steps==1000){
                winner = Thread.currentThread().getName();
                System.out.println("winner is "+ winner);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Race testThread3 = new Race();
        new Thread(testThread3,"乌龟").start();
        new Thread(testThread3,"兔子").start();


    }
}