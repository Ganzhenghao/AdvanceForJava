package anno;

import enu.bean.Season;

/**
 * @ClassName MyAnnotation
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/3/12 9:17
 * @Version 1.0
 */
public @interface MyAnnotation {
    //属性可以有 基本数据类型和String类型 注解类型 枚举类型  Class类型 以及以上所有类型的一维数组
    String name() default "Ganzhenghao";

    int age() default 18;

    Class<String> clazz() default String.class;

    Season season() default Season.SPRING;

    Season[] seasons() default {Season.SPRING,Season.AUTUMN};

}
