package homework;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * @ClassName DatePractice
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/2/23 20:55
 * @Version 1.0
 */
public class DatePractice {
    /*
    需求
	1.房租一个月1000元
	2.按季度缴费（3个月）
	3.实现：控制台输入信息选择（1.查看当前是否欠租，2.查看什么时候到期，3.缴费，4.退出）
思路：
	1.初始化最近一次缴费的日期（yyyy-MM-dd）
	2.定义按季度缴费
	3.当用户输入1时，控制台打印是否欠租
	4.当用户输入2时，控制台打印到期的日期(yyyy-MM-dd)
	5.当用户输入3时，控制台提示请输入金额
		交3000
	6.用户输入1和2验证是否正确
     */
    private static final int RENT = 1000;
    private static final String PATTERN = "yyyy-MM-dd";
    private static final DateTimeFormatter PATTERN_FORMATTER = DateTimeFormatter.ofPattern(PATTERN);

    private static String initializationDate = "2021-01-01";
    private static LocalDate theMostRecentPaymentDate;
    private static LocalDate expireDate;
    private static LocalDate rentalDate;

    static {
        theMostRecentPaymentDate = LocalDate.parse(initializationDate, PATTERN_FORMATTER);
        rentalDate = LocalDate.parse(initializationDate, PATTERN_FORMATTER);
        expireDate = LocalDate.parse("2021-04-01", PATTERN_FORMATTER);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int choose;
        boolean flag = true;
        while (flag){
            System.out.println("1.查看当前是否欠租，2.查看什么时候到期，3.缴费，4.退出 ");
            choose = scanner.nextInt();

            switch (choose){
                case 1: checkIfRentIsOwed();break;
                case 2: seeWhenItExpires();break;
                case 3: pay();break;
                case 4: flag =false;break;
                default: System.out.println("输入错误,请重新输入");break;
            }

        }
    }

    private static void pay() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入缴费金额(季度缴费 3000/季度): ");
            int money = sc.nextInt(); //TODO 金额合法性校验
            if ((money % 3000) == 0){
                int month  = money / RENT;
                theMostRecentPaymentDate = LocalDate.now();
                expireDate = expireDate.plusMonths(month);
                break;
            }else{
                System.out.println("请以季度缴费");
            }

        }

    }

    private static void seeWhenItExpires() {

        System.out.println("到期时间为:"+expireDate.format(PATTERN_FORMATTER));
    }

    private static void checkIfRentIsOwed() {
        if (LocalDate.now().isAfter(expireDate)){
            System.out.println("已欠租");
        }else{
            System.out.println("未欠租");
        }
    }


}
