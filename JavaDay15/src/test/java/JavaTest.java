import org.junit.Test;

/**
 * @ClassName JaavaTest
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/3/8 18:10
 * @Version 1.0
 */
public class JavaTest {

    @Test
    public void one() {
        new Two();
    }

}

class One{
    int i = 15;
    {
        System.out.println("");
    }
}

class Two extends One{
    static {
        System.out.println("静态代码块执行了");
    }
    public Two() {
        System.out.println("new了一个新对象");
    }
}

class Three extends Two{
    public void say(){
        System.out.println(i);
    }
}

interface A{
    public static final int i = 0;
}