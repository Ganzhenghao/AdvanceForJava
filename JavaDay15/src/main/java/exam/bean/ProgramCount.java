package exam.bean;

/**
 * @ClassName ProgramCount
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/3/7 14:21
 * @Version 1.0
 */
public class ProgramCount implements Runnable{

    private int count = 0;


    @Override
    public void run() {

        synchronized (this){
            count++;
            if (count < 5){
                System.out.println("第"+count+"次使用该程序");
            }else{
                System.out.println("您的使用次数已经达到试用上限，请充值后继续使用");
            }
        }

    }
}
