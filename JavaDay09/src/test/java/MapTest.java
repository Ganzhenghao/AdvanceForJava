import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName MapTest
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/2/27 18:32
 * @Version 1.0
 */
public class MapTest {
    Map<String,Object> map = new HashMap<>();
    @Test
    public void mapOne() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put(null, 0);
        Set<String> keySet = map.keySet();

        for (String key : keySet) {
            System.out.println(key+":"+map.get(key));
        }
    }
}
