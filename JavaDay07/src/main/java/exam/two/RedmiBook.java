package exam.two;

/**
 * @ClassName RedmiBook
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/2/24 19:20
 * @Version 1.0
 */

public class RedmiBook extends Computer{
    /*
    红米笔记本电脑（RedmiBook） 要求继承 Computer
成员变量：型号  model
成员方法：玩游戏 playGame  getXxx 和 setXxx
构造方法：无参数构造 和 全参数构造
     */
    public String model;
    public void playGame(){
        System.out.println("红米电脑玩游戏");
    };

    public RedmiBook() {
    }

    public RedmiBook(String color, int price, String model) {
        super(color, price);
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

}
