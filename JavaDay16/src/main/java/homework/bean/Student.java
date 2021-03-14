package homework.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Student
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/3/9 16:23
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String name;
    private int age;

    public void show() {
        System.out.println("大家好,我是"+name+",今年"+age+"岁了");
    }
}
