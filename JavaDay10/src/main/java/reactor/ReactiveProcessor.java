package reactor;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

/**
 * @author Ganzhenghao
 * @version 1.0
 * @date 2021/5/21 14:58
 */
public class ReactiveProcessor extends SubmissionPublisher<String> implements Flow.Subscriber<String> {

    private Flow.Subscription subscription;

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        System.out.println("处理器建立订阅关系.......");
        // 1. 第一次订阅 publisher会调用此方法 并传入subscription
        this.subscription = subscription;
        // 2.请求数据  --> 背压
        // 将给定数量的项n添加到此订阅的当前未满足需求中。 如果n小于或等于零，则订阅服务器将收到带有IllegalArgumentException参数的onError信号。 否则，订阅服务器将最多收到n个onNext调用（如果终止则更少）。
        //参数：n –需求增量； Long.MAX_VALUE的值可以视为有效无界
        subscription.request(1L);

    }

    @Override
    public void onNext(String item) {
        // 传入数据调用一次这个方法
        System.out.println("处理器 收到数据 开始处理 ...  ====> " + item);
        item = item + "被 Processor处理过了...";
        // 将数据发给最终订阅者
        this.submit(item);

        subscription.request(10L);
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println("处理器出现错误了.......");
    }

    @Override
    public void onComplete() {
        System.out.println("数据发送完成 -- > Processor");
    }

}
