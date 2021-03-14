package exam.one;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 * @ClassName Exam
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/2/24 19:02
 * @Version 1.0
 */
public class One {
    /*
准备键盘录入学生信息，需要录入两名学生信息
第一名学生信息：迪丽热巴，20，2000年5月5日
第二名学生信息：古力娜扎，20，2000年2月2日
比较两个人的出生时间，确定谁的年龄大
展示最终的结果，年龄大的是 古力娜扎
     */
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        Student[] students = new Student[2];

        for (int i = 1; i <= 2 ; i++) {
            System.out.println("请输入第"+i+"个学生姓名:");
            String name = sc.next();
            System.out.println("请输入第"+i+"个学生年龄:");
            int age = sc.nextInt();
            System.out.println("请输入第"+i+"个学生生日(yyyy年MM月dd日):");
            String birthday = sc.next();
            students[i-1] = new Student(name, age, birthday);
        }

        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日");
        long stu1 = format.parse(students[0].getBirthday()).getTime();
        long stu2 = format.parse(students[1].getBirthday()).getTime();

        if (stu1 > stu2){
            System.out.println("年龄大的是:"+students[0].getName());
        }else if (stu1 < stu2){
            System.out.println("年龄大的是:"+students[1].getName());
        }else{
            System.out.println("年龄相同");
        }
    }






}
