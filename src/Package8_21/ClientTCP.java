package Package8_21;

import sun.nio.cs.ext.ISO2022_CN;

import java.io.*;
import java.net.Socket;

public class ClientTCP {

    public static void main(String[] args) {
        String host ="127.0.0.1";
        int port = 8888;
        Socket socket =  null;
        String encoding = "UTF-8";
        PrintWriter out =  null;
        BufferedReader in = null;
        FileReader inFile= null;
        FileInputStream fis = null;

//      BufferedReader inFromConsole = null;
        try {
            socket = new Socket(host,port);
            //能不能创建socket对象 代表着是否连接成，失败会抛异常
            System.out.println("客户端启动");
        /*
            OutputStream os = socket.getOutputStream(); //字节输出流
            OutputStreamWriter osw = new OutputStreamWriter(os,"UTF-8");//将字节输出变为字符输出
            PrintWriter pw = new PrintWriter(osw);//将osw包裹
*/
            in = new BufferedReader(new InputStreamReader(socket.getInputStream(),encoding));
            out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),encoding));


            OutputStream os = socket.getOutputStream(); //字节输出流
            File file =new File("C:\\Users\\破碎\\Desktop\\大失败.png");
            fis = new FileInputStream(file);
            int len = -1;
            byte[] bytes = new byte[1024];
            while((len = fis.read(bytes))!=-1){
                os.write(bytes,0,len);
                os.flush();
            }

//            inFromConsole = new BufferedReader(new InputStreamReader(System.in));

//            String lineConlose = null;
//            String lineServer = null;
//            while (lineConlose!=null){
//                out.print(lineConlose);
//                out.flush();
//                lineServer=in.readLine();
//
//
//            }

//            out.print("你好程序员");
//            out.flush();
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
