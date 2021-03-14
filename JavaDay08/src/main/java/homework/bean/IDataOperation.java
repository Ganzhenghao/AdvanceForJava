package homework.bean;

import java.util.Collection;

/**
 * @ClassName IDataOperation
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/2/26 18:19
 * @Version 1.0
 */
public interface IDataOperation<E> {
    // 添加数据
    public boolean add(E t);
    // 根据唯一标识删除一个数据
    public <T> boolean delete(T t);
    // 修改一个数据
    public <T> boolean update(E e);
    // 根据唯一表示查找一个数据
    public <T> E get(T t);
    // 查找所有数据
    public Collection<E> getAll();
}
