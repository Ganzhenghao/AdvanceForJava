package anno;

/**
 * @ClassName UseTest
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/3/12 9:41
 * @Version 1.0
 */
public class UseTest {

    //没有使用Test注解
    public void show(){
        System.out.println("UseTest....show....");
    }

    //使用Test注解
    @MyTest
    public void method(){
        System.out.println("UseTest....method....");
    }


    //没有使用Test注解
    @MyTest
    public void function(){
        System.out.println("UseTest....function....");
    }
}
