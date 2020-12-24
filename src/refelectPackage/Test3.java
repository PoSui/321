package refelectPackage;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 * 用class获取类种构造器
 *
 */
public class Test3 {
    public static void main(String[] args) {
        Student stu = new Student();
        Class c = stu.getClass();
        //数组接收
        Constructor[] constructor = c.getConstructors();
        for(Constructor con : constructor){
            //输出构造器的修饰符 输出修饰符都用Modifier中的toString
            System.out.println(Modifier.toString(con.getModifiers()));
            //输出构造器的名字
            System.out.println(con.getName());
            //输出构造器的参数列表,如果要接收，要用Class[]的数组 如：
            Class[] paramList=con.getParameterTypes();
            //输出
            System.out.println(Arrays.toString(con.getParameterTypes()));
            //输出构造器的异常,要接受也要用Class[]
            System.out.println(Arrays.toString(con.getExceptionTypes()));

            System.out.println("--------------------------------------");
        }
    }
}
