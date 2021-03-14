package thread.bean;

import lombok.AllArgsConstructor;

/**
 * @ClassName Cooker
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/3/6 9:32
 * @Version 1.0
 */
@AllArgsConstructor
public class Cooker extends Thread{

    private final Desk desk;

    @Override
    public void run() {

        while (true){

            //Desk.lock.lock();
            synchronized (desk.getLock()){
                if (desk.getCount() == 0){
                    //Desk.lock.unlock();
                    break;
                }

                if (desk.isFlag()){
                    try {
                        desk.getLock().wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else{
                    System.out.println("厨师做了一个汉堡");
                    desk.setFlag(true);
                    desk.getLock().notifyAll();
                }
            }

            //Desk.lock.unlock();

        }


    }
}
