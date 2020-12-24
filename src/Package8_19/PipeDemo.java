package Package8_19;

import java.io.*;

/**
 * 字符类型的管道练习实验
 *
 */
public class PipeDemo {

    public static void main(String[] args) {
        PipedReader in = null;
        PipedWriter out = null;

        in = new PipedReader();
        out = new PipedWriter();

        try {
            in.connect(out);

            Thread t1 = new WriteThread(out);
            Thread t2 = new ReadThread(in);

            t1.start();
            t2.start();

            t1.join();
            t2.join();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println("程序结束");

    }
}

class WriteThread extends Thread{
    private Writer out;
    public WriteThread(Writer out){
        this.out = out;
    }

    @Override
    public void run(){

        char[] arr = "Hello Corejava".toCharArray();//这里转换成字符存入字符数组
    try {
        for (int i = 0; i < arr.length; i++) {
            out.write(arr[i]);
            out.flush();
            Thread.sleep(100);
        }
    }catch (IOException | InterruptedException e) {
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
class ReadThread extends Thread{
    private PipedReader in;
    public ReadThread(PipedReader in){
        this.in = in;
    }
    @Override
    public void run() {
        int data = -1;
        try {
            while((data=in.read())!=-1){
          //      System.out.print(data);
                System.out.write(data);
                System.out.flush();
            }
            System.out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(in!=null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

