package Package8_20;

import java.io.*;

/**
 * 数据流测试 2
 * 将一个或若干个字节写入文件
 *
 *
 */
public class DataTest2 {

    public static void main(String[] args) {
        //声明一个流
        DataOutputStream out = null;
        //定义文件
        File file= new File("D:\\app\\test\\b.txt");

        try {
            out = new DataOutputStream(new FileOutputStream(file));
            out.writeUTF("这是B.txt");
            out.write(1);
            out.writeBoolean(true);
            out.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {


            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
