package Package8_20;

import java.io.*;

/**
 * 将字节输出转换为字符输出并指定编码
 *
 *
 */
public class OutputStreamWriterTest {
    public static void main(String[] args) {

        PrintWriter out = null;
        OutputStreamWriter outputStreamWriter = null;

        File file = new File("D:\\app\\test\\a.txt");
        try {
            //构造一个流，将字节流转换为字符流
            outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file),"GBK");
            out = new PrintWriter(outputStreamWriter);

            out.println("你好");
            out.flush();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                outputStreamWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(out != null)
                out.close();

        }
    }

}
