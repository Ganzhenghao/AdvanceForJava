package exam.two;

/**
 * @ClassName Computer
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/2/24 19:17
 * @Version 1.0
 */

public class Computer {
    /*
    电脑类（Computer）
成员变量：颜色 color  价格 price
成员方法：开机 open  关机 close  getXxx 和 setXxx
构造方法：无参数构造 和 全参数构造
     */

    public String color;
    public int price;
    public void open(){
        System.out.println("开机");
    }
    public void close(){
        System.out.println("关机");
    }

    public Computer(String color, int price) {
        this.color = color;
        this.price = price;
    }

    public Computer() {
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
