package exam;

import exam.bean.ProgramCount;

/**
 * @ClassName Three
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/3/7 14:20
 * @Version 1.0
 */
public class Three {
    public static void main(String[] args) {
        /*
        设计一个程序，记录当前程序开启的次数。
        当程序第一次启动的过程当中，显示 第1次使用该程序
        当程序第二次启动的过程当中，显示 第2次使用该程序
        当程序第三次启动的过程当中，显示 第3次使用该程序
        当程序第四次启动的过程当中，显示 第4次使用该程序
        当程序第五次启动的过程当中，显示 您的使用次数已经达到试用上限，请充值后继续使用。
         */
        final ProgramCount programCount = new ProgramCount();
        for (int i = 0; i < 5; i++) {
            new Thread(programCount).start();
        }


    }
}
