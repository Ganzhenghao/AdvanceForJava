package DuotaiAndJicheng;

import lombok.Data;

/**
 * @ClassName Father
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/2/21 9:28
 * @Version 1.0
 */
@Data
public class Father {
    public String name = "Father";
    private int money = 500;

    public void say() {
        System.out.println("Father => Say 我是 "+name+"  我有 "+money+"元");
    }
}
