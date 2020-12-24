package Package8_20.ObjectLiu;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectTest {

    public static void main(String[] args) {

        ObjectOutputStream out = null;

        File file = new File("D:\\app\\test\\a.txt");

        try {
            out = new ObjectOutputStream(new FileOutputStream(file));

            Student stu = new Student("TOM",20);

            out.writeObject(stu);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(out!=null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
