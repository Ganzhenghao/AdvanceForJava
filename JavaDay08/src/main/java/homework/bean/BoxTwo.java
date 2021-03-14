package homework.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName BoxTwo
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/2/26 18:46
 * @Version 1.0
 */
public class BoxTwo<E> {
    /*
    需求：定义一个容器工具类，可以添加和取出任意类型的一个对象；
    要求：1. 取出对象时，不需要使用强制类型转换，就能得到原来的类型；
     */
    List<E> list = new ArrayList<>();

    public E get(int index){
        return list.get(index);
    }

    public boolean add(E element){
        return list.add(element);
    }

}
