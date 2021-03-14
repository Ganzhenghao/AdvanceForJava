/**
 * @ClassName Fu
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/2/3 14:57
 * @Version 1.0
 */
public class Fu {
    private String name;
    private void  hello(){
        System.out.println("Hello");
    }

    public void say(){
        hello();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
