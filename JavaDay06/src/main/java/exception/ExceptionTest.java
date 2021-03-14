package exception;

import org.junit.Test;

import java.util.Scanner;

/**
 * @ClassName ExceptionTest
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/2/23 14:49
 * @Version 1.0
 */
public class ExceptionTest {
    @Test
    public void exceptionTest() {

        while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("please input a number: ");
                String nextLine = sc.nextLine();
                if ("exit".equals(nextLine)) {
                    System.exit(0);
                }
                System.out.println("异常之前的代码");
                int i = Integer.parseInt(nextLine);
                int num = 10 / 0;
                System.out.println("try里面最后一行代码");
            } catch (NumberFormatException e) {
                System.out.println("捕获到了数字重构异常");
            } catch (ArithmeticException e) {
                System.out.println("捕获到了 算数异常");
            }
            System.out.println("try catch 之外的代码");
        }
    }

    @Test
    public void testMethodName() {
        Object[] objects = {};
        System.out.println(objects.length);
    }
}
