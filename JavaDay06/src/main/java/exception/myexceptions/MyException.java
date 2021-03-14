package exception.myexceptions;

/**
 * @ClassName MyException
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/2/23 14:50
 * @Version 1.0
 */

public class MyException extends RuntimeException{
    private String message;

    public MyException(String message) {
        super(message);
    }



}
