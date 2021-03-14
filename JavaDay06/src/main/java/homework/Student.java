package homework;

/**
 * @ClassName Student
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/2/23 20:47
 * @Version 1.0
 */
public class Student {
    /*
    在性别的set方法中判断是否是男/女，如果不是则抛出：性别异常
在年龄的set方法中判断年龄是否是15--50之间，如果不是则抛出：年龄异常
     */
    private String name;
    private String sex;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        if ("男".equals(sex)|| "女".equals(sex)){
            this.sex = sex;
        }else{
            throw new SexException("性别异常");
        }

    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age>=15 && age<=50) {
            this.age = age;
        }else{
            throw new AgeException("年龄异常");
        }
    }
}
