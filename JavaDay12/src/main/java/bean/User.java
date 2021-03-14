package bean;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName User
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/3/4 15:46
 * @Version 1.0
 */
@Data
@AllArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = -1952971275613659896L;
    private String name;
    private String password;
}
