package Package8_21;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTest {

    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;
        int port = 8888;
        String encoding = "UTF-8";
        BufferedReader in = null;
        PrintWriter out =  null;
        boolean flag = true;

        try {
            server = new ServerSocket(port);
            System.out.println("服务器已启动，端口号为"+port);
            while (flag) {
                socket = server.accept();
                System.out.println("收到客户端链接"+socket);
                Thread t = new Handler(socket);
                t.start();
//                in = new BufferedReader(new InputStreamReader(socket.getInputStream(),encoding));
//                out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),encoding));
//                System.out.println(in.readLine());
//                out.flush();
//                out.close();
//                in.close();
//                socket.close();

            }
          /*InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is,encoding);
            BufferedReader  br = new BufferedReader(isr);
           */



        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(out != null){
                    out.close();
            }

            if (server != null) {
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


class Handler extends Thread{
    private Socket socket;
    private BufferedReader in = null;
    private PrintWriter out = null;
    private String encoding = "UTF-8";
    FileWriter fileWriter = null;
    FileReader fileReader =null;

    public Handler(){

    }
    public Handler(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run(){

        try {
//            in = new BufferedReader(new InputStreamReader(socket.getInputStream(),encoding));
//            out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),encoding));

            InputStream fis = socket.getInputStream();
            FileOutputStream fos = new FileOutputStream("D:\\app\\test\\123\\321\\大失败12"+Math.random()+".png");

//          fileWriter = new FileWriter("D:\\app\\test\\123\\321\\大失败"+Math.random()+".png");
            System.out.println(Thread.currentThread().getName());
            //System.out.println(in.readLine());
            int len =-1;
            byte[] bytes = new byte[1024];
            while((len = fis.read(bytes))!=-1) {
                fos.write(bytes,0,len);
            }
            System.out.println("上传成功,上传的位置为D:\\app\\test\\123\\321");
            fos.flush();
//            out.close();
//            in.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
