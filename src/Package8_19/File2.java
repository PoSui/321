package Package8_19;

import java.io.*;

public class File2 {
    public static void main(String[] args) {
        String str = "HelloJavaWorld你好世界";

        File file = new File("D:/app/test/Hello.txt");
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(str);
            fileWriter.close();
            System.out.println("写完了");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
