package homework;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

/**
 * @ClassName Homework
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/2/23 19:25
 * @Version 1.0
 */
public class Homework {
    private static final String PATTERN_DATE ="yyyy年MM月dd日";
    private static final String PATTERN_TIME ="HH时mm分ss秒";
    private static final String PATTERN_DATETIME ="yyyy年MM月dd日 HH时mm分ss秒";
    private static final String PATTERN ="yyyy-MM-dd HH:mm:ss";
    private static final String PATTERN_SIMPLE ="yyyy-MM-dd";
    /*
    请编写程序，从控制台分别接收两个“生日”，格式：yyyy年MM月dd日，程序要能够计算并打印：第一个生日大于/小于第二个生日。
	注意：要求验证生日日期必须早于当前日期
     */
    @Test
    public void birthday() throws ParseException {

        Scanner sc = new Scanner(System.in);
        String birthdayOne;
        String birthdayTwo;

        while (true){
            System.out.println("输入第一个生日:");
            birthdayOne = sc.nextLine();
            if (birthdayCheck(birthdayOne)){
                break;
            }
        }

        while (true){
            System.out.println("输入第二个生日:");
            birthdayTwo = sc.nextLine();
            if (birthdayCheck(birthdayTwo)){
                break;
            }
        }

        if (parseStringToLocalDateTime(birthdayOne).isEqual(parseStringToLocalDateTime(birthdayTwo))){
            System.out.println("两个生日相同");
        }else if (parseStringToLocalDateTime(birthdayOne).isBefore(parseStringToLocalDateTime(birthdayTwo))){
            System.out.println("第一个生日大于第二个");
        }else{
            System.out.println("第一个生日小于第二个");
        }

    }

    private boolean birthdayCheck(String birthday) {
        if (StringUtils.isEmpty(birthday)){
            return false;
        }
        LocalDateTime parse = LocalDateTime.parse(birthday, DateTimeFormatter.ofPattern(PATTERN_DATE));
        return parse.isBefore(LocalDateTime.now());
        //LocalDate parse = LocalDate.parse(birthday,DateTimeFormatter.ofPattern(PATTERN_DATE));
        //return parse.isBefore(LocalDate.now());
    }

    private boolean simpleBirthdayCheck(String birthday) {
        if (StringUtils.isEmpty(birthday)){
            return false;
        }
        LocalDate parse = LocalDate.parse(birthday,DateTimeFormatter.ofPattern(PATTERN_SIMPLE));
        return parse.isBefore(LocalDate.now());
    }

    private LocalDateTime parseStringToLocalDateTime(String time){
        return LocalDateTime.parse(time, DateTimeFormatter.ofPattern(PATTERN_DATE));
    }

    /*
    请在控制台以“xxxx年xx月xx日 xx时xx分xx秒”的格式打印当前系统时间。
     */
    @Test
    public void printTime() {
/*        DateTimeFormatter pattern = DateTimeFormatter.ofPattern(PATTERN_DATETIME);
        System.out.println(LocalDateTime.now().format(pattern));
        System.out.println(LocalDateTime.parse("2021年02月23日 20时14分21秒", pattern));*/

        System.out.println(new SimpleDateFormat(PATTERN_DATETIME).format(new Date()));
    }

    /*
    请编写程序，从控制台接收一个“日期”，格式：yyyy-MM-dd，程序将其转换为：xxxx年xx月xx日的格式输出到控制台。
     */
    @Test
    public void dateParse() throws ParseException {

        Scanner sc = new Scanner(System.in);
        System.out.println("please input a time:");
        String time = sc.nextLine();
        Date date = new SimpleDateFormat(PATTERN_SIMPLE).parse(time);
        System.out.println(new SimpleDateFormat(PATTERN_DATE).format(date));
    }

