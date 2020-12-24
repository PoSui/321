package refelectPackage;

import java.lang.reflect.Constructor;

/**
 *
 * 反射创建对象练习
 */
public class Test6 {

    public static void main(String[] args) throws Exception{

        Class c = Student.class;
        //调用了 无参构造器
        Object obj = c.newInstance();
        System.out.println(obj);
        System.out.println("-----------------------");
        //调用有参构造器，并用Constructor来接收
        Constructor constructor = c.getConstructor(String.class, int.class);
        Object objs = constructor.newInstance("stu",20);
        System.out.println(objs);


    }



}
