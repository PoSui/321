package Package8_12;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class personTest {
    public static void main(String[] args) throws Exception {
        person p = new person();
        Class c = p.getClass();
        Object obj = c.newInstance();

        Method method = c.getDeclaredMethod("setName", String.class);
        method.invoke(p,"tom");

        method = c.getDeclaredMethod("setAge", int.class);
        method.invoke(p,20);
        System.out.println(p);
    }

}
