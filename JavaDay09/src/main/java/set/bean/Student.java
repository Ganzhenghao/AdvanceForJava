package set.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Student
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/2/27 11:38
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Comparable<Student>{

    private String name = "张三";
    private int age = 18;

    @Override
    public int compareTo(Student o) {
        int result = this.age - o.getAge();
        return result == 0? this.name.compareTo(o.getName()) : result;
    }


    public Student setNameField(String name){
        this.name = name;
        return this;
    }

    public Student setAgeField(int age){
        this.age = age;
        return this;
    }


}
