package Package8_20;

import java.io.*;


/**
 * 缓冲流实验
 * 1.先使用普通字节流来测试复制一个文本,测试时间:134ms
 * 2.创建buffer对象,替换原来的普通流,再次测试时间:1ms
 * 唯一区别是创建时,使用BufferInputStream和BufferOutputStream包裹in和out的创建
 */
public class BufferTest {

    public static void main(String[] args) {
        InputStream in = null;
        OutputStream out = null;

        File file = new File("D:\\app\\test\\离骚.txt");
        File file2 = new File("D:\\app\\test\\离骚copy.txt");

        try {
            //让输入和输出初始化，第一次的普通流测试
//            in = new FileInputStream(file);
 //           out = new FileOutputStream(file2);
            in = new BufferedInputStream(new FileInputStream(file));
            out = new BufferedOutputStream(new FileOutputStream(file2));

            int data = - 1 ;
            //确定开始时间
            long start = System.currentTimeMillis();

            while ((data = in.read()) != -1 ){
                 out.write(data);
            }
            out.flush();
            long end = System.currentTimeMillis();
            System.out.println("复制完成,花费时间为"+(end-start)+"ms");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert in != null;
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
