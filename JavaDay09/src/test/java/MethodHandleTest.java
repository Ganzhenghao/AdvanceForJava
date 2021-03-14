import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.Objects;

/**
 * @ClassName MethodHandleTest
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/2/28 11:07
 * @Version 1.0
 */
public class MethodHandleTest {
    public static void main(String[] args) {
        MethodHandle sayMethod = null ;
        try {
            sayMethod = MethodHandles.lookup().
                    findVirtual(MethodHandleTest.class, "say",
                            MethodType.methodType(void.class, String.class));
        } catch (NoSuchMethodException | IllegalAccessException e) {
            e.printStackTrace();
        }
        try {
            Objects.requireNonNull(sayMethod).invoke(new MethodHandleTest(),"Hello word");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }


    public void say(String message) {
        System.out.println("message = " + message);
    }

}
