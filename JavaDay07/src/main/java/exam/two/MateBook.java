package exam.two;

/**
 * @ClassName MateBook
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/2/24 19:22
 * @Version 1.0
 */
public class MateBook extends Computer implements USB{
/*
华为笔记本电脑（MateBook） 要求继承 Computer 和 实现 USB 接口
成员变量: 无
成员方法：无
构造方法：无参数构造 和 全参数构造

*/

    @Override
    public void inDivice() {
        System.out.println("进入设备"
        );
    }

    @Override
    public void outDivice() {
        System.out.println("退出设备");
    }



}
