package exam.two;

/**
 * @ClassName Two
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/2/24 19:24
 * @Version 1.0
 */
public class Two {
    public static void main(String[] args) {
        RedmiBook redmiBook = new RedmiBook();
        redmiBook.setModel("红米777");
        redmiBook.setColor("土豪金");
        redmiBook.setPrice(998);
        System.out.println("型号:" + redmiBook.getModel()+
                "颜色:" + redmiBook.getColor() +
                ", 价格:" + redmiBook.getPrice());
        redmiBook.open();
        redmiBook.playGame();
        redmiBook.close();

        MateBook mateBook = new MateBook();
        mateBook.setColor("香槟金");
        mateBook.setPrice(9527);
        System.out.println(
                "颜色:" + mateBook.getColor() + ", 价格:" + mateBook.getPrice());
        mateBook.open();
        mateBook.inDivice();
        mateBook.outDivice();
        mateBook.close();


    }
}
