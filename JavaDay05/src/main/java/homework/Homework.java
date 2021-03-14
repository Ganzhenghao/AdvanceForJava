package homework;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.After;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

/**
 * @ClassName homework
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/2/21 18:22
 * @Version 1.0
 */
public class Homework {

    @After
    public void before() {
        System.out.println("-----------------------------------------------------------");
    }

    /*
    请按标准格式定义一个“手机类”，它有三个属性：品牌(String)、颜色(String)、价格(double)
	请编写测试类，创建两个“手机对象”并为它们的属性赋值，并能直接打印手机对象的属性信息。
     */
    @Test
    public void phoneTest() {
        System.out.println("题目一");
        Phone apple = new Phone("Apple", "Red", 6999.00);
        Phone huawei = new Phone("Huawei", "White", 8999.00);
        System.out.println("apple = " + apple);
        System.out.println("huawei = " + huawei);
    }

    /*
    请按标准格式定义一个“学生类”，它有三个属性：姓名、性别、年龄
	请编写测试类，创建两个“学生对象”并为它们的属性赋值，并能比较两个对象的所有属性值是否完全相等。
     */
    @Test
    public void studentTest() {
        System.out.println("题目二");
        Student zs = new Student("张三", "Man", "12");
        Student ww = new Student("王五", "Man", "14");
        Student ww1 = new Student("王五", "Man", "14");
        System.out.println("Objects.equals(张三, 王五) = " + Objects.equals(zs, ww));
        System.out.println("Objects.equals(王五, 王五) = " + Objects.equals(ww1, ww));
    }

    /*
    请编程进行以下运算：
	请计算3的5次幂
	请计算3.2向上取整的结果
	请计算3.8向下取整的结果
	请计算5.6四舍五入取整的结果

     */
    @Test
    public void mathTest() {
        System.out.println("题目三");
        System.out.println("Math.pow(3, 5) = " + Math.pow(3, 5));
        System.out.println("Math.ceil(3.2) = " + Math.ceil(3.2));
        System.out.println("Math.floor(3.8) = " + Math.floor(3.8));
        System.out.println("Math.round(5.6) = " + Math.round(5.6));
    }
    
    /*
    有以下数组：
		int[] arr = {10,27,8,5,2,1,3,55,88};
	请定义一个新数组，长度为5，并将arr中几个连续的1位数的数字复制到新数组。
     */
    @Test
    public void systemArrCopyTest() {
        int[] arr = {10,27,8,5,2,1,3,55,88};
        int[] newArr = new int[5];
        System.arraycopy(arr, 2, newArr, 0, 5);
        System.out.println("Arrays.toString(newArr) = " + Arrays.toString(newArr));
    }

    /*
    有以下数组：
		int[] arr = {55,77,0,88,22,44,33};
	请编程实现：将后四个数字依次前移一位，移动后，最后一位置为0.
     */
    @Test
    public void arrMove() {
        int[] arr = {55,77,0,88,22,44,33};
        int[] newArr = new int[arr.length];
        System.arraycopy(arr, 1, newArr, 0, arr.length-1);
        System.out.println("Arrays.toString(newArr) = " + Arrays.toString(newArr));
    }

    /*
    请定义一个集合：List<Integer>，并循环向集合中添加1千万个数字，请计算这个循环运行的时间，并打印。
     */
    @Test
    public void listTimeTest() {
        List<Integer> list = new ArrayList<>();
        long start = System.currentTimeMillis();
        for (int i = 1; i <= 1000 * 10000 ; i++) {
            list.add(0);
        }
        long end = System.currentTimeMillis();

        System.out.println("(add 10000000 element time : ) = " + (end - start)+" ms");
    }

    /*
    	有以下double数组：
		double[] arr = {0.1,0.2,2.1,3.2,5.56,7.21};
	请编程计算它们的总值及平均值(四舍五入保留小数点后2位)
     */
    @Test
    public void bigDecimalTestOne() {
        double[] arr = {0.1,0.2,2.1,3.2,5.56,7.21};
        BigDecimal sum = BigDecimal.valueOf(0);
        for (double value : arr) {
            sum = sum.add(BigDecimal.valueOf(value));
        }
        System.out.println("总值为(四舍五入): "+ sum.divide(BigDecimal.valueOf(1),2, RoundingMode.HALF_UP));
        System.out.println("平均值为(四舍五入): "+sum.divide(BigDecimal.valueOf(arr.length),2, RoundingMode.HALF_UP));

    }

    /*
    	有以下学员信息：
		张三,男,20,79.5
		李四,女,21,80.2
		王五,男,22,77.9
		周六,男,20,55.8
		赵七,女,21,99.9
	请定义学员类，属性：姓名、性别、年龄、分数
	请编写测试类，创建5个对象，分别存储上述值，并计算5名学员的“平均分”(四舍五入到小数点后2位)。
     */
    @Test
    public void bigDecimalTestTwo() {
        Students students1 = new Students("张三", "男", 20,79.5);
        Students students2 = new Students("李四", "女", 20,80.2);
        Students students3 = new Students("王五", "男", 20,77.9);
        Students students4 = new Students("周六", "男", 20,55.8);
        Students students5 = new Students("赵七", "女", 20,99.9);

        List<Students> list = new ArrayList<>();
        list.add(students1);
        list.add(students2);
        list.add(students3);
        list.add(students4);
        list.add(students5);

        BigDecimal sum = BigDecimal.valueOf(0);
        for (Students students : list) {
            sum = sum.add(BigDecimal.valueOf(students.getGrades()));
        }
        System.out.println("sum.divide(BigDecimal.valueOf(5), 2, RoundingMode.HALF_UP) = "
                + sum.divide(BigDecimal.valueOf(5), 2, RoundingMode.HALF_UP));

    }

    /*
    有以下数组定义：
		int[] arr = {1,332,43,25,3324,34,335,4,45,2,43,52,54};
	要求：
	请打印数组所有元素
	请对数组元素进行“升序”排序
请对排序后的数组再次打印。
     */
    @Test
    public void arrayTest() {
        int[] arr = {1, 332, 43, 25, 3324, 34, 335, 4, 45, 2, 43, 52, 54};
        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
    }

    /*
    请从控制台接收一个整数的“分数”值，要求用String类型的变量存储，
    程序可以将这个String类型的分数值转换为int值，并将分数 + 5分后打印到控制台。
     */
    @Test
    public void convert() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please input a number: ");
        String number = scanner.nextLine();
        System.out.println("Integer.parseInt(number)+5 = " + (Integer.parseInt(number) + 5));
    }

}

@Data
@AllArgsConstructor
class Phone{
    private String brand;
    private String color;
    private double price;
}

@Data
@AllArgsConstructor
class Student{
    private String name;
    private String sex;
    private String age;
}

@Data
@AllArgsConstructor
class Students{
    private String name;
    private String sex;
    private int age;
    private double grades;
}