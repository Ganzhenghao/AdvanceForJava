package api;

import org.junit.Test;

/**
 * @ClassName StringAPI
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/2/21 9:49
 * @Version 1.0
 */
public class StringAPI {

    @Test
    public void stringEquals() {
        String s = "abc";
        StringBuilder sb = new StringBuilder("abc");
        System.out.println("s.equals(sb) = " + s.contentEquals(sb));
        System.out.println("sb.equals(s) = " + sb.equals(s));
    }

}
