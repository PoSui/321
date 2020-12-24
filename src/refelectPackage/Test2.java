package refelectPackage;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 *获取类中方法并输出
 */
public class Test2 {
    public static void main(String[] args) {
    Student stu = new Student();
    Class c = stu.getClass();
    Method[] methods = c.getDeclaredMethods();
    for(Method m:methods){
        //获取方法的修饰符
        System.out.println(Modifier.toString(m.getModifiers()));
        //获取方法的返回类型
        System.out.println(m.getReturnType().getName());
        //获取方法的名称
        System.out.println(m.getName());
        //获取方法的参数个数
        System.out.println(m.getParameterCount());
        //获取方法的参数列表
        System.out.println(Arrays.toString(m.getParameterTypes()));
        //获取方法所抛出的异常个数
        System.out.println(m.getExceptionTypes().length);
        //获取抛出异常类型
        System.out.println(Arrays.toString(m.getExceptionTypes()));


        System.out.println("---------------------------------");

    }
    }
}
