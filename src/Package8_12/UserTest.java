package Package8_12;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class UserTest {
    public static void main(String[] args) throws Exception {
        Class c = User.class;
        Field[] field = c.getDeclaredFields();
        for(Field f : field){
            System.out.println("属性的名字为："+f.getName());
            System.out.println("属性的修饰符为："+ Modifier.toString(f.getModifiers()));
            System.out.println("----------------------");
        }
        Method m1 = c.getDeclaredMethod("checkName", String.class);
        Object obj = m1.invoke(new User(),"tom");
        System.out.println(obj);
        m1 = c.getDeclaredMethod("getName", String.class);
        obj = m1.invoke(new User(),"tom");
        System.out.println(obj);

        Method[] methods = c.getDeclaredMethods();
        for(Method method : methods){
            System.out.println("方法的名字为："+method.getName());
            System.out.println("方法的修饰符为："+ Modifier.toString(method.getModifiers()));
            System.out.println("方法的返回值为："+method.getReturnType());
            System.out.println("方法的参数为："+Arrays.toString(method.getParameterTypes()));
            System.out.println("-------------------------------------------------------");
        }
        m1 = c.getDeclaredMethod("doSomething", String.class, String.class);
        obj = m1.invoke(new User(),"tom","211313");

    }
}
