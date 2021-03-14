package blockingQueue;

import lombok.AllArgsConstructor;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @ClassName Cooker
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/3/6 9:32
 * @Version 1.0
 */
@AllArgsConstructor
public class Cooker extends Thread {

    private final ArrayBlockingQueue<String> queue;

    @Override
    public void run() {
        while (true) {
            try {
                queue.put("汉堡");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("厨师做了一个汉堡");
        }

    }
}
