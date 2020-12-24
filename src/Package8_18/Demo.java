package Package8_18;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Demo {
    public static void main(String[] args) {
        //声明流
        //创建流

        InputStream in = System.in;
        OutputStream out = System.out;
        //使用流

        try {
//            int data = -1;
//            data = in.read();
//            out.write(data);
//            out.flush();
            byte[] buf = new byte[10];
            int len;
            while((len = in.read(buf)) != -1) {

                out.write(buf, 0, len);
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(in != null){
                try {
                    in.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            if(out!=null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
