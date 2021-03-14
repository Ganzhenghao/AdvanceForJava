package set;

import org.junit.Test;
import set.bean.Student;

import java.util.HashSet;

/**
 * @ClassName SetStudy
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/2/27 8:42
 * @Version 1.0
 */
public class SetStudy {
    HashSet<Student> set = new HashSet<>();

    @Test
    public void hashSetOne() {
        set.add(new Student());
        set.add(new Student());
        set.add(new Student("赵武",55));
        set.add(new Student("赵武",54));
        System.out.println(set);
    }
}
