package Package8_21.talkroom;

import java.io.*;
import java.net.Socket;

public class ClientTCP1 {

    public static void main(String[] args) {
        String host ="127.0.0.1";
        int port = 8888;
        Socket socket =  null;
        String encoding = "UTF-8";
        PrintWriter out =  null;
        BufferedReader in = null;
        BufferedReader inFormConsole = null;
        PrintWriter outName = null;
        boolean flag = true;

        try {
            socket = new Socket(host,port);
            //能不能创建socket对象 代表着是否连接成，失败会抛异常
            System.out.println("客户端启动");
            System.out.println("你的名字是?");
            inFormConsole = new BufferedReader(new InputStreamReader(System.in,encoding));
            outName = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),encoding));
            String Tname = null;
            Tname = inFormConsole.readLine();
            outName.println(Tname);
            outName.flush();
        /*
            OutputStream os = socket.getOutputStream(); //字节输出流
            OutputStreamWriter osw = new OutputStreamWriter(os,"UTF-8");//将字节输出变为字符输出
            PrintWriter pw = new PrintWriter(osw);//将osw包裹
        */

            while(flag) {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream(), encoding));
                out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), encoding));
                inFormConsole = new BufferedReader(new InputStreamReader(System.in,encoding));

                String l = null;
                System.out.println("输入:");
                l = inFormConsole.readLine();
                out.println(l);
                out.flush();

                String inFromServer = null;
                inFromServer = in.readLine();
                System.out.println(inFromServer);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(in!= null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(out!=null){
                out.close();
            }

            if(socket!= null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
