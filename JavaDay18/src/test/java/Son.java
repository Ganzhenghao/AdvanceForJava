import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @ClassName Son
 * @Description TODO
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
