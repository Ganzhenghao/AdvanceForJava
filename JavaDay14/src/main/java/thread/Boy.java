package thread;

/**
 * @ClassName Boy
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/3/6 14:29
 * @Version 1.0
 */
public class Boy extends Thread {
    @Override
    public void run() {

        synchronized (Money.LOCK) {
            try {
                Thread.sleep(100);

                Money.money = 90000;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
