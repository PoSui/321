package refelectPackage;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 *
 *
 * 获取类中属性并输出
 */

public class Test {

    public static void main(String[] args) {

        Student stu = new Student();
        Class c = stu.getClass();
        //类的全限定名
        System.out.println(c.getName());
        //获取简单类名
        System.out.println(c.getSimpleName());
        //获取包名
        System.out.println(c.getPackage().getName());
        //获取类的修饰符
        System.out.println(Modifier.toString(c.getModifiers()));
        //获取父类的名称
        System.out.println(c.getSuperclass().getName());
        //获取类实现的接口
        System.out.println(Arrays.toString(c.getInterfaces()));

        Class c2=Object.class;
        //判断c2是不是c的父类
        System.out.println(c2.isAssignableFrom(c));
        //获取类中的包括私有的属性，但不包括父类继承的 getFields()包括父类但不包括私有属性
        Field[] fields=c.getDeclaredFields();
        for(Field f: fields){
            System.out.println("属性的修饰符:"+Modifier.toString(f.getModifiers()));
            System.out.println("属性的类:"+f.getType().getSimpleName());
            System.out.println("属性的名称:"+f.getName());
            System.out.println("----------------------------------------");
        }
    }
}
