package thread;

/**
 * @ClassName Girl
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/3/6 14:28
 * @Version 1.0
 */
public class Girl extends Thread{
    @Override
    public void run() {

        while (true){
            synchronized (Money.LOCK){
                if (Money.money != 100000){
                    System.out.println("余额不为十万了");
                    break;
                }
            }
        }
    }
}
