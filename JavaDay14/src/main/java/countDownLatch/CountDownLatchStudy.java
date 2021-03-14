package countDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * @ClassName CountDownLatchStudy
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/3/6 18:14
 * @Version 1.0
 */
public class CountDownLatchStudy {
    public static void main(String[] args) {

        CountDownLatch latch = new CountDownLatch(3);

        Mother mother = new Mother(latch);
        mother.setName("Mother");

        Child child1 = new Child(latch);
        Child child2 = new Child(latch);
        Child child3 = new Child(latch);

        child1.setName("大小毛");
        child2.setName("二小毛");
        child3.setName("三小毛");

        child1.start();
        child2.start();
        child3.start();
        mother.start();

    }
}
