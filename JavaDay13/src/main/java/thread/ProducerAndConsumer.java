package thread;

import thread.bean.Cooker;
import thread.bean.Desk;
import thread.bean.Foodie;

/**
 * @ClassName ProducerAndConsumer
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/3/6 9:39
 * @Version 1.0
 */
public class ProducerAndConsumer {
    public static void main(String[] args) {
        Desk desk = new Desk();
        new Cooker(desk).start();
        new Foodie(desk).start();

    }
}
