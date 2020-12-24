package Package8_20.ObjectLiu;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * 将刚刚序列化的stu读取出来显示在控制台上
 *
 *
 */
public class ObjectTest2 {

    public static void main(String[] args) {
        ObjectInputStream in = null;

        File file = new File("D:\\app\\test\\a.txt");

        try {
            in = new ObjectInputStream(new FileInputStream(file));
            Student stu = (Student)in.readObject();
            System.out.println(stu.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            if(in!=null){
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            }
        }
    }
}
