package Package8_19;

import java.io.*;
import java.util.Arrays;

public class File1 {

    public static void main(String[] args) {
        InputStream in = null;
        OutputStream out = null;

        File file = new File("D:/app/test/Hello.txt");
       // System.out.println(file.exists());
        try {
            in = new FileInputStream(file);
            //out = new FileOutputStream();
            int len = -1;
            byte[] arr = new byte[1024];

            while((len = in.read(arr)) != -1){
                System.out.write(arr,0,len);
                System.out.println();
            }
                //out.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
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
