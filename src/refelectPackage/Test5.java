package refelectPackage;

import java.lang.reflect.Method;

/**
 * 反射调用方法练习
 *
 */
public class Test5 {
    public static void main(String[] args) throws Exception {
        Student stu = new Student();
        Class c = stu.getClass();

        Method m1 = c.getMethod("toString",null);
        Object result = m1.invoke(stu,null);
        System.out.println(result);
        System.out.println("---------------------------------------");

        Method m2 =c.getMethod("sayHello", String.class);
        //调用stu的sayhell并传参为mmmmm
        result = m2.invoke(stu,"mmmmm");
        System.out.println(result);
    }

}
