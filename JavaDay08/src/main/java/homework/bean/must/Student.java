package homework.bean.must;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @ClassName Student
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/2/26 18:56
 * @Version 1.0
 */
@Data
@AllArgsConstructor
public class Student implements Comparable<Student>{
    /*定义学生类，属性：姓名、年龄、成绩
 创建四个学生对象放入TreeSet对象 按年龄，成绩，姓名排序
  */

    private String name;
    private int age;
    private int grade;

    @Override
    public int compareTo(Student o) {
        int result = this.age - o.getAge();
        if (result != 0){return result;}
        result = this.grade - o.getGrade();
        if (result != 0){return result;}
        result = this.name.compareTo(o.getName());
        return result;
    }
}
