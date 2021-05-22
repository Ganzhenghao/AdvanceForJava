package reactor;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

/**
 * @author Ganzhenghao
 * @version 1.0
 * @date 2021/5/21 14:33
 */
public class 生产者处理器订阅者模型 {
    public static void main(String[] args) {

        // 1. 定义生产者
        SubmissionPublisher<String> publisher = new SubmissionPublisher<>();

        // 2.定义处理器
        ReactiveProcessor processor = new ReactiveProcessor();

        // 3. 定义订阅者
        Flow.Subscriber<String> subscriber = new Flow.Subscriber<String>() {

            private Flow.Subscription subscription;

            @Override
            public void onSubscribe(Flow.Subscription subscription) {
                // 1. 第一次订阅 publisher会调用此方法 并传入subscription
                this.subscription = subscription;
                // 2.请求数据  --> 背压
                // 将给定数量的项n添加到此订阅的当前未满足需求中。 如果n小于或等于零，则订阅服务器将收到带有IllegalArgumentException参数的onError信号。 否则，订阅服务器将最多收到n个onNext调用（如果终止则更少）。
                //参数：n –需求增量； Long.MAX_VALUE的值可以视为有效无界
                subscription.request(10L);

            }

            @Override
            public void onNext(String item) {
                // 传入数据调用一次这个方法
                System.out.println("订阅者 收到数据 开始处理 ...  ====> " + item +" ---------------------");

                // 业务处理花费的时间 .....


                //请求新的数据  -->背压
                // 将给定数量的项n添加到此订阅的当前未满足需求中。 如果n小于或等于零，则订阅服务器将收到带有IllegalArgumentException参数的onError信号。 否则，订阅服务器将最多收到n个onNext调用（如果终止则更少）。
                //参数：n –需求增量； Long.MAX_VALUE的值可以视为有效无界
                subscription.request(10L);

            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("订阅体系出现异常...");
            }

            @Override
            public void onComplete() {
                //数据传输完成后调用此方法
                System.out.println("数据传输完成....");
            }
        };

        // 3. 建立生产者和处理器的订阅关系
        publisher.subscribe(processor);

        // 4. 建立处理器和订阅者的订阅关系
        processor.subscribe(subscriber);

        // 4. 发送数据
        for (int i = 1; i <= 100; i++) {
            String item = "Data No : " + i;
            System.out.println("生产者 发布数据 ==> " +item);
            publisher.submit(item);
        }

        // 这里是为了显示控制台打印 避免主线程执行完直接就退出程序
        /*
            join方法的作用是阻塞，即等待线程结束，才继续执行.
            t.join() 的作用是 谁执行t.join()方法就等待t执行完毕。

            Thread.currentThread().join()；
            线程一直在阻塞，无法终止。自己等待自己结束。
         */
        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



    }
}