    /*
    请编写程序，从控制台接收一个“生日”，格式：yyyy-MM-dd，程序要能够计算并打印他来到世界xx天。
	注意：“生日”必须早于“当前日期”，否则提示：生日必须早于当前日期！
     */
    @Test
    public void formDay() throws ParseException {
        Scanner sc = new Scanner(System.in);
        System.out.println("please input a time:");
        String time = sc.nextLine();
        if (simpleBirthdayCheck(time)){
            Date birthday = new SimpleDateFormat(PATTERN_SIMPLE).parse(time);
            long days = System.currentTimeMillis() - birthday.getTime();
            System.out.println("这是你来到地球的第"+(days/1000/60/60/24)+"天");
        }else{
            System.out.println("生日必须早于当前日期");
        }
    }

    /*
    	请定义main()方法，在main()中按以下顺序要求编写代码：
	分别从控制台接收两个整数
	计算“第一个数 / 第二个数”的结果，并打印；
	为了防止第二个数为0导致异常，请在计算时使用异常处理。当出现异常时，向用户打印：第二个数不能为0！！

     */

    @Test
    public void mainException() {
        Scanner sc = new Scanner(System.in);
        System.out.println("please input a num:");
        int num1 = sc.nextInt();
        System.out.println("please input a num:");
        int num2 = sc.nextInt();

        try {
            System.out.println(num1/num2);
        } catch (ArithmeticException e) {
            System.out.println("第二个数不能为0！！");
        }
    }
    
    /*
    	请定义main()方法，在main()中按以下顺序要求编写代码：
	定义一个String[]数组如下：
String[] arr = {”星期一”,”星期二”,”星期三”,”星期四”,”星期五”,”星期六”,”星期日”};
	请用户输入一个整数1--7的值：
	根据用户输入，从数组中取出对应的星期名称，例如：
用户输入：1
程序提示：星期一
	为了防止用户输入小于1或者大于7的值，请使用异常处理从数组中取出对应的“星期名称”，在异常处理中打印：输入错误！！

     */
    @Test
    public void exceptionTwo() {
        String[] arr = {"星期一","星期二","星期三","星期四","星期五","星期六","星期日"};
        Scanner sc = new Scanner(System.in);
        System.out.println("please input a num: ");
        int week = sc.nextInt();
        try {
            System.out.println(arr[week]);
        } catch (Exception e) {
            System.out.println("输入错误！！");
        }
    }

    @Test
    public void modify() {
        //测试调用：会导致方法内抛出“空指针异常”
        try {
            int n1 = getMax(null);
            //测试调用：会导致方法内抛出“数组索引越界异常”
            int[] arr = new int[0];
            int n2 = getMax(arr);
            //测试调用：正常
            int[] arr2 = {1,2,4,24,32,5324,32};
            int n3 = getMax(arr2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("程序继续执行");
    }

    public static int getMax(int[] args) throws Exception{
        int max = args[0];
        for(int i = 1 ; i < args.length ; i++){
            if(max < args[i]){
                max = args[i];
            }
        }
        return max;
    }

    /*
    	请按以下步骤要求编写代码：
	定义一个“年龄异常类”：AgeException，使其继承自RuntimeException，并添加无参、String参数的构造方法；
	定义一个“性别异常类”：SexException，使其继承自RuntimeException，并添加无参、String参数的构造方法；
	定义一个Student类，属性：姓名、性别、年龄。
在性别的set方法中判断是否是男/女，如果不是则抛出：性别异常
在年龄的set方法中判断年龄是否是15--50之间，如果不是则抛出：年龄异常
	编写测试类，创建一个Student对象，并在try{}中调用setXxx()方法为对象属性赋值，在catch()中打印年龄错误。

     */
    @Test
    public void exception() {

        Student student = new Student();
        student.setName("");
        try {
            student.setSex("");
        } catch (SexException e) {
            System.out.println(e.getMessage());
        }
        try {
            student.setAge(0);
        } catch (AgeException e){
            System.out.println(e.getMessage());
        }


    }

}
