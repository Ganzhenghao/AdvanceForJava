import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @ClassName Son
 * @Description 如果为false 则子类equals()方法不会调用父类的equals方法 如果为true则会调用
 *          else if (!super.equals(o)) {return false;}
 * @Author Ganzhenghao
 * @Date 2021/3/17 20:16
 * @Version 1.0
 */
@EqualsAndHashCode(callSuper = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Son extends Father{
    private String sex;
}
