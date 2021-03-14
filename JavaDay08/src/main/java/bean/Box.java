package bean;

import lombok.Data;

import java.util.List;

/**
 * @ClassName Box
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/2/26 9:34
 * @Version 1.0
 */
@Data
public class Box<E> {

    private E element;
    private List<E>  list;

    public <T> T createAndReturn(T t){
        return t;
    }


}
