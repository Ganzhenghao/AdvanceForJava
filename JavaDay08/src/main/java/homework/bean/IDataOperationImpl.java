package homework.bean;

import lombok.Data;

import java.util.Collection;
import java.util.Objects;
import java.util.TreeSet;

/**
 * @ClassName IDataOperationImpl
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/2/26 18:21
 * @Version 1.0
 */
@Data
public class IDataOperationImpl implements IDataOperation<Student>{
    /*
    学生信息包括学号、姓名、年龄和地址；其中，学生的学号是唯一的，不能出现两个学号一样的学生。
     */
    TreeSet<Student> set = new TreeSet<>(((o1, o2) -> {
        if (Objects.equals(o1.getId(), o2.getId())){
            return 0;
        }
        return Integer.parseInt(o1.getId()) - Integer.parseInt(o2.getId());
    }));

    @Override
    public boolean add(Student t) {
        return set.add(t);
    }

    @Override
    public <T> boolean delete(T t) {
        return set.removeIf((student -> student.getId().equals(t)));
    }

    @Override
    public <T> boolean update(Student student) {
        TreeSet<Student> newSet = new TreeSet<>(((o1, o2) -> {
            if (Objects.equals(o1.getId(), o2.getId())){
                return 0;
            }
            return Integer.parseInt(o1.getId()) - Integer.parseInt(o2.getId());
        }));
        for (Student s : set) {
            if (s.getId().equals(student.getId())) {
                newSet.add(student);
            }else{
                newSet.add(s);
            }
        }
        set = newSet;
        return true;
    }

    @Override
    public <T> Student get(T t) {
        for (Student student : set) {
            if (student.getId().equals(t)){
                return student;
            }
        }
        return null;
    }

    @Override
    public Collection<Student> getAll() {
        return set;
    }


}
