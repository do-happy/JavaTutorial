package javaStudy.basic.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: li
 * @description: 反射的基本运用
 * @date: 2024/12/23 21:56
 */
public class BasicClass {
    public static void main(String[] args) throws Exception {
        // 获取Class对象的三种方法
        //1.通过Class.forName(全类名)
        Class<?> classA = Class.forName("javaStudy.basic.reflect.People");
        //2.直接获取某一个对象的class
        Class<?> classB = People.class;
        Class<?> classInt = Integer.TYPE;
        //3.调用某个对象的getClass()方法
        People people = new People();
        Class<?> classC = people.getClass();


        // 判断是否为某个类的实例 a instanceof b 判断a是否为b的实例
        People tom = new People();
        if (tom instanceof People) {
            System.out.println("tom是一个People对象");
        } else {
            System.out.println("tom不是一个People对象");
        }

        // 通过反射创建实例
        // 1.使用Class对象的newInstance()方法来创建Class对象对应类的实例 (已过时)

        // 2.使用Class对象获取构造器,再调用构造器对象的newInstance()方法创建实例
        Constructor<?> constructor = classB.getConstructor();
        Object o = constructor.newInstance();
        System.out.println(o);
        // 输出:People(name=null, age=0)

        // 获取方法
        // 1.getDeclaredMethods() 获取方法返回类或接口声明的所有方法,包含公共、保护、默认访问和私有方法,但不包含继承的方法
        Method[] declaredMethods = classA.getDeclaredMethods();
        // 2.getMethods() 返回某个类的所有公用(public)方法，包括其继承类的公用方法
        Method[] methods = classA.getMethods();
        // 3.getMethod(String name) 返回一个指定的方法 第一个参数为方法名称
        Method method = classA.getMethod("setName", String.class);
    }
}
