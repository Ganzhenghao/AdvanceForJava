package com.ganzhenghao.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Person
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/2/3 9:40
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private String id;
    private String name;
    private String age;
    private String birthday;
}
