package DuotaiAndJicheng;

/**
 * @ClassName Son
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/2/21 9:29
 * @Version 1.0
 */

public class Son extends Father{
    String name = "Son";
    //int money = 50;
    @Override
    public void say() {
        System.out.println("Son => Say 我是 "+name+"  我有 "+getMoney()+"元");
    }

    public static void main(String[] args) {
        Father father = new Son();
        System.out.println("father.name = " + father.name);
        System.out.println("father.getMoney() = " + father.getMoney());
        father.say();
    }
}
