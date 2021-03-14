package xml.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Student
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/3/9 10:59
 * @Version 1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private String id;
    private String name;
    private int age;
    private String info;

}
