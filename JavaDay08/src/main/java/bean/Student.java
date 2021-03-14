package bean;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @ClassName Student
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/2/24 21:20
 * @Version 1.0
 */
@Data
@AllArgsConstructor
public class Student implements Comparable<Student>{
    private String name;
    private int age;

    public Student() {
        name = "张三";
        age = 18;
    }

    @Override
    public int compareTo(Student o) {
        if (this.name.equals(o.getName()) && this.age ==o.getAge()){
            return 0;
        }
        int result = this.age - o.getAge();
        return result==0? this.name.compareTo(o.getName()) : result;
    }

    private int strCompareTo(String otherString){
        char[] chars = this.name.toCharArray();
        char[] others = otherString.toCharArray();
        for (Character thisChar : chars) {
            for (char otherChar : others) {
                if (thisChar != otherChar) {
                    return thisChar.compareTo(otherChar);
                    //return thisChar - otherChar;
                }
            }
        }
        return 0;
    }
}
