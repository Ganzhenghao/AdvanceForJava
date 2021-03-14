package homework.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName Student
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/3/4 19:56
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable {
    /*
    请定义一个Student类，属性：姓名、性别、年龄、分数
	   无参、全参构造方法
	   get/set方法
     */
    private String name;
    private String sex;
    private int age;
    private int grade;


}
