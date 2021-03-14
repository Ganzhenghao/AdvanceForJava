package blockingQueue;

import lombok.AllArgsConstructor;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @ClassName Foodie
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/3/6 9:33
 * @Version 1.0
 */
@AllArgsConstructor
public class Foodie extends Thread{

    private final ArrayBlockingQueue<String> queue;


    @Override
    public void run() {
        while (true) {
            try {
                queue.take();
                System.out.println("吃货吃了一个汉堡!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
