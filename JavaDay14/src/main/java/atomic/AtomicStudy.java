package atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName AtomicSutdy
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/3/6 15:30
 * @Version 1.0
 */
public class AtomicStudy {

    public static void main(String[] args) {

        AtomicInteger atomicInteger = new AtomicInteger(10);
        System.out.println("atomicInteger.getAndIncrement() = " + atomicInteger.getAndIncrement());
        System.out.println("atomicInteger.incrementAndGet() = " + atomicInteger.incrementAndGet());
        System.out.println("atomicInteger.getAndAdd(50) = " + atomicInteger.getAndAdd(50));
        System.out.println("atomicInteger.get() = " + atomicInteger.get());
    }

}
