package thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName IceCream
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/3/6 15:08
 * @Version 1.0
 */
public class IceCream implements Runnable{
    private AtomicInteger count = new AtomicInteger(); //送冰淇淋的数量
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            //1,从共享数据中读取数据到本线程栈中.
            //2,修改本线程栈中变量副本的值
            //3,会把本线程栈中变量副本的值赋值给共享数据.
            System.out.println("已经送了" + count.incrementAndGet() + "个冰淇淋");
        }
    }
}
