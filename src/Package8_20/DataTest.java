package Package8_20;

import java.io.*;
import java.util.Arrays;

/**
 * 数据流测试1
 *  注释内容:将不同类型的数据用数据流读入到一个字节数组
 *
 *  将DataOutputStream写入b.txt的内容读取到控制台
 */
public class DataTest {
    public static void main(String[] args) {
        DataOutputStream out = null; //数据流
        DataInputStream in = null;//读取

        ByteArrayOutputStream byteArrayOutputStream = null;//字节数组输出流
        File file = new File("D:\\app\\test\\b.txt");
        try {
            in = new DataInputStream(new FileInputStream(file));
            System.out.println(in.readUTF());
            System.out.println(in.read());
            System.out.println(in.readBoolean());
            //必须要文件中存在的类型才能读取,否则异常
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {

                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

//        byteArrayOutputStream = new ByteArrayOutputStream();
//        out = new DataOutputStream(byteArrayOutputStream);

//        try {
//            out.writeLong(1000L);
//            out.writeBoolean(true);
//            out.writeUTF("GBK");//将字符串以utf格式写入输入流
//            out.flush();
//
//            byte[] arr = byteArrayOutputStream.toByteArray();//将64位的long，每八位一个位置，写入数组，并转换为带符号10进制
//            System.out.println(Arrays.toString(arr));
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }finally {
//
//            try {
//                byteArrayOutputStream.close();
//                out.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }

    }

}
