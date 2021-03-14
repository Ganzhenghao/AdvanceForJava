package exam.one;

/**
 * @ClassName Student
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/2/24 19:03
 * @Version 1.0
 */

public class Student {
    /*
    定义学生类 Student，需要包含以下成员信息：
成员变量，姓名，年龄，出生日期
成员方法，getXxx 和 setXxx 和 toString()
构造方法，无参构造 以及 全参数构造
     */
    private String name;
    private int age;
    private String birthday;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday='" + birthday + '\'' +
                '}';
    }

    public Student(String name, int age, String birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
