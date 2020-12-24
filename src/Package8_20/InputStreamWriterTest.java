package Package8_20;

import java.io.*;

/**
 * 将字节转换为字符并指定编码，在控制台输出实验
 *  不同编码，如果在输入流中的编码和输出流相同，就可以在控制台输出
 *  但如果文本编码不同，则会在文本本身中乱码
 *
 */
public class InputStreamWriterTest {

    public static void main(String[] args) {
        BufferedReader in = null;
        InputStreamReader inputStreamReader = null;

        File file = new File("D:\\app\\test\\a.txt");
        try {
            inputStreamReader = new InputStreamReader(new FileInputStream(file),"GBK");
            in = new BufferedReader(inputStreamReader);

            String data = "" ;
            while ((data = in.readLine())!= null){
                System.out.println(data);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(in != null)
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (inputStreamReader!= null){
                try {
                    inputStreamReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
