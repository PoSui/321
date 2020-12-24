package Package8_19;

import java.io.*;
import java.util.Arrays;

public class Demo1 {


    public static void main(String[] args) {
     //声明流
      Reader in = null;
      Writer out = null;
      //创建流
      char arr[] = "hello 中国".toCharArray();
      in = new CharArrayReader(arr);
      out = new CharArrayWriter();

      int len = -1;
      char[] buf = new char[1024];
      //使用流
        try {
            len = in.read(buf);
            out.write(buf,0,len);
            out.flush();

            char[] toCharArray = ((CharArrayWriter)out).toCharArray();//讲读取的每一个字符存入数组用于输出
            System.out.println(Arrays.toString(toCharArray));

        } catch (IOException e) {
            e.printStackTrace();
        }finally {//关闭流
            if(in!=null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


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
