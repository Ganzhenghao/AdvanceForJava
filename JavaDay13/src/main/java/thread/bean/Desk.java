package thread.bean;

import lombok.Data;

/**
 * @ClassName Desk
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/3/6 9:33
 * @Version 1.0
 */
@Data
public class Desk {

    //public static boolean flag = false;

    private boolean flag = false;

    //public static final ReentrantLock lock = new ReentrantLock();

    //public static final Object lock = new Object();

    private final Object lock = new Object();

    //public static int count = 10;

    private int count = 10;

}
