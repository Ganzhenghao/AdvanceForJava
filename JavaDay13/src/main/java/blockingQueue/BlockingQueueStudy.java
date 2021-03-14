package blockingQueue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @ClassName BlockingQueueStudy
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/3/6 10:33
 * @Version 1.0
 */
public class BlockingQueueStudy {

    public static void main(String[] args) {
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(1);
        new Cooker(queue).start();
        new Foodie(queue).start();
    }


}
