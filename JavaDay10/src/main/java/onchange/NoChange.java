package onchange;

import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName NoChange
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/3/1 10:21
 * @Version 1.0
 */
public class NoChange {


    @Test
    public void noChange() {
        //List
        List<Integer> list = List.of(1, 2, 3);
        System.out.println(list);
        //Set
        Set<Integer> set = Set.of(1, 2, 3);
        System.out.println("set = " + set);
        //Map
        Map<Integer, Integer> mapOne = Map.of(1, 1, 2, 2, 3, 3);
        System.out.println("mapOne = " + mapOne);
        Map<Integer, Integer> mapTwo = Map.ofEntries(Map.entry(1, 1), Map.entry(2, 2), Map.entry(3, 3));
        System.out.println("mapTwo = " + mapTwo);
    }
}
