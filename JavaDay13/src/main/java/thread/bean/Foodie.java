package thread.bean;

import lombok.AllArgsConstructor;

/**
 * @ClassName Foodie
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/3/6 9:33
 * @Version 1.0
 */
@AllArgsConstructor
public class Foodie extends Thread{

    private Desk desk;


    @Override
    public void run() {
        while (true){

            //Desk.lock.lock();

            synchronized (desk.getLock()) {

                if (desk.getCount() == 0) {
                    //Desk.lock.unlock();
                    break;
                }
                if (desk.isFlag()) {
                    System.out.println("吃货吃了一个汉堡");
                    desk.setFlag(false);
                    desk.setCount(desk.getCount()-1);
                    desk.getLock().notifyAll();
                } else {
                    try {
                        desk.getLock().wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            //Desk.lock.unlock();


        }
    }
}
