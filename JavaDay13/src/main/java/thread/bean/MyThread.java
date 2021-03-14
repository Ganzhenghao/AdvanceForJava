package thread.bean;

/**
 * @ClassName MyThread
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/3/5 9:40
 * @Version 1.0
 */

public class MyThread extends Thread{

    private static int i = 0;

    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        i++;
        int time = i;
        for (int j = 0; j < 100; j++) {
            System.out.println(getName()+"第"+time+"个线程执行了 "+j+ "次" );
        }
    }
}
