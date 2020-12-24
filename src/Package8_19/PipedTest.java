package Package8_19;

import java.io.*;

/**
 * 字节类型的管道流实验
 *
 *
 */
public class PipedTest {
    public static void main(String[] args) {
        PipedInputStream in = null;
        PipedOutputStream out = null;

        in = new PipedInputStream();
        out = new PipedOutputStream();
        try {
            in.connect(out);
            Thread t1  = new WriteThread1(out);
            Thread t2 = new ReadThread1(in);

            t1.start();
            t2.start();
            t1.join();
            t2.join();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println("结束");
    }
}

class WriteThread1 extends Thread{
    private OutputStream out;

    public WriteThread1(OutputStream out){
        this.out = out;
    }
    @Override
    public void run(){
        byte[] arr ="hello world briup".getBytes();//与字符类型的区别，这里转成字节存入数组
        try {
                for(int i=0;i<arr.length;i++) {
                    out.write(arr[i]);
                    out.flush();
                    Thread.sleep(100);
                }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }finally {
            if(out != null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

}

class ReadThread1 extends Thread{
    private InputStream in;
    public ReadThread1(InputStream in){
        this.in = in;
    }
    @Override
    public void run(){
        int data = -1;
        try{
        while((data=in.read()) != -1) {
            System.out.write(data);
            System.out.flush();
        }
            System.out.flush();
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}