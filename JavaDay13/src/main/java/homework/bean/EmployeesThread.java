package homework.bean;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName EmployeesThread
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/3/5 18:35
 * @Version 1.0
 */
public class EmployeesThread implements Callable<Integer> {

    private  int count = 1;
    private  final ReentrantLock lock = new ReentrantLock();

    @Override
    public Integer call(){
        int num = 0;
        while (true) {
            lock.lock();
            try {
                if (count > 100) {
                    lock.unlock(); //注意解锁!!!!!!!!!
                    break;
                }

                //编号为: 2 的员工 从后门 入场! 拿到的双色球彩票号码是:[17, 24, 29, 30, 31, 32, 07]
                System.out.println("编号为:" +count +" 的员工,从 "+
                        Thread.currentThread().getName() + " 入场! 拿到的双色球彩票号码是:"+
                        DoubleColorBallUtil.create());
                num++;
                count++;
            } finally {
                lock.unlock();
            }


        }

        return num;
    }
}
