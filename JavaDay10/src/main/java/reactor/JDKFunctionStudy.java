package reactor;

import java.util.function.*;

/**
 * @author Ganzhenghao
 * @version 1.0
 * @date 2021/5/21 10:41
 */
public class JDKFunctionStudy {

    public static void main(String[] args) {

        // 1.Supplier<T> 没有输入 只有一个输出
        Supplier<String> supplier = () -> "supplier output...";
        System.out.println(supplier.get());
        // 2. Consumer<T> 只有输入 没有输出
        Consumer<String> consumer = param -> System.out.println("this is Consumer args: " + param);
        consumer.accept("consumer.....");
        // 3. Function<T,R> 将 T 转换为 R 后返回
        Function<String ,Integer> function = param -> Integer.parseInt(param);
        System.out.println(function.apply("2"));
        // 4. UnaryOperator<T> 将 T 类型的输入 操作后 再次输出
        UnaryOperator<String> unaryOperator = param -> param + "   ...  0.0  ...";
        System.out.println(unaryOperator.apply("unaryOperator"));
        // 5. BiFunction<T, U, R> 将 T类型 和 U类型的两个参数 操作后 转换为 R类型输出
        BiFunction<Integer,Double,String> biFunction =
                (param1,param2) -> "param1(Integer - > String) : "+ param1 + " || param2(Double - > String)" + param2;
        System.out.println(biFunction.apply(12, 12.5));

    }

}
