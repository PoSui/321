package Package8_20;

import java.io.*;

/**
 * 字符缓冲流测试
 * 1.测试不适用缓冲时，花费40ms
 * 2.测试使用缓冲时，花费21ms
 *
 */
public class BufferTest2 {

    public static void main(String[] args) {
        Reader in = null;
        Writer out = null;

        File file = new File("D:\\app\\test\\离骚.txt");
        File file2 = new File("D:\\app\\test\\离骚copy2.txt");

        try {
            //第一次测试不适用缓冲
            in = new FileReader(file);
            out = new FileWriter(file2);
//            in = new BufferedReader(new FileReader(file));
//            out = new BufferedWriter(new FileWriter(file2));
            int data = -1 ;
            long start = System.currentTimeMillis();
            while ((data = in.read()) != -1 ){
                out.write(data);
            }
            out.flush();
            long end = System.currentTimeMillis();
            System.out.println("复制完成,花费时间为"+(end-start)+"ms");
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
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
