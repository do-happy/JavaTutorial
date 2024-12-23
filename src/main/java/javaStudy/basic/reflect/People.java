package javaStudy.basic.reflect;

import lombok.Data;

/**
 * @author: licheng
 * @Description:
 * @create: 2018-10-24 14:06
 **/
@Data
public class People {

    private String name;

    private int age;

    public People() {
    }

    private static void eat() {
        System.out.println("eat");
    }
}
