package refelectPackage;

import java.lang.reflect.Field;

/**
 * 反射访问属性练习
 *
 */
public class Test4 {

    public static void main(String[] args) throws Exception {

        Student stu = new Student();
        Class c = stu.getClass();
        //获取name属性
        Field f1 = c.getDeclaredField("name");
        f1.setAccessible(true);//设置私有可以访问
        //f1 现在是name，让他给stu对象的name属性赋值为tom
        f1.set(stu,"tom");
        //输出一下
        System.out.println(f1.get(stu));

        System.out.println("-----------------------");

        Field f3 = c.getDeclaredField("num");

        f3.set(stu,998);//也可以写成  f3.set(null,999); 因为num是静态的，不需要对象就可以调用
        f3.set(null,999);
        System.out.println(f3.get(stu));


    }
}
