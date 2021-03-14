package homework.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @ClassName Student
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/2/26 18:20
 * @Version 1.0
 */
@Data
@AllArgsConstructor
public class Student{
    private String id;// 学号
    private String name;// 姓名
    private String age;// 年龄
    private String address;// 居住地


}
