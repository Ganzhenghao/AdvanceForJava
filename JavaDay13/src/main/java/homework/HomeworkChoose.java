package homework;

import homework.bean.CupThread;
import homework.bean.EmployeesThread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @ClassName HomeworkChoose
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/3/5 18:21
 * @Version 1.0
 */
public class HomeworkChoose {
    public static void main(String[] args) {
        //有100个限量版的水杯，但是只能通过实体店和官网才能进行购买，并且分别统计卖了多少。
        // 请用线程进行模拟并设置线程名称用来代表售出途径，再将信息打印出来。比如（实体店卖出第1个，总共剩余n个..）

        //mayOne();

        //某公司组织年会，会议入场时有两个入口，在入场时每位员工都能获取一张双色球彩票，假设公司有100个员工，
        // 利用多线程模拟年会入场过程，并分别统计每个入口入场的人数,以及每个员工拿到的彩票的号码。线程运行后打印 格式如下：
        //编号为: 2 的员工 从后门 入场! 拿到的双色球彩票号码是:[17, 24, 29, 30, 31, 32, 07]
        // 编号为: 1 的员工 从后门 入场!拿到的双色球彩票号码是:[06, 11, 14, 22, 29, 32, 15]
        // ..... 从后门入场的员工总共: 13 位员工 从前门入场的员工总共: 87 位员工

        mayTwo();

    }

    private static void mayTwo() {
        EmployeesThread employeesThread = new EmployeesThread();
        FutureTask<Integer> task1 = new FutureTask<>(employeesThread);
        FutureTask<Integer> task2 = new FutureTask<>(employeesThread);
        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);


        t1.setName("后门");
        t2.setName("前门");
        t1.start();
        t2.start();

        try {
            System.out.println("从后门入场的员工总共: "+ task1.get() +" 位员工 从前门入场的员工总共: "+ task2.get() +" 位员工");
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static void mayOne() {
        CupThread cupThread = new CupThread();
        Thread t1 = new Thread(cupThread);
        Thread t2 = new Thread(cupThread);
        t1.setName("实体店");
        t2.setName("官网");
        t1.start();
        t2.start();
    }


}
