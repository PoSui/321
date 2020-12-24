package renyanhao;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Stest {

    public static void main(String[] args) throws Exception {
        String name;
        int age;
        int score;
        boolean flag =true;
        PrintWriter out ;

        Class stu = Class.forName("renyanhao.Student");
        Constructor constructor = stu.getConstructor(String.class,int.class,int.class);
        File file = new File("D:\\app\\test\\123\\321\\a.txt");
        out = new PrintWriter(new FileOutputStream(file));

        while(flag) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("输入姓名：(输入'quit'关闭)");
            name = scanner.next();
            if("quit".equals(name) ){
                flag = false;
                System.out.println("关闭");
                break;
            }
            System.out.println("输入年龄：");
            age = scanner.nextInt();
            System.out.println("输入分数：");
            score = scanner.nextInt();

            Object obj = constructor.newInstance(name,age,score);
            Student student =  (Student)obj;
            Method m1 = stu.getDeclaredMethod("toString");
            out.println(m1.invoke(student));
            out.flush();
            System.out.println("写入文件"+m1.invoke(student));
            //  System.out.println(student.toString());
        }
        out.close();




    }
}
