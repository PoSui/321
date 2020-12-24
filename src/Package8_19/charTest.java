package Package8_19;

import java.io.*;
import java.util.Arrays;

public class charTest {
    public static void main(String[] args) {
        InputStream in = null;
        OutputStream out = null;

        byte[] arr = "hello".getBytes();//以字节形式保存到数组
        //System.out.println(Arrays.toString(arr));
        in = new ByteArrayInputStream(arr);
        out = new ByteArrayOutputStream();

        int len = -1;
        byte[] buf = new byte[1024];

        try {
            len = in.read(buf);
            out.write(buf,0,len);//将buf写入ByteArrayOutputStream这个流中的一个数组对象中
            out.flush();

            byte[] jieshou = ((ByteArrayOutputStream)out).toByteArray();//获取流中数组的数据
            System.out.println(Arrays.toString(jieshou));

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if (out != null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            }
        }

    }


}
