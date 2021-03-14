package enu;

import enu.bean.Season;

import java.util.Arrays;

/**
 * @ClassName EnumStudy
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/3/11 9:08
 * @Version 1.0
 */
public class EnumStudy {
    public static void main(String[] args) throws ClassNotFoundException {

        System.out.println("Season.SPRING = " + Season.SPRING);

        System.out.println("Season.SPRING.ordinal() = " + Season.SPRING.ordinal());

        System.out.println("Season.SPRING.compareTo(Season.WINTER) = " + Season.SPRING.compareTo(Season.WINTER));

        System.out.println("Season.valueOf(Spring) = " + Season.valueOf("SPRING"));

        System.out.println("Season.valueOf(Season.class,\"SPRING\") = " + Season.valueOf(Season.class, "SPRING"));

        Arrays.stream(Season.values()).forEach(System.out::println);

    }
}
