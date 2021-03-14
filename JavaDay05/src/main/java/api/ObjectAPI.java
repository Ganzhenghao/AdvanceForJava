package api;

import DuotaiAndJicheng.Father;
import org.junit.Test;

import java.util.Objects;

/**
 * @ClassName ObejectAPI
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/2/21 10:23
 * @Version 1.0
 */
public class ObjectAPI {

    @Test
    public void objects() {
        Father father1 = new Father();
        Father father2 = new Father();
        System.out.println("father1 = " + father1);
        System.out.println("father2 = " + father2);
        System.out.println("father1.equals(father2) = " + father1.equals(father2));
        father1 = null;
        System.out.println("set father1 = null ");
        System.out.println("Objects.isNull(father1) = " + Objects.isNull(father1));
        System.out.println("Objects.nonNull(father1) = " + Objects.nonNull(father1));
        System.out.println("Objects.equals(father1, \"Father1 Null\") = " + Objects.equals(father1, "Father1 Null"));
        System.out.println("Objects.equals(father1, father2) = " + Objects.equals(father1, father2));
    }


}
