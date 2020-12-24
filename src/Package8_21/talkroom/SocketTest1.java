package Package8_21.talkroom;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SocketTest1 {
    static List<Socket> socketList = Collections.synchronizedList(new ArrayList<Socket>());

    public static void main(String[] args) {

        ServerSocket server = null;
        Socket socket = null;
        int port = 8888;
        String encoding = "UTF-8";
        BufferedReader in = null;
        PrintWriter out =  null;
        boolean flag = true;
        BufferedReader inName;

        try {
            server = new ServerSocket(port);
            System.out.println("服务器已启动，端口号为"+port);
            while (flag) {
                socket = server.accept();
                socketList.add(socket);
                inName = new BufferedReader(new InputStreamReader(socket.getInputStream(), encoding));
                System.out.println("收到客户端链接" + socket);
                Thread t = new Handler(socket, inName.readLine());
                t.start();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
//        finally {
//            out.close();
//            try {
//                in.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            try {
//                socket.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
    }
}


class Handler extends Thread {
    private Socket socket;
    private BufferedReader in = null;
    private PrintWriter out = null;
    private String encoding = "UTF-8";
    private String name = "";
    private boolean flag = true;


    public Handler() {

    }

    public Handler(Socket socket, String name) {
        this.socket = socket;
        this.name = name;

    }

    @Override
    public void run() {

            try {

                String line = null;
                in = new BufferedReader(new InputStreamReader(socket.getInputStream(), encoding));
                out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), encoding));

                System.out.println(Thread.currentThread().getName());
                line = in.readLine();
                if ("bye".equals(line)) {
                    System.out.println(name + "断开链接");
                    out.close();
                    in.close();
                    socket.close();
                }
                System.out.println("服务器收到信息:" + name + ":" + line);
                out.print(line);
                for (Socket s : SocketTest1.socketList) {
                    PrintStream print = null;
                    try {
                        if (socket != s) {
                            print = new PrintStream(s.getOutputStream());
                            print.println(name + ":" + line);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                out.print(line);
                out.flush();

            } catch (IOException e) {
                e.printStackTrace();
            }
    }




}

