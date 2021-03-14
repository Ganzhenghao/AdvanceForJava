package semaphore;

/**
 * @ClassName SemaphoreStudy
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/3/6 18:20
 * @Version 1.0
 */
public class SemaphoreStudy {
    public static void main(String[] args) {
        Car car = new Car();

        for (int i = 0; i < 20; i++) {
            new Thread(car).start();
        }

    }
}
