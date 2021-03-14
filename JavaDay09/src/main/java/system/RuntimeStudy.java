package system;

/**
 * @ClassName RuntimeStudy
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/2/27 20:35
 * @Version 1.0
 */
public class RuntimeStudy {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        System.out.println("处理器数量:  " + runtime.availableProcessors());
        System.out.println("空闲内存: " + runtime.freeMemory() / 16 / 1024 / 16);
        System.out.println("总内存: " + runtime.totalMemory() / 16 / 1024 / 16);
        System.out.println("可用最大内存: " + runtime.maxMemory() / 16 / 1024 / 16);

    }
}
